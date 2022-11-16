
<template>
  <div>
    <h1>Map Test</h1>
    <kakao-map></kakao-map>
  </div>
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