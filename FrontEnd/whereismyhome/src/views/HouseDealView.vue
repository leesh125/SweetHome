<template>
  <b-container fluid>
    <b-row>
      <b-col v-if="sideBarOpen" cols="3" class="map-comp">
        <apt-info></apt-info>
        <span class="expand-btn" v-if="sideBarOpen" :style="collapse" @click="reverse"></span>
      </b-col>
      <span class="expand-btn" v-if="!sideBarOpen" :style="expand" @click="reverse"></span>
      <b-col class="map-comp">
        <kakao-map :sideBarOpen="sideBarOpen"></kakao-map>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import KakaoMap from "@/components/map/KakaoMap";
import AptInfo from "@/components/info/AptInfo";

export default {
  name: "HouseDealView",
  components: {
    KakaoMap,
    AptInfo,
  },
  data() {
    return {
      sideBarOpen: true,
    };
  },
  mounted() {},
  methods: {
    reverse() {
      this.sideBarOpen = !this.sideBarOpen;
    },
  },
  computed: {
    collapse() {
      return {
        "background-position": "0 0", // testColor 는 예시 변수명
      };
    },
    expand() {
      return {
        "background-position": "0 -60px",
        left: 0, // testColor 는 예시 변수명
      };
    },
  },
};
</script>

<style scoped>
.map-comp {
  padding: 0;
}

#sidebar-control {
  position: relative;
  width: 3px;
  top: 50%;
  z-index: 10000;
  background-color: grey;
}

.expand-btn {
  overflow: hidden;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 25%;
  margin: auto;
  width: 22px;
  height: 54px;
  font-size: 0;
  line-height: 0;
  background: url(//t1.daumcdn.net/localimg/localimages/07/2018/pc/shadow/img_navi.png) no-repeat 0
    0;
  text-indent: -9999px;
  cursor: pointer;
  z-index: 10000;
  width: 28px;
  height: 66px;
}

.container-fluid {
  background-color: #50be8d;
}
</style>
