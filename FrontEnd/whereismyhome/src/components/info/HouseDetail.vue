<template>
  <div class="list-group">
    <button @click="closeDetail">close</button>
    <b-card
      :title="aptDetail.aptName + ' 아파트'"
      :img-src=" require('../../assets/img/apt_sample.jpg')"
      img-alt="Image"
      img-top
      tag="article"
      style="max-width: 100%;"
      class="mb-2"
    >
    <b-card-text>
      {{aptDetail.baseAddressDto.sidoName}} {{aptDetail.baseAddressDto.gugunName}} {{aptDetail.baseAddressDto.dongName}} {{aptDetail.jibun}} 
    </b-card-text>
    <small>🧡 {{ aptLikeNumber }}</small>
    <button @click="like">좋아요</button>
  </b-card>
  <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <div block v-b-toggle.accordion-2 variant="info">거래 내역</div>
      </b-card-header>
      <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
        <b-card-body style="padding: 0;">
          <b-list-group >
            <b-list-group-item
              v-for="dealInfo in aptDetail.houseDealDtos"
              :key="dealInfo.no"
              class="flex-column align-items-start" 
            >
            <div class="d-flex w-100 justify-content-between">
              <small>{{dealInfo.dealYear}}년 {{dealInfo.dealMonth}}월 {{dealInfo.dealDay}}일</small>
              <h3>{{dealInfo.dealAmount}}</h3>만원
            </div>
            </b-list-group-item>
          </b-list-group>
        </b-card-body>
      </b-collapse>
  </b-card>
  </div>
</template>

<script>
import http from "@/util/http-common";


export default {
  name: 'HouseDetail',
  props: {
    aptDetail:{}
  },
  data() {
    return {
      aptAddress: "",
      aptLikeNumber: 0,
      aptImgUrl:"",
    };
  },
  created () {

  },
  mounted() {
    this.getLikeNumber();
  },
  updated () {
    this.getLikeNumber();
  },
  methods: {
    closeDetail() {
      this.$emit('closeDetail');
    },
    getLikeNumber() {
      console.log(this.aptDetail.aptCode)
      http.get(`/houses/${this.aptDetail.aptCode}/like`)
      .then(({ data }) => {
        this.aptLikeNumber = data;
    })
    },
    like() {
      const userId = this.$store.getters.loginUser.userId;
      const aptCode = this.aptDetail.aptCode;
      console.log(`/houses/${aptCode}/like/${userId}`);
      http.post(`/houses/${aptCode}/like/${userId}`).then(({ data }) => {
        this.aptLikeNumber = data;
        for (let i = 0; i < this.$store.getters.searchHouseList.length; i++){
          if (this.$store.getters.searchHouseList[i].aptCode == aptCode) {
            this.$store.state.searchHouseList[i].likeNumber = data;
            return;
          }
        }
      }).catch(() => {
        alert("이미 좋아요를 눌렀습니다.");
      })
    }

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
</style>