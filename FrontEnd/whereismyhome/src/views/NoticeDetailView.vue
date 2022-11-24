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
                <div class="hit">조회수 : {{hit}}</div>
                <div class="noticeNo">공지번호 : {{no}}</div>
                <img class="d-flex g-width-50 g-height-50 rounded-circle g-mt-3 g-mr-15" src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Image Description">
                <div class="media-body u-shadow-v18 g-bg-secondary g-pa-30">
                  <div class="g-mb-15">
                    <div style="display: flex;">
                      <h5 class="h5 g-color-gray-dark-v1 mb-0">제목: </h5>
                      <input type="text" :value="subject" class="title" disabled/>
                    </div>
                  </div>
                  <div class="g-mb-15">
                    <div style="display: flex;">
                      <h5 class="h5 g-color-gray-dark-v1 mb-0">내용: </h5>
                      <textarea class="textarea" :value="content" disabled/>
                    </div>
                  </div>
                  <div class="g-mb-15">
                    <div style="display: flex;">
                      <h5 class="h5 g-color-gray-dark-v1 mb-0">작성일: </h5>
                      <input type="text" :value="createDate" class="title" disabled />
                    </div>
                  </div>

                  <ul class="list-inline d-sm-flex my-0">
                    <li class="list-inline-item g-mr-20">
                      <a class="u-link-v5 g-color-gray-dark-v4 g-color-primary--hover" style="text-decoration: none;">
                        <div style="display: flex; align-items: center;">
                          <label class="like">
                            <input class="diffInput" type="checkbox" />
                            <div class="hearth" v-on:click="like"/>
                          </label> 
                          <span class="likeCnt">{{count}}</span>
                        </div>
                      </a>
                    </li>
                    <div class="crud-notice">
                      <a style="text-decoration: none;" @click="updateNotice">
                        <button class="bn54" style="background-color: rgb(255 191 0); border: 1px solid rgb(255 191 0);">
                          <span class="bn54span">수정하기</span>
                        </button>
                      </a>
                      <a style="text-decoration: none;" @click="deleteNotice">
                        <button class="bn54" style="background-color: #dc3545; border: 1px solid #dc3545;">
                          <span class="bn54span">삭제하기</span>
                        </button>
                      </a>
                      <a style="text-decoration: none;" @click="toNoticeList">
                        <button class="bn54">
                          <span class="bn54span">목록으로</span>
                        </button>
                      </a>
                    </div>
                  </ul>
                </div>
            </div>
        </div>

    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import Vue from 'vue';
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.use(VueSweetalert2);

export default {
    name: 'noticeDetail',
    data() {
      return {
        count: 1,
        flag: false,
      };
    },
    props: {
        no: {
          type: Number,
          default : 0
        },
        subject: {
            type: String,
            default : ''
        },
        content: {
            type: String,
            default : ''
        },
        createDate: {
          type: String,
          default: ''
        },
        hit: {
          type: Number,
          default: 0
        },
  },
  methods: {
    like() {
      if (this.flag) {
        this.flag = false;  
      } else {
        this.flag = true;   
      }
    },
    toNoticeList() {
      this.$router.push(`/notice`);
    },
    deleteNotice() {
      this.$swal({
        title: "정말 삭제하시겠습니까?",
        text: "한 번 삭제하면 되돌릴 수 없습니다.",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
      })
        .then((result) => {
          if (result.isConfirmed) {
          http.delete(`/notices/${this.no}`)
          .then(
            this.$swal({
              icon: 'success',
              title: `게시글이 삭제되었습니다`,
            }))
          .then(this.$router.push('/notice'));
        }
      });
    },
    updateNotice() {
      this.$router.push({
        name: 'noticeUpdate',
        query: {no: this.no}
      });
    }
  },
  watch: {
    flag: function (newValue) {
      if (newValue) {
        this.count++;
      } else {
        this.count--;
      }
    }
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

.hit{
  position: absolute;
  right: 30px;
  top: 10px;
  font-size: 16px;
  font-weight: 600;
  color: #42B983;
}
@media (min-width: 0) {
    .g-mr-15 {
        margin-right: 1.07143rem !important;
    }
}
@media (min-width: 0){
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

@media (min-width: 0){
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
  margin-top:20px;
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
  width: 70px;
}
.title {
  width: 80%;
  margin: 0 auto;
  box-shadow: 0 6px 10px 0 rgba(0, 0, 0, .1);
  border: 0.5px solid rgb(218, 218, 218);
  line-height: 2.5;
  font-weight: 600;
  font-size: 20px;
  padding-left: 20px;
}
.textarea{
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

.crud-notice{
  display: flex;
}

.crud-notice > a{
  margin: 0 5px;
}
</style>
