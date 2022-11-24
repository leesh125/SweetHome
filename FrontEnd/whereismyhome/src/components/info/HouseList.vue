<template>
  <div>
    <b-list-group class="list-group">
      <b-list-group-item v-if="houseList.length == 0" name=""
        >아파트가 존재하지 않습니다.</b-list-group-item
      >
      <template v-else>
        <b-list-group-item
          v-for="house in houseList"
          :key="house.dongCode"
          href="#"
          class="flex-column align-items-start"
        >
          <div class="d-flex w-100 justify-content-between">
            <h3 class="mb-1">{{ house.aptName }} 아파트</h3>
            <div>
              <small>
                {{ house.baseAddressDto?.sidoName }} {{ house.baseAddressDto?.gugunName }}
                {{ house.baseAddressDto?.dongName }} {{ house.jibun }}
              </small>
              <br />
              <small> {{ house.buildYear }}년 준공 </small>
            </div>
          </div>
          <p></p>
          <div class="d-flex w-100 justify-content-between">
            <div>
              <!-- <h4>최근 거래액 : 10000만</h4> -->
              <small :id="house.aptCode" @click="openDetail($event)">거래내역 조회 ></small>
            </div>
            <small>🧡 {{ house.likeNumber }}</small>
          </div>
        </b-list-group-item>
      </template>
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

  methods: {
    openDetail(event) {
      console.log(event.target.id);

      this.$emit("openHouseDetail", event.target.id);
    },
  },
  computed: {
    searchHouseList() {
      return this.$store.state.searchHouseList;
    },
  },
  watch: {
    searchHouseList(newValue) {
      this.houseList = newValue;
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
