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
      <select class="col-sm-4 mt-2" @change="selectSido($event)" v-model="sidoPicked">
        <option value="" selected>시도 선택</option>
        <option v-for="(sido,index) in sidos" :key="index" :value="sido.sidoCode">
          {{ sido.sidoName }}
        </option>
      </select>
      <select class="col-sm-4 mt-2" @change="selectGugun($event)" v-model="gugunPicked">
        <option value="" selected>구군 선택</option>
        <option v-for="gugun in guguns" :key="gugun.gugunCode" :value="gugun.gugunCode">
          {{ gugun.gugunName }}
        </option>
      </select>
      <select class="col-sm-4 mt-2" @change="selectDong($event)" v-model="dongPicked">
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
import eventBus from "@/components/EventBus.vue"

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
      sidoPicked:"",
      gugunPicked:"",
      dongPicked: "",
      currAddress: {
        sido: "",
        gugun: "",
        dong: "",
      }
    };
  },
  created() {
    eventBus.$on('getCurrentAddress', () => {
      eventBus.$emit('addInterest', {
        name: (this.currAddress.sido + " " + this.currAddress.gugun + " " + this.currAddress.dong).trim(),
        search: this.search
      })
    });
  },
  mounted() {
    http.get("/address").then(({ data }) => {
      console.log(data);
      this.sidos = data;
      this.sidos.map((x) => x.sidoCode = x.sidoCode.substr(0, 2));
    }).then(() => {
      return this.$store.getters.search;
    }).then((search) => {
      this.search = search; 

      this.search.word = search.word;
      if (search.sidoCode) {
        this.sidoPicked = search.sidoCode;
        http.get(`/address/${search.sidoCode}`).then(({ data }) => {

          this.guguns = data;
          this.guguns.map((x) => x.gugunCode = x.gugunCode.substr(2, 3));

          if (search.gugunCode) {
            console.log(search.gugunCode);
            this.gugunPicked = search.gugunCode;
            http.get(`/address/${search.sidoCode}/${search.gugunCode}`).then(({ data }) => {
              this.dongs = data;
              this.dongs.map((x) => x.dongCode = x.dongCode.substr(5));
              if (search.dongCode) {
                this.dongPicked = search.dongCode;
              }
            });
          }
        });
      }
    })
  },
  methods: {
    selectSido(event) {
      this.guguns = [];
      this.dongs = [];
      this.search.gugunCode = "";
      this.search.dongCode = "";
      this.currAddress.gugun = "";
      this.currAddress.dong = "";


      let sidoCode = event.target.value; // 선택한 시,도
      this.currAddress.sido = event.target.options[event.target.selectedIndex].text;
      if (sidoCode == "") {
        this.search.sidoCode = "";
        return;
      }
      this.search.sidoCode = sidoCode;
      http.get(`/address/${this.search.sidoCode}`).then(({ data }) => {
        this.guguns = data;
        this.guguns.map((x) => x.gugunCode = x.gugunCode.substr(2, 3));
      });
    },
    selectGugun(event) {
      this.search.dongCode = "";
      this.currAddress.dong = "";
      this.dongs = [];

      let gugunCode = event.target.value;
      this.currAddress.gugun = event.target.options[event.target.selectedIndex].text;

      if (gugunCode == "") {
        this.search.gugunCode = "";
        return;
      }

      this.search.gugunCode = gugunCode;
      http.get(`/address/${this.search.sidoCode}/${this.search.gugunCode}`).then(({ data }) => {
        this.dongs = data;
        this.dongs.map((x) => x.dongCode = x.dpmgCode.substr(5));
      });
    },
    selectDong(event) {
      let dongCode = event.target.value;
      this.currAddress.dong = event.target.options[event.target.selectedIndex].text;
      console.log(dongCode)
      this.search.dongCode = dongCode;
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
