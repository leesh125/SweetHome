<template>
  <div>
    <div id="map" style="width: 100%; height: 91vh"></div>
  </div>
</template>

<script>
export default {
  name: "KakaoMap",

  props: {
    sideBarOpen: {
      type: Boolean
    },
  },

  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=b482a1a4c934ed9046dae64f612a7a87";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.57296414303036, 126.97683081861129),
        level: 3,
      };
      this.map = new kakao.maps.Map(container, options);
    },
  },
  watch: {
    sideBarOpen() {
      this.map.relayout();
    }
  }
};
</script>

<style scoped>

</style>
