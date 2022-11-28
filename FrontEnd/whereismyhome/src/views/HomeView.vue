<template>
  <div class="main">
    <div class="inner-div">
      <div class="inner-div-letter">어떤 집을 찾고 계신가요?</div>
      <search-house></search-house>
    </div>
  </div>
</template>

<script>
import SearchHouse from "@/components/SearchHouse.vue";

export default {
  name: "HomeView",
  components: {
    SearchHouse,
  },
};
</script>

<style scoped>
.main {
  width: 100%;
  height: 790px;
  margin: 0 auto;
  background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url(http://127.0.0.1:9000/img/home.ea4c7b30.jpg);
  background-repeat: no-repeat;
  background-position: center;
  background-size: 1920px 790px;
}

.inner-div {
  z-index: 2;
}

.inner-div-letter {
  color: #fff;
  font-weight: 600;
  font-size: 2.3em;
  margin-bottom: 20px;
  letter-spacing: 5px;
  padding-top: 260px;
}
</style>
