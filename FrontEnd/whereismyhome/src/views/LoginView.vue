<template>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-26">
						Welcome
					</span>
					<span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>
	
					<div class="wrap-input100 validate-input" data-validate="Valid email is: a@b.c">
						<input @focus="inputFunc" class="input100" type="text" name="userId" v-model="userId">
						<span class="focus-input100" data-placeholder="Email"></span>
					</div>
	
					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span @click="clickBtn" class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input @focus="inputFunc"  class="input100" :type="showPass == 0 ? 'password' : 'text'" v-model="password">
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>
	
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button type='button' @click="checkFunc" class="login100-form-btn">
								Login
							</button>
						</div>
					</div>
	
					<div class="text-center p-t-115">
						<span class="txt1">
							Don’t have an account?
						</span>
	
						<a class="txt2" @click="moveRegister" href="#">
							Sign Up
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</template>

<script>
import $ from 'jquery';
import http from "@/util/http-common";
import Vue from 'vue';
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.use(VueSweetalert2);

export default {
	name: 'FrontEndLoginView',

	data() {
		return {
			showPass: 0,
			check: true,
			userId: '',
			password: ''
		};
	},

	mounted() {
		
	},
	methods: {
		inputFunc() {
			$('.input100').each(function () {
				$(this).parents("div").removeClass('alert-validate');
				$(this).removeClass('alert-validate');
				$(this).on('blur', function () {
					
					if ($(this).val().trim() != "") {
						$(this).addClass('has-val');
					}
					else {
						$(this).removeClass('has-val');
					}
				})
			});
		},
		checkFunc() {
			this.check = true;
			function validate(input) {
				$('.input100').each(function () {
				$(this).removeClass('alert-validate');
			});
				var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
				if ($(input).attr('type') == 'email' || $(input).attr('name') == 'userId') {
					if ($(input).val().trim().match(pattern) == null) {
						return false;
					}
				}
				else {
					if ($(input).val().trim() == '') {
						return false;
					}
				}
			}
			function showValidate(input) {
				var thisAlert = $(input).parent();

				$(thisAlert).addClass('alert-validate');
			}
			var input = $('.validate-input .input100');
			for (var i = 0; i < input.length; i++) {
				if (validate(input[i]) == false) {
					showValidate(input[i]);
					this.check = false;
				}
			}
			
			if (this.check) {
				http.post(`/users/login?userId=${this.userId}&password=${this.password}`).then(({ data }) => {
					if (data != null) {
						this.$store.commit("setLoginUser", data);
						this.$store.commit("setIsLogin", true);
						this.$swal({
							icon: 'success',
							title: `${data.name}님 환영합니다.`,
						}).then(this.$router.push("/"));
					} else {
						return false;
					}
				}).catch(
					this.$swal({
						icon: 'error',
						title: `로그인 실패.`,
						text: '아이디 혹은 비밀번호가 일치하지 않습니다.',
					})
				);
			}
			return this.check;
		},
		hideValidate(input) {
			var thisAlert = $(input).parent();

			$(thisAlert).removeClass('alert-validate');
		},
		clickBtn() {
			if (this.showPass == 0) {
				this.showPass = 1;
			} else {
				this.showPass = 0;
			}
		}, moveRegister() {
			this.$router.push("/register");
		},
	},
};
</script>

<style scoped>
@import "../assets/css/login.css";
	@import "../assets/css/login_util.css";
	@import "../assets/css/animate.css";
	@import "../assets/css/animstition.css";
	@import "../assets/css/hamburger.css";
	@import "../assets/css/select2.css";
	@import "../assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css"; 
	@import "../assets/fonts/iconic/css/material-design-iconic-font.min.css";
</style>