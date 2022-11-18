<template>
  <div class="main">
    <div class="inner-div">
      <div class="inner-div-letter">
        어떤 집을 찾고 계신가요?
      </div>
      <div class="inner-div-input">
        <input class="c-checkbox" type="checkbox" id="checkbox">
        <div class="c-formContainer">
          <form class="c-form" action="">
            <input class="c-form__input" placeholder="원하시는 지역명,아파트명을 입력해주세요" type="text" style="font-size: 18px;" required>
            <label class="c-form__buttonLabel" for="checkbox">
              <button class="c-form__button" type="button">Search</button>
            </label>
            <label class="c-form__toggle" for="checkbox" data-title="이름으로 검색하기"></label>
          </form>
        </div>
      </div>
      <div class="inner-div-selects">
        <div class="optionbox">
          <select> 
            <option>United states</option>
            <option>India</option>
            <option>Russia</option>
            <option>China</option>
          </select>
       </div>
       <div class="optionbox">
          <select> 
            <option>United states</option>
            <option>India</option>
            <option>Russia</option>
            <option>China</option>
          </select>
       </div>
       <div class="optionbox">
          <select> 
            <option>United states</option>
            <option>India</option>
            <option>Russia</option>
            <option>China</option>
          </select>
       </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'HomeView',
  components: {
  }
}
</script>

<style>
.main {
  width: 100%;
  height: 700px;
  margin: 0 auto;
  background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url(../assets/img/home.jpg);
  background-repeat: no-repeat;
  background-position: center;
  background-size: 1920px 720px;
}

.inner-div {
  z-index: 2;
}

.inner-div-letter {
  color: #fff;
  font-weight: 600;
  font-size: 2.3em;
  margin-bottom: 20px;
  letter-spacing: 5px;
  padding-top: 260px;
}

.c-checkbox {
  display: none;
}

.c-checkbox:checked+.c-formContainer .c-form {
  width: 37.5em;
}

.c-checkbox:checked+.c-formContainer .c-form__toggle {
  visibility: hidden;
  opacity: 0;
  transform: scale(0.7);
}

.c-checkbox:checked+.c-formContainer .c-form__input,
.c-checkbox:checked+.c-formContainer .c-form__buttonLabel {
  transition: 0.2s 0.1s;
  visibility: visible;
  opacity: 1;
  transform: scale(1);
}

.c-checkbox:not(:checked)+.c-formContainer .c-form__input:required:valid~.c-form__toggle {
  pointer-events: none;
  cursor: default;
}

.c-formContainer,
.c-form,
.c-form__toggle {
  width: 20em;
  height: 4.25em;
}

.c-formContainer {
  position: relative;
  font-weight: 700;
  margin: auto;
}

.c-form,
.c-form__toggle {
  position: absolute;
  border-radius: 6.25em;
  background-color: #fff;
  transition: 0.2s;
}

.c-form {
  left: 50%;
  transform: translateX(-50%);
  padding: 0.625em;
  box-sizing: border-box;
  box-shadow: 0 0.125em 0.3125em rgba(0, 0, 0, 0.3);
  display: flex;
  justify-content: center;
}

.c-form__toggle {
  color: #42b983;
  top: 0;
  cursor: pointer;
  z-index: 1;
  display: flex;
  align-items: center;
  justify-content: center;
}

.c-form__toggle::before {
  font-size: 1.75em;
  content: attr(data-title);
}

.c-form__input,
.c-form__button {
  font: inherit;
  border: 0;
  outline: 0;
  border-radius: 5em;
  box-sizing: border-box;
}

.c-form__input,
.c-form__buttonLabel {
  font-size: 1.75em;
  opacity: 0;
  visibility: hidden;
  transform: scale(0.7);
  transition: 0s;
}

.c-form__input {
  color: #a7e6c8;
  height: 100%;
  width: 100%;
  padding: 0 0.714em;
}

.c-form__input::placeholder {
  color: currentColor;
}

.c-form__input:required:valid {
  color: #42b983;
}

.c-form__input:required:valid+.c-form__buttonLabel {
  color: #fff;
}

.c-form__input:required:valid+.c-form__buttonLabel::before {
  pointer-events: initial;
}

.c-form__buttonLabel {
  color: #b5ebd3;
  height: 100%;
  width: auto;
}

.c-form__buttonLabel::before {
  content: '';
  position: absolute;
  width: 100%;
  height: 100%;
  pointer-events: none;
  cursor: pointer;
}

.c-form__button {
  color: inherit;
  padding: 0;
  height: 100%;
  width: 5em;
  background-color: #42b983;
}
.inner-div-selects{
  display: flex;
  justify-content: center;
  margin-top: 30px;
}

.optionbox {
  position: relative;
  margin-right: 10px;
}

.optionbox select {
  background: #42b983;
  color: #fff;
  padding: 10px;
  width: 200px;
  height: 50px;
  border: none;
  font-size: 18px;
  box-shadow: 0 5px 48px rgb(8, 29, 68);
  border-radius: 10px 10px 10px 10px;
  -webkit-appearance: button;
  outline: none;
}

.optionbox:before{
  content: '↓';
  position: absolute;
  top: 0;
  right: 0;
  height: 50px;
  width: 50px;
  background: #42b983;
  text-align: center;
  line-height: 47px;
  border-radius: 0px 10px 10px 0px;
  color:#fff;
  font-size: 22px;
  pointer-events: none;
}

.optionbox:hover:before{  
  background: #338e65;
}
</style>