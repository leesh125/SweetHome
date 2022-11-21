<template>
  <div>
    <div id="map" style="width: 100%; height: 91vh"></div>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "KakaoMap",
  data() {
    return {
      map: null,
      currentLocationPage: 0,
      searchWord: "",
      locationCode: "",
      currLat: "",
      currLng: ""
    };
  },
  props: {
    sideBarOpen: {
      type: Boolean,
    },
    params: {
      type: Object,
    },
  },
  created () {
    
  },
  mounted() {
    //맵 생성
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      console.log("여기를 들어온다고!??")
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=b482a1a4c934ed9046dae64f612a7a87&libraries=services";
      document.head.appendChild(script);
    }

 

    ///////////////여기서 부터 지도에 표시할 마커 설정해야됨//////////////////
  },

  methods: {
    initMap() {
      const container = document.getElementById("map");

      const location = new kakao.maps.LatLng(37.4812845080678, 126.952713197762);
      const options = {
        center: location,
        level: 3,
      };
      this.map = new kakao.maps.Map(container, options);

      kakao.maps.event.addListener(this.map, 'dragend', () => {
        var latlng = this.map.getCenter(); 
        this.currLat = latlng.getLat();
        this.currLng = latlng.getLng();
      });



      const params = this.$route.params;
      // 홈화면 검색으로 이동했을 경우(params 존재)
      if (Object.keys(params) != 0) {
        this.searchWord = this.$route.params.word;
        this.locationCode = params.sido + params.gugun + params.dong;

        http.get(`/address/latlng/${this.locationCode}`).then(({ data }) => {
          this.currLat = data.lat;
          this.currLng = data.lng;
          const location = new kakao.maps.LatLng(this.currLat, this.currLng);
          this.map.setCenter(location);
        });
      } else {
        //네비게이션 바를 통해 이동했을 경우(params 존재 X)
        console.log("from nav bar ...")
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition((position) => {
            var lat = position.coords.latitude,
              lng = position.coords.longitude;

            this.currLat = position.coords.latitude;
            this.currLng = position.coords.longitude;
            const location = new kakao.maps.LatLng(lat, lng);

            this.map.setCenter(location);
            
            var marker = new kakao.maps.Marker({
              map: this.map, // 마커를 표시할 지도
              position: location, // 마커를 표시할 위치
              title: "현재 위치", // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            });
            marker.setMap(this.map);



            this.getDongCode(lat, lng);
          }, (err) => {console.log(err)},{enableHighAccuracy:true});
        }
      }
    },

    searchHouse() {
      http.get(`/houses?locationCode=${this.locationCode}&searchOrder=${this.currentLocationPage}`);

    },
    getDongCode(lat, lng) {
      var geocoder = new kakao.maps.services.Geocoder();
      var callback = (result, status) => {
        console.log(result)
        if (status === kakao.maps.services.Status.OK) {
          this.locationCode = result[0].code;
        }
      };
      geocoder.coord2RegionCode(lng, lat, callback);
    },

    drawMarkers() {
      http.get(`/houses?locationCode=${this.locationCode}&searchWord=${this.searchWord}`)
        .then(({ data }) => {
          return data.map((x) => {
            return {
              title: x.aptName,
              latlng: new kakao.maps.LatLng(x.lat, x.lng),
            };
          });
        }).then(aptList => {
          var imageSrc = require('@/assets/img/apartment.png');
          for (let i = 0; aptList.length; i++) {
            // 마커 이미지의 이미지 크기 입니다
            var imageSize = new kakao.maps.Size(35, 35);
            // 마커 이미지를 생성합니다
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
            console.log(this);
            var marker = new kakao.maps.Marker({
              map: this.map, // 마커를 표시할 지도
              position: aptList[i].latlng, // 마커를 표시할 위치
              title: aptList[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
              image: markerImage, // 마커 이미지
            });
            marker.setMap(this.map);
          }
        }
      );
    }
  },

  watch: {
    sideBarOpen() {
      this.map.relayout();
      this.map.setCenter(new kakao.maps.LatLng(this.currLat, this.currLng));
    },
    locationCode() {
      this.drawMarkers();
    }
  },
};
</script>

<style scoped>

</style>
