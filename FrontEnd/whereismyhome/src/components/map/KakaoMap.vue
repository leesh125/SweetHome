<template>
  <div>
    <div id="map" style="width: 100%; height: 91vh"></div>
  </div>
</template>

<script>
import Http from "@/util/http-common";

export default {
  name: "KakaoMap",
  data() {
    return {
      map: null,
      currentLocationPage: 0,
      searchWord: "",
      locationCode: "",
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

  mounted() {
    const params = this.$route.params;
    if (Object.keys(params) != 0) {
      // 홈화면 검색으로 이동했을 경우(params 존재)
      this.searchWord = this.$route.params.word;
      this.locationCode = params.sido + params.gugun + params.dong;
      console.log("검색어 : " + this.searchWord);
      console.log("locationCode : " + this.locationCode);
    } else {
      //메뉴를 통해 이동했을 경우(params 존재 X)
    }

    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=b482a1a4c934ed9046dae64f612a7a87&libraries=services";
      document.head.appendChild(script);
    }
  },

  methods: {
    initMap() {
      const container = document.getElementById("map");

      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position) => {
          var lat = position.coords.latitude,
            lng = position.coords.longitude;
          const location = new kakao.maps.LatLng(lat, lng);
          const options = {
            center: location,
            level: 3,
          };
          this.map = new kakao.maps.Map(container, options);

          this.getRegion(lat, lng);
        });
      } else {
        const location = new kakao.maps.LatLng(37.4812845080678, 126.952713197762);
        const options = {
          center: location,
          level: 3,
        };
        this.map = new kakao.maps.Map(container, options);
      }
    },

    getRegion(lat, lng) {
      var geocoder = new kakao.maps.services.Geocoder();
      var callback = (result, status) => {
        if (status === kakao.maps.services.Status.OK) {
          console.log("지역 명칭 : " + result[0].address_name);
          console.log("행정구역 코드 : " + result[0].code);
        }

        Http.get(`/houses?locationCode=${result[0].code}&searchOrder=${this.currentLocationPage}`)
          .then(({ data }) => {
            return data.map((x) => {
              return {
                title: x.aptName,
                latlng: new kakao.maps.LatLng(x.lat, x.lng),
              };
            });
          })
          .then((aptList) => {
            var imageSrc =
              "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

            for (let i = 0; aptList.length; i++) {
              // 마커 이미지의 이미지 크기 입니다
              var imageSize = new kakao.maps.Size(24, 35);

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
          });
      };

      geocoder.coord2RegionCode(lng, lat, callback);
    },
  },

  watch: {
    sideBarOpen() {
      this.map.relayout();
    },
  },
};
</script>

<style scoped></style>
