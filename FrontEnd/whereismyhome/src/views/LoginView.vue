<template>
  <div class="main2">  	
      <input type="checkbox" id="chk" aria-hidden="true">

        <div class="signup">
          <form id="signUpForm" method="post" action="${root}/user/register.do" >
            <label for="chk" aria-hidden="true">Sign up</label>
            <input type="text" id="userId" name="userId" placeholder="User ID" required>
            <input type="password" id="password" name="password" placeholder="Password" required>
            <input type="text" id="username" name="username" placeholder="User name" required>
            <input type="text" id="address" name="address" placeholder="Address" required>
            <input type="button" id="signup-btn" value="Sign up"/>
            <div style="text-align: center;">
              <a href="${root}/user/findPassword.jsp">비밀번호를 잊으셨습니까?</a>
            </div>
          </form>
        </div>

        <div class="login">
          <form method="post" action="${root}/user/login.do">
            <label id="login-label" for="chk" aria-hidden="true">Login</label>
            <input type="text" id="login-id" name="login-id" placeholder="User ID" required>
            <input type="password" id="login-password" name="login-password" placeholder="Password" required>
            <input type="button" id="login-btn" value="Login" />
          </form>
        </div>
    </div>

</template>

<script>
export default {

}
</script>

<style scoped>
.main2{
  margin: 180px auto;
	width: 400px;
  height: 600px;
	background: red;
	overflow: hidden;
	border-radius: 10px;
	box-shadow: 5px 20px 50px #000;
  min-height: 50vh;
	font-family: 'Jost', sans-serif;
	background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
}
#chk{
	display: none;
}
.signup{
	position: relative;
	width:100%;
	height: 100%;
}

label{
	color: #fff;
	font-size: 2.3em;
	justify-content: center;
	display: flex;
	margin: 60px;
	font-weight: bold;
	cursor: pointer;
	transition: .5s ease-in-out;
}
form > input{
	width: 60%;
	height: 20px;
	background: #e0dede;
	justify-content: center;
	display: flex;
	margin: 30px auto;
  padding: 20px;
	border: none;
	outline: none;
	border-radius: 5px;
}
#signup-btn,#login-btn, button{
	line-height: 0;
	width: 60%;
	height: 40px;
	margin: 10px auto;
	justify-content: center;
	display: block;
	color: #fff;
	background: #573b8a;
	font-size: 1em;
	font-weight: bold;
	outline: none;
	border: none;
	border-radius: 5px;
	transition: .2s ease-in;
	cursor: pointer;
}

button:hover{
	background: #6d44b8;
}
.login{
	height: 460px;
	background: #eee;
	border-radius: 60% / 10%;
	transform: translateY(-180px);
	transition: .8s ease-in-out;
}
.login label{
	color: #573b8a;
	transform: scale(.6);
}

#chk:checked ~ .login{
	transform: translateY(-500px);
}
#chk:checked ~ .login label{
	transform: scale(1);	
}
#chk:checked ~ .signup label{
	transform: scale(.6);
}

</style>