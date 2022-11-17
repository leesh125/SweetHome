
<template>
  <b-container fluid>
    <b-row>
      <b-col cols="1" class="map-comp">asdf</b-col>
      <b-col class="map-comp">
        <kakao-map></kakao-map>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import KakaoMap from "../components/map/KakaoMap.vue";
export default {
  name: 'HomeView',
  components: {
    KakaoMap
  }
}
</script>

<style scoped>
.map-comp { 
  padding: 0;
}
</style>