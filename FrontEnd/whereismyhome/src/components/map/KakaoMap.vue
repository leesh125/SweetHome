<template>
  <div>
    <div id="map" style="width: 100%; height: 91vh"></div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import overlay from "@/util/marker-overray";

export default {
  name: "KakaoMap",
  data() {
    return {
      map: null,
      searchWord: "",
      locationCode: "",
      currLat: "37.4812845080678",
      currLng: "126.952713197762",

      regionCode: "",
      currMarkers: [],
      currOverlays: [],
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
  created() {

  },
  mounted() {
    let search = this.$store.getters.search;
    const loactionCode = search.sidoCode + search.gugunCode + search.dongCode;
    console.log(search);
    if (loactionCode + search.word == "") {
      console.log("검색이아니군");
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
          (position) => {
            this.currLat = position.coords.latitude;
            this.currLng = position.coords.longitude;

            var geocoder = new kakao.maps.services.Geocoder();
            var coord = new kakao.maps.LatLng(this.currLat, this.currLng);


            geocoder.coord2RegionCode(coord.getLng(), coord.getLat(), (result, status) => {
              if (status === kakao.maps.services.Status.OK) {
                console.log(result[0].code);
                search.sidoCode = result[0].code.substr(0, 2);
                search.gugunCode = result[0].code.substr(2, 3);
                search.dongCode = result[0].code.substr(5);
              }
            });
          },
          (err) => {
            console.log(err);
          },
          { enableHighAccuracy: true }
        );
      }
    } else {
      console.log("검색이군");
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
    this.$store.dispatch("searchHouse", search);
    this.searchHouseList();
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

      kakao.maps.event.addListener(this.map, "dragend", () => {
        var latlng = this.map.getCenter();
        this.currLat = latlng.getLat();
        this.currLng = latlng.getLng();
      });

      //네비게이션 바를 통해 이동했을 경우(params 존재 X)
      console.log("from nav bar ...");
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
          (position) => {
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
          },
          (err) => {
            console.log(err);
          },
          { enableHighAccuracy: true }
        );
      }
    },
    getDongCode(lat, lng) {
      let geocoder = new kakao.maps.services.Geocoder();
      let callback = function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          this.locationCode = result[0].code;
        }
      };
      geocoder.coord2RegionCode(lng, lat, callback);
    },
    initMarkers() {
      for (const marker of this.currMarkers) {
        marker.setMap(null);
      }
      for (const overlay of this.currOverlays) {
        overlay.setMap(null);
      }
      this.currMarkers = [];
      this.currOverlays = [];
    },
    drawMarkers(houseList) {
      this.initMarkers();

      if (houseList.length == 0) {
        return;
      }

      const aptList = houseList.map((x) => {
        let apt = {
          title: x.aptName,
          latlng: new kakao.maps.LatLng(x.lat, x.lng),
          data: x,
        };
        return apt;
      });

      var imageSrc = require("@/assets/img/apartment.png");
      // 마커 이미지의 이미지 크기 입니다
      let imageSize = new kakao.maps.Size(35, 35);
      // 마커 이미지를 생성합니다
      let markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
      for (let i = 0; i < aptList.length; i++) {
        let marker = new kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: aptList[i].latlng,
          title: aptList[i].title,
          image: markerImage, // 마커 이미지
        });

        const customOverlay = new kakao.maps.CustomOverlay({
          content: overlay(aptList[i].data), // 인포윈도우에 표시할 내용
          position: aptList[i].latlng,
          yAnchor: 1.4,
          zIndex: 310000,
        });

        customOverlay.setMap(this.map);

        kakao.maps.event.addListener(marker, "click", () => {
          customOverlay.setMap(this.map);
        });

        kakao.maps.event.addListener(this.map, "click", () => {
          customOverlay.setMap(null);
        });

        marker.setMap(this.map);
        this.currMarkers.push(marker);
        this.currOverlays.push(customOverlay);
      }
    },
  },
  computed: {
    searchHouseList() {
      return this.$store.getters.searchHouseList;
    },
    // kakaoMap() {
    //   return this.$store.getters.kakaoMap;
    // }
  },

  watch: {
    // kakaoMap() {
    //   this.drawMarkers(this.$store.getters.searchHouseList);
    //   this.locationCode = this.$store.getters.locationCode;
    //   http.get(`/address/latlng/${this.locationCode}`).then(({ data }) => {
    //     this.currLat = data.lat;
    //     this.currLng = data.lng;
    //     const location = new kakao.maps.LatLng(this.currLat, this.currLng);
    //     this.map.setCenter(location);
    //   });
    // },
    sideBarOpen() {
      this.map.relayout();
      this.map.setCenter(new kakao.maps.LatLng(this.currLat, this.currLng));
    },
    searchHouseList(newValue) {
      this.drawMarkers(newValue);
      this.locationCode = this.$store.getters.locationCode;
      http.get(`/address/latlng/${this.locationCode}`).then(({ data }) => {
        this.currLat = data.lat;
        this.currLng = data.lng;
        const location = new kakao.maps.LatLng(this.currLat, this.currLng);
        this.map.setCenter(location);
    });

    },
  },
};
</script>

<style scoped></style>
