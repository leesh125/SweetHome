<template>
  <div class="list-group">
    <button class="close-btn" @click="closeDetail">close</button>
    <b-card
      :title="aptDetail.aptName + ' 아파트'"
      :img-src=" require('../../assets/img/apt_sample.jpg')"
      img-alt="Image"
      img-top
      tag="article"
      style="max-width: 100%; font-size: 17px; font-weight: 600;"
      class="mb-2"
    >
    <b-card-text>
      {{aptDetail.baseAddressDto.sidoName}} {{aptDetail.baseAddressDto.gugunName}} {{aptDetail.baseAddressDto.dongName}} {{aptDetail.jibun}} 
    </b-card-text>
    <small><i class="fa fa-heart" aria-hidden="true" style="color:red;"></i> {{ aptLikeNumber }}</small>
    <button @click="like" class="bubbly-button">좋아요</button>
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
    bubble() {
      var animateButton = function (e) {

        e.preventDefault;
        //reset animation
        e.target.classList.remove('animate');

        e.target.classList.add('animate');
        setTimeout(function () {
          e.target.classList.remove('animate');
        }, 700);
      };

      var bubblyButtons = document.getElementsByClassName("bubbly-button");

      for (var i = 0; i < bubblyButtons.length; i++) {
        bubblyButtons[i].addEventListener('click', animateButton, false);
      }
    },
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
@import "../../assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css"; 
.list-group {
  margin-top: 20px;
  max-height: 76vh;
  margin-bottom: 10px;
  overflow: scroll;
  -webkit-overflow-scrolling: touch;
}

.card-header:first-child{
  background-color: rgb(104, 147, 255);
  border: 2px solid rgb(104, 147, 255);
  color: #fff;
}

.card-header:first-child:hover{
  background-color: rgb(30, 85, 224);
  border: 2px solid rgb(30, 85, 224);
  transition: all 0.5s;
}

.close-btn{
  background-color: rgb(255, 114, 114);
  border: 1px solid rgb(255, 114, 114);
  color: #fff;
}

.close-btn:hover {
  background-color: rgb(255, 74, 74);
  transition: all 0.3s;
}

.card-title {
  color: rgb(34, 34, 34); font-size: 22px; font-weight: 700;
}
.bubbly-button {
  display: inline-block;
  font-size: 0.8em;
  font-weight: 600;
  -webkit-appearance: none;
  padding: 12px 5px;
  margin-left: 7px;
  color: white;
  appearance: none;
  background-color: rgb(255, 88, 88);
  border-style: none;
  cursor: pointer;
  border-radius: 38%;
  position: relative;
  transition: transform ease-in 0.1s, box-shadow ease-in 0.25s;
  /* box-shadow: 0 1px 1px #318861; */
}

.bubbly-button:hover{
  background-color: rgb(255, 44, 44);
  transform:scale(1.1);
  transition: all 0.5s;
}

.bubbly-button:focus {
  outline: 0;
}

.bubbly-button:before,
.bubbly-button:after {
  position: absolute;
  content: '';
  display: block;
  width: 140%;
  height: 100%;
  left: -20%;
  z-index: 2;
  transition: all ease-in-out 0.5s;
  background-repeat: no-repeat;
}

.bubbly-button:before {
  display: none;
  top: -75%;
  background-image: radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, transparent 20%, #42b983 20%, transparent 30%), radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, transparent 10%, #42b983 15%, transparent 20%), radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, #42b983 20%, transparent 20%);
  background-size: 10% 10%, 20% 20%, 15% 15%, 20% 20%, 18% 18%, 10% 10%, 15% 15%, 10% 10%, 18% 18%;
}

.bubbly-button:after {
  display: none;
  bottom: -75%;
  background-image: radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, transparent 10%, #42b983 15%, transparent 20%), radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, #42b983 20%, transparent 20%), radial-gradient(circle, #42b983 20%, transparent 20%);
  background-size: 15% 15%, 20% 20%, 18% 18%, 20% 20%, 15% 15%, 10% 10%, 20% 20%;
}

.bubbly-button:active {
  transform: scale(0.9);
  box-shadow: 0 2px 25px rgba(255, 0, 130, 0.2);
}

/* .bubbly-button:hover {
  border-bottom: 2px solid #42b983;
} */

.bubbly-button.animate:before {
  display: block;
  animation: topBubbles ease-in-out 0.75s forwards;
}

.bubbly-button.animate:after {
  display: block;
  animation: bottomBubbles ease-in-out 0.75s forwards;
}

@keyframes topBubbles {
  0% {
    background-position: 5% 90%, 10% 90%, 10% 90%, 15% 90%, 25% 90%, 25% 90%, 40% 90%, 55% 90%, 70% 90%;
  }

  50% {
    background-position: 0% 80%, 0% 20%, 10% 40%, 20% 0%, 30% 30%, 22% 50%, 50% 50%, 65% 20%, 90% 30%;
  }

  100% {
    background-position: 0% 70%, 0% 10%, 10% 30%, 20% -10%, 30% 20%, 22% 40%, 50% 40%, 65% 10%, 90% 20%;
    background-size: 0% 0%, 0% 0%, 0% 0%, 0% 0%, 0% 0%, 0% 0%;
  }
}

@keyframes bottomBubbles {
  0% {
    background-position: 10% -10%, 30% 10%, 55% -10%, 70% -10%, 85% -10%, 70% -10%, 70% 0%;
  }

  50% {
    background-position: 0% 80%, 20% 80%, 45% 60%, 60% 100%, 75% 70%, 95% 60%, 105% 0%;
  }

  100% {
    background-position: 0% 90%, 20% 90%, 45% 70%, 60% 110%, 75% 80%, 95% 70%, 110% 10%;
    background-size: 0% 0%, 0% 0%, 0% 0%, 0% 0%, 0% 0%, 0% 0%;
  }
}
</style>