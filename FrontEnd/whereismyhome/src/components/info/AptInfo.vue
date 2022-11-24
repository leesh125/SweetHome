<template>
  <div>
    <apt-search></apt-search>
    <interest-area></interest-area>
    <div>
      <house-list v-if="!detailOpen" @openHouseDetail="openHouseDetail"></house-list>
      <house-detail
        v-else
        @closeDetail="closeDetail"
        :aptDetail="aptDetail"
      ></house-detail>
    </div>
  </div>
</template>

<script>
import AptSearch from "@/components/info/Search.vue";
import InterestArea from "@/components/info/InterestArea.vue";
import HouseList from "@/components/info/HouseList.vue";
import HouseDetail from "@/components/info/HouseDetail.vue";
import http from "@/util/http-common";

export default {
  name: "AptInfo",
  components: {
    AptSearch,
    InterestArea,
    HouseList,
    HouseDetail,
  },

  data() {
    return {
      detailOpen: false,
      aptDetail : {}
    };
  },
  created() {},
  mounted() {},

  methods: {
    closeDetail() {
      this.detailOpen = false;
    },

    openHouseDetail(aptCode) {
      this.detailOpen = true;
      http.get(`/houses/${aptCode}/dealInfos`).then(({ data }) => {
        console.log(data);
        this.aptDetail = data[0];
      });
    },
  },
};
</script>

<style lang="scss" scoped></style>
