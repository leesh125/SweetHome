<template>
  <div id="app">
    <div class="nav-border-bottom"></div>
    <nav>
      <div class="nav-div">
        <router-link to="/">HappyHouse</router-link>
        <router-link to="/houseDeal">아파트 매매</router-link>
        <router-link to="/notice">공지사항</router-link>
        <div id="indicator"></div>
      </div>
      <div class="nav-div-right" v-if="isLogin">
        <a><button @click="[bubble(), logout()]" class="bubbly-button isLoginBtn" style="z-index: 0;">로그아웃</button></a>
        <router-link to="/profile"><button @click="bubble" class="bubbly-button isLoginBtn" style="z-index: -1;">내정보</button></router-link>
        <div id="indicator2"></div>
        <span class="welcome-span"><b style="color: #42B983;">{{ name }}</b>님 환영합니다.</span>
      </div>
      <div class="nav-div-right" v-else>
        <router-link to="/register"><button @click="bubble" class="bubbly-button" style="z-index: -1;">회원가입</button></router-link>
        <router-link to="/login"><button @click="bubble" class="bubbly-button" style="z-index: -1;">로그인</button></router-link>
        <div id="indicator2"></div>
      </div>
    </nav>
    <router-view/>
  </div>
</template>

<script>
import Vue from 'vue';
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

import http from "@/util/http-common";

Vue.use(VueSweetalert2);
export default {
  name: 'FrontEndApp',

  data() {
    return {
      name: "",
      userId: ""
    };
  },
  computed: {
    loginUser() {
      return this.$store.getters.loginUser.name;
    },
    isLogin() {
      return this.$store.getters.loginUser.name != '';
    }
  },
  watch: {
    loginUser(newValue) {
      console.log('loginUser', newValue);
      this.name = newValue;
    }
  },
  created() {
    console.log(this.$store.getters.loginUser.name);
    if (this.$store.getters.loginUser.name != '') {
      console.log('login complete');
      let arr = localStorage.getItem("vuex");
      let jsonArr = JSON.parse(arr);
      this.name = jsonArr.loginUser.name;
      this.userId = jsonArr.loginUser.userId;
      this.$store.commit('setIsLogin', true);
    } else {
      console.log('login failed');
      this.$store.commit('setIsLogin', false);
    }
  },
  mounted() {
    
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
    logout() {
      window.localStorage.clear();
      console.log('hi', this.$store.getters.isLogin);
      http.get(`/users/logout`)
        .then(this.$store.commit("logout"))
        .then(this.$store.commit("setIsLogin",false));
      this.$swal({
				icon: 'success',
				title: `다음에 봐요 :)`,
			});  
    },

  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.nav-border-bottom{
  position: absolute;
  top: 75px;
  width: 100%;
  height: 1.5px;
  background-color: #e1e1e1;
}

nav{
  min-height: 75px;
  width: 1000px;
  margin: auto;
  /* border-bottom: 1.5px solid #e1e1e1; */
}

.nav-div {
  position: absolute;
  float: left;
  height: 75px;
  width: 500px;
  line-height: 4.7;
}

.nav-div > a {
  position: relative;
  width: 33.333%;
  font-weight: bold;
  color: #2c3e50;
  padding: 19px 15px 17px;
  text-align: center;
  text-decoration: none;
  font-weight: bold;
  padding: 10px 20px;
  transition: 1s ease color;
}


.nav-div a:before,
.nav-div a:after {
  position: absolute;
  content: "";
  border-radius: 50%;
  transform: scale(0);
  transition: 1s ease transform;
}

.nav-div a:before {
  top: 0;
  left: 10px;
  width: 6px;
  height: 6px;
}

.nav-div a:after {
  top: 5px;
  left: 18px;
  width: 4px;
  height: 4px;
}

.nav-div a:nth-child(2):before {
  background-color: #00e2ff;
}

.nav-div a:nth-child(2):after {
  background-color: #89ff00;
}

.nav-div a:nth-child(3):before {
  background-color: #00e2ff;
}

.nav-div a:nth-child(3):after {
  background-color: #89ff00;
}

/* .nav-div a:nth-child(4):before {
  background-color: purple;
}

.nav-div a:nth-child(4):after {
  background-color: palevioletred;
} */

nav a:hover {
  color: rgb(38, 114, 255);
}

.nav-div a:hover:before,
.nav-div a:hover:after {
  transform: scale(1);
}

/* nav a:nth-child(2):hover~#indicator {
  background: linear-gradient(130deg, yellow, red);
} */

.nav-div > a:nth-child(2):hover~#indicator {
  left: 48%;
  width: 100px;
  background: linear-gradient(130deg, #00e2ff, #89ff00);
}

.nav-div > a:nth-child(3):hover~#indicator {
  left: 75%;
  background: linear-gradient(130deg, purple, palevioletred);
}

.nav-div-right a:nth-child(1):hover~#indicator2{
  left: 22%;
  width: 70px;
  background: linear-gradient(130deg, #00e2ff, #89ff00);
}

.nav-div-right a:nth-child(2):hover~#indicator2 {
  left: 60%;
  width: 55px;
  background: linear-gradient(130deg, #00e2ff, #89ff00);
}

#indicator {
  position: absolute;
  top: 70px;
  width: 60px;
  height: 3px;
  background-color: #fff;
  border-radius: 5px;
  transition: 1s ease left;
}

#indicator2 {
  position: absolute;
  top: 70px;
  width: 60px;
  height: 3px;
  background-color: #fff;
  border-radius: 5px;
  transition: 1s ease left;
}

.nav-div-right {
  position: relative;
  float: right;
  width: 300px;
  height: 75px;
}

nav a.router-link-exact-active {
  color: #42b983;
}

nav a:first-child {
  margin-right: 50px;
}

body {
  margin: 0;
  padding: 0;
  -ms-overflow-style: none;
}

::-webkit-scrollbar {
  display: none;
}

.bubbly-button {
  display: inline-block;
  font-size: 1em;
  font-weight: 600;
  -webkit-appearance: none;
  padding: 24px 0;
  appearance: none;
  background-color: #fff;
  border-style: none;
  cursor: pointer;
  position: relative;
  transition: transform ease-in 0.1s, box-shadow ease-in 0.25s;
  /* box-shadow: 0 1px 1px #318861; */
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


.isLoginBtn:hover{
  color: #0d6efd;
}
.isLoginBtn{
  transition: 0.5s ease color;
}
.welcome-span{
  position: absolute;
  z-index: 1;
  top: 0;
  right: 0;
  font-size: 14px;
}
</style>