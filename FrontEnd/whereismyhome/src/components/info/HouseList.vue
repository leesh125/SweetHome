<template>
  <div class="house-list">
    <b-list-group class="list-group">
      <b-list-group-item v-if="houseList.length == 0" name=""
        >아파트가 존재하지 않습니다.</b-list-group-item
      >
      <template v-else>
        <b-list-group-item
          v-for="house in houseList"
          :key="house.aptCode"
          href="#"
          class="flex-column align-items-start"
        >
          <div class="d-flex w-100 justify-content-between">
            <h3 class="mb-1 houseName"><span style="text-align:left"><i class="fa fa-home" aria-hidden="true"></i>{{ house.aptName }}</span> <div style="margin-left: 18.5px;">아파트</div></h3>
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
              <small class="trade-search" :id="house.aptCode" @click="openDetail($event)">거래내역 조회 ></small>
            </div>
            <small><i class="fa fa-heart" aria-hidden="true" style="color:red;"></i> {{ house.likeNumber }}</small>
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

@import "../../assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css"; 
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

.house-list > div a {
  background-color: rgb(255, 255, 255);
  cursor: auto;
}

.house-list > div a:hover {
  background-color: #e3eeff;
  transition: all 0.5s;
}

.trade-search {
  --s: 0.1em;   /* the thickness of the line */
  --c: #2c4bff; /* the color */
  
  color: #0000;
  padding-bottom: var(--s);
  background: 
    linear-gradient(90deg,var(--c) 50%,#000 0) calc(100% - var(--_p,0%))/200% 100%,
    linear-gradient(var(--c) 0 0) 0% 100%/var(--_p,0%) var(--s) no-repeat;
  -webkit-background-clip: text,padding-box;
          background-clip: text,padding-box;
  transition: 0.5s;
  font-family: system-ui, sans-serif;
  font-size: 1rem;
  cursor: pointer;
}

.houseName{
  color: rgb(34, 34, 34);
  font-size: 20px;
  font-weight: 700;
  width: 150px;
  text-align: left;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.trade-search:hover {--_p: 100%}


</style>
