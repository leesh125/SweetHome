<template>
  <div>
    <apt-search></apt-search>
    <interest-area></interest-area>
    <house-list></house-list>
  </div>
</template>

<script>
import AptSearch from '@/components/info/Search.vue';
import InterestArea from "@/components/info/InterestArea.vue";
import HouseList from "@/components/info/HouseList.vue"

export default {
  name: 'AptInfo',
  components: {
    AptSearch,InterestArea,HouseList
  },

  data() {
    return {
      
    };
  },

  mounted() {
    
  },

  methods: {
    
  },
};
</script>

<style lang="scss" scoped>

</style>