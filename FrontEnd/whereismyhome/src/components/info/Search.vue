<template>
  <b-container fluid>
    <b-row>
      <b-col>
        <b-input-group class="mt-3">
          <b-form-input v-model.lazy="search.word"></b-form-input>
          <b-input-group-append>
            <b-button variant="outline-success" @click="searchHouse">search</b-button>
          </b-input-group-append>
        </b-input-group>
      </b-col>
    </b-row>

    <b-row>
      <select class="col-sm-4 mt-2" @change="selectSido($event)">
        <option value="" selected>시도 선택</option>
        <option v-for="sido in sidos" :key="sido.sidoCode" :value="sido.sidoCode">
          {{ sido.sidoName }}
        </option>
      </select>
      <select class="col-sm-4 mt-2" @change="selectGugun($event)">
        <option value="" selected>구군 선택</option>
        <option v-for="gugun in guguns" :key="gugun.gugunCode" :value="gugun.gugunCode">
          {{ gugun.gugunName }}
        </option>
      </select>
      <select class="col-sm-4 mt-2" @change="selectDong($event)">
        <option value="" selected>동 선택</option>
        <option v-for="dong in dongs" :key="dong.dongCode" :value="dong.dongCode">
          {{ dong.dongName }}
        </option>
      </select>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "AptSearch",

  data() {
    return {
      sidos: [],
      guguns: [],
      dongs: [],
      search: {
        word: "",
        sidoCode: "",
        gugunCode: "",
        dongCode: "",
      },
    };
  },
  created() {
    http.get("/address").then(({ data }) => {
      console.log(data);
      this.sidos = data;
    });
  },
  mounted() {},
  methods: {
    selectSido(event) {
      this.guguns = [];
      this.dongs = [];
      this.search.gugunCode = "";
      this.search.dongCode = "";

      let sidoCode = event.target.value; // 선택한 시,도
      if (sidoCode == "") {
        this.search.sidoCode = "";
        return;
      }
      this.search.sidoCode = sidoCode.substr(0, 2);
      http.get(`/address/${this.search.sidoCode}`).then(({ data }) => {
        this.guguns = data;
      });
    },
    selectGugun(event) {
      this.search.dongCode = "";
      this.dongs = [];

      let gugunCode = event.target.value;
      if (gugunCode == "") {
        this.search.gugunCode = "";
        return;
      }
      this.search.gugunCode = gugunCode.substr(2, 3);
      http.get(`/address/${this.search.sidoCode}/${this.search.gugunCode}`).then(({ data }) => {
        this.dongs = data;
      });
    },
    selectDong(event) {
      let dongCode = event.target.value;
      this.search.dongCode = dongCode.substr(5);
    },
    searchHouse() {
      console.log("call searchHouse In Map ....");
      this.$store.dispatch("searchHouse", this.search);
    },
  },
};
</script>

<style scoped>
.selectbox {
  margin-top: 10px;
  padding: 10px;
}
.optionbox {
  position: relative;
  margin-right: 10px;
}
</style>
