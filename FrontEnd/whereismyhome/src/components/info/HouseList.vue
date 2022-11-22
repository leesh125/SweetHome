<template>
  <div>
    <b-list-group class="list-group">
      <b-list-group-item v-if="houseList.length == 0" name=""
        >아파트가 존재하지 않습니다.</b-list-group-item
      >
      <b-list-group-item
        v-else
        v-for="house in houseList"
        :key="house.id"
        href="#"
        class="flex-column align-items-start"
        :name="house.dongCode"
      >
        <div class="d-flex w-100 justify-content-between">
          <h3 class="mb-1">{{ house.aptName }} 아파트</h3>
          <small>
            {{ house.address.sidoName }} {{ house.address.gugunName }} {{ house.address.dongName }}
            {{ house.jibun }} {{ house.buildYear }}년 준공</small
          >
        </div>
        <p></p>
        <div class="d-flex w-100 justify-content-between">
          <div>
            <h4>최근 거래액 : 10000만</h4>
            <small>거래내역 조회 ></small>
          </div>
          <small>찜하기</small>
        </div>
      </b-list-group-item>
    </b-list-group>
  </div>
</template>

<script>
export default {
  name: "HouseList",

  data() {
    return {
      houseList: [],
    };
  },
  created() {
    this.houseList = this.$store.getters.searchHouseList;
  },
  mounted() {},

  methods: {},
  computed: {
    searchHouseList() {
      return this.$store.getters.searchHouseList;
    },
  },
  watch: {
    searchHouseList(newValue) {
      this.houseList = newValue;
      console.log(this.houseList);
    },
  },
};
</script>

<style scoped>
.list-group {
  max-height: 76vh;
  margin-bottom: 10px;
  overflow: scroll;
  -webkit-overflow-scrolling: touch;
}

ul {
  scrollbar-width: none;
  -ms-overflow-style: none;
}
ul::-webkit-scrollbar {
  display: none;
}
</style>
