<template>
  <div>
    <ul style="width: 100%; height: 76vh; overflow: auto">
      <li v-if="houseList.length == 0">아파트가 존재하지 않습니다.</li>
      <li v-else v-for="house in houseList" :key="house.id">
        {{house.aptName}}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'HouseList',

  data() {
    return {
      houseList: [],
    };
  },
  created () {
    this.houseList = this.$store.getters.searchHouseList;
  },
  mounted() {
    
  },

  methods: {
    
  },
  computed: {
    searchHouseList() {
      return this.$store.getters.searchHouseList; 
    }
  },
  watch: {
    searchHouseList(newValue) {
      this.houseList = newValue;
    }
  },
};
</script>

<style lang="scss" scoped>

</style>