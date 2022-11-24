<template>
  <!-- <div>
    <h1>name: {{ $route.params.no }}</h1>
    <h1>first_name: {{ $route.params.first_name }}</h1>
    <h1>last_name: {{ $route.params.last_name }}</h1>
    <hr>
    <h1>no: {{ no }}</h1>
    <h1>first_name: {{ first_name }}</h1>
    <h1>last_name: {{ last_name }}</h1>
  </div> -->
  <div class="container">
    <div class="row">
      <div class="col-md-8">
        <div class="media g-mb-30 media-comment">
          <img class="d-flex g-width-50 g-height-50 rounded-circle g-mt-3 g-mr-15"
            src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Image Description">
          <div class="media-body u-shadow-v18 g-bg-secondary g-pa-30">
            <div class="g-mb-15">
              <div style="display: flex; justify-content: center;">
                <h5 class="h5 g-color-gray-dark-v1 mb-0">이름: </h5>
                <input type="text" :value="name" class="title" disabled />
              </div>
            </div>
            <div class="g-mb-15">
              <div style="display: flex; justify-content: center;">
                <h5 class="h5 g-color-gray-dark-v1 mb-0">아이디: </h5>
                <input type="text" :value="userId" class="title" disabled />
              </div>
            </div>
            <div class="g-mb-15">
              <div style="display: flex; justify-content: center;">
                <h5 class="h5 g-color-gray-dark-v1 mb-0">전화번호: </h5>
                <input type="text" :value="phoneNumber" class="title" disabled />
              </div>
            </div>

          </div>
        </div>
      </div>

    </div>
  </div>
</template>

<script scoped>
import http from "@/util/http-common";
import Vue from 'vue';
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.use(VueSweetalert2);

export default {
  name: 'noticeDetail',
  data() {
    return {
      name: '',
      userId: '',
      phoneNumber: ''
    };
  },
  created() {
    http.get(`/users/${this.$store.getters.loginUser.userId}`)
      .then(({ data }) => {
        this.userId = data.userId,
        this.name = data.name,
        this.phoneNumber = data.phoneNumber
    })
  },
  methods: {
    
  },
}
</script>

<style scoped>
@import "../assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css";

.noticeNo {
  position: absolute;
  left: 60px;
  top: 10px;
  font-size: 20px;
  font-weight: 600;
  color: #42B983;
}

.hit {
  position: absolute;
  right: 30px;
  top: 10px;
  font-size: 16px;
  font-weight: 600;
  color: #42B983;
}

@media (min-width: 0) {
  .g-mr-15 {
    margin: 0 auto;
  }
}

@media (min-width: 0) {
  .g-mt-3 {
    margin-top: 0.21429rem !important;
  }
}

.g-height-50 {
  height: 50px;
}

.g-width-50 {
  width: 50px !important;
}

@media (min-width: 0) {
  .g-pa-30 {
    padding: 2.14286rem !important;
  }
}

.g-bg-secondary {
  background-color: #fafafa !important;
}

.u-shadow-v18 {
  text-align: left;
  box-shadow: 0 16px 24px 2px rgb(0 0 0 / 14%), 0 6px 30px 5px rgb(0 0 0 / 12%), 0 8px 10px -5px rgb(0 0 0 / 20%);
}

.g-color-gray-dark-v4 {
  color: #777 !important;
}

.g-font-size-12 {
  font-size: 0.85714rem !important;
}

.media-comment {
  margin-top: 20px;
  position: relative;
}

.row {
  display: inline-block;
  width: 950px
}

.col-md-8 {
  width: 100%;
}

.h5 {
  line-height: 2.5;
  margin-left: 20px;
  font-weight: 800;
  width: 110px;
}

.title {
  margin: 0;
  border-style: none;
  line-height: 2.5;
  font-weight: 600;
  font-size: 20px;
  padding-left: 20px;
}

.textarea {
  width: 80%;
  margin: 0 auto;
  height: 500px;
  line-height: 2;
  box-shadow: 0 6px 10px 0 rgba(0, 0, 0, .1);
  border: 0.5px solid rgb(218, 218, 218);
  font-weight: 400;
  font-size: 18px;
  padding-left: 20px;
}

.g-mb-15 {
  margin: 20px 0;
}

.diffInput {
  display: none;
}

.like {
  display: block;
  width: 80px;
  height: 80px;
  cursor: pointer;
  border-radius: 999px;
  overflow: visible;
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  -webkit-tap-highlight-color: transparent;
}

.hearth {
  background-image: url('https://assets.codepen.io/23500/Hashflag-AppleEvent.svg');
  background-size: calc(80px * 62) 80px;
  background-repeat: no-repeat;
  background-position-x: calc(80px * (62 * -1 + 2));
  background-position-y: calc(80px * 0.02);
  width: 80px;
  height: 80px;
}

input:checked+.hearth {
  animation: like 1s steps(calc(62 - 3));
  animation-fill-mode: forwards;
}

@keyframes like {
  0% {
    background-position-x: 0;
  }

  100% {
    background-position-x: calc(80px * (62 * -1 + 3));
  }
}

@media (hover: hover) {
  .like:hover {
    background-color: #e1255e 15;
  }

  .like:hover .hearth {
    background-position-x: calc(80px * (62 * -1 + 1));
  }
}

.likeCnt {
  font-size: 20px;
}

.bn54 {
  position: relative;
  outline: none;
  text-decoration: none;
  border-radius: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  text-transform: uppercase;
  height: 45px;
  width: 130px;
  opacity: 1;
  background-color: #42B983;
  border: 1px solid #349b6d;
}

.bn54 .bn54span {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  color: #ffffff;
  font-size: 16px;
  font-weight: 600;
  letter-spacing: 0.7px;
}

.bn54:hover {
  animation: bn54rotate 0.7s ease-in-out both;
}

.bn54:hover .bn54span {
  animation: bn54storm 0.7s ease-in-out both;
  animation-delay: 0.06s;
}

@keyframes bn54rotate {
  0% {
    transform: rotate(0deg) translate3d(0, 0, 0);
  }

  25% {
    transform: rotate(3deg) translate3d(0, 0, 0);
  }

  50% {
    transform: rotate(-3deg) translate3d(0, 0, 0);
  }

  75% {
    transform: rotate(1deg) translate3d(0, 0, 0);
  }

  100% {
    transform: rotate(0deg) translate3d(0, 0, 0);
  }
}

@keyframes bn54storm {
  0% {
    transform: translate3d(0, 0, 0) translateZ(0);
  }

  25% {
    transform: translate3d(4px, 0, 0) translateZ(0);
  }

  50% {
    transform: translate3d(-3px, 0, 0) translateZ(0);
  }

  75% {
    transform: translate3d(2px, 0, 0) translateZ(0);
  }

  100% {
    transform: translate3d(0, 0, 0) translateZ(0);
  }
}

.d-sm-flex {
  justify-content: space-between;
  align-items: center;
}

.crud-notice {
  display: flex;
}

.crud-notice>a {
  margin: 0 5px;
}
</style>
