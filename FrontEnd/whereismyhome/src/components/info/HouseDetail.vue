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
    <button>좋아요</button>
  </b-card>
  <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-div block v-b-toggle.accordion-2 variant="info">거래 내역</b-div>
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

export default {
  name: 'HouseDetail',
  props: {
    aptDetail: {
      type: String,
    }
  },
  data() {
    return {
      aptAddress: "",
      aptLikeNumber: 0,
      aptImgUrl:"",
    };
  },

  mounted() {
    
  },

  methods: {
    closeDetail() {
      this.$emit('closeDetail');
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
</style>