<template>
  <div>
    <apt-search></apt-search>
    <interest-area></interest-area>
    <div>
      <house-list v-if="!detailOpen"></house-list>
      <house-detail v-else @closeDetail="closeDetail"></house-detail>
    </div>
  </div>
</template>

<script>
import AptSearch from '@/components/info/Search.vue';
import InterestArea from "@/components/info/InterestArea.vue";
import HouseList from "@/components/info/HouseList.vue"
import HouseDetail from "@/components/info/HouseDetail.vue";

export default {
  name: 'AptInfo',
  components: {
    AptSearch,InterestArea,HouseList, HouseDetail
  },

  data() {
    return {
      detailOpen: false
    };
  },
  created () {

  },
  mounted() {
    
  },

  methods: {
    closeDetail() {
      this.detailOpen = false;
    }
  },
};
</script>

<style lang="scss" scoped>

</style>