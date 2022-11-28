# 🏡SweetHome

<h3>⭐아파트 실거래 정보 제공 웹사이트(SSAFY 8기 1학기 최종 프로젝트)⭐</h3> 

<br><br>



## **개요**

- 부동산 매물의 다양한 서비스 제공을 목적으로 아파트 매매 실거래가, 매매 거래내역, 공지사항 기능등을 제공

<br><br>

## 프로젝트 기간

- 2022년 11월 14일 ~ 2021년 11월 25일

<br><br>

## 기술 스택

API | Vue | SpringBoot |  Java   |  JavaScript   |  MySQL   |   MyBatis  |
| :--------: | :--------: | :--------: | :------: | :-----: | :------: | :------: |
|    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Kakao_CI_yellow.svg/1200px-Kakao_CI_yellow.svg.png" alt="vue" width="80" height="40" />    |    <img src="https://www.svgrepo.com/show/354528/vue.svg" alt="vue" width="60" height="60" />    |   <img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FmJKEh%2FbtqH2ea5K9D%2F8NpyE8MoHMTGDUMC55gYf0%2Fimg.png" alt="springboot" width="60" height="60" />    | <img src="https://www.svgrepo.com/show/184143/java.svg" alt="android" width="60" height="60" /> | <img src="https://www.svgrepo.com/show/355081/js.svg" alt="js" width="60" height="60" /> | <img src="https://cdn.cdnlogo.com/logos/m/10/mysql.svg" alt="js" width="60" height="60" /> | <img src="https://plugins.jetbrains.com/files/13905/199136/icon/pluginIcon.svg" alt="js" width="60" height="60" />


###### <br><br>

## 팀원

<table>
  <thead>
    <tr>
      <th>이름</th>
      <th>역할</th>
      <th>구현 기능</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="2">이석현</td>
      <td rowspan="2">팀장</td>
      <td>회원, 공지사항 도메인</td>
    </tr>
    <tr>
      <td>회원 and 공지 Rest API 설계, MyBatis sql 작성, 전체화면 설계/구현, Vue 코드 클라이언트/서버 통신</td>
    </tr>
    <tr>
      <td rowspan="2">이윤환</td>
      <td rowspan="2">팀원</td>
      <td>아파트 도메인</td>
    </tr>
    <tr>
      <td>아파트 Rest API 설계, MyBatis sql 작성, Vue 코드 실거래가 조회 클라이언트/서버 통신</td>
    </tr>
  </tbody>
</table>

<br><br>

## **ERD(ER Diagram)**

![ERD](./assets/img/erd.png)

<br><br>

## UML(Usecase Diagram)

<img src="./assets/img/uml.png" alt="js" width="900" height="600" />

<br><br>

## 실행 화면

### 🔗 회원가입

![01_1_회원가입](./assets/1_회원가입_1.gif)
![01_2_회원가입](./assets/1_회원가입_2.gif)


✅ 회원 분류 (일반 회원 / 기업 회원) 2가지, 아이디 중복체크, 비밀번호 이중 체크

✅ 비밀번호, 비밀번호 확인이 같지 않으면 비밀번호가 일치하지 않음을 표시

<br><br>

### **🔗 로그인**

![02_로그인](./assets/2_로그인.gif)

✅ Commons Email을 활용한 회원 인증을 거침. 인증에 실패하면 다시 로그인, 성공하면 사용자 이름과 함께 환영합니다 메시지.

<br><br>

### **🔗 내 정보 확인**

![03_내정보확인](./assets/3_내정보확인.gif)

✅ 로그인한 사용자의 정보를 

<br><br>
---

### **🔗 메인페이지 검색**

![04_메인페이지검색](./assets/4_메인페이지검색.gif)

✅ 메인 페이지에서 아파트 검색, 아파트 매매 페이지로 이동

<br><br>

### **🔗 키워드로 검색**

![05_키워드로검색](./assets/5_키워드로검색.gif)

✅ 선택한 지역에서 아파트 이름 검색

<br><br>


### **🔗 거래내역 조회**

![06_거래내역조회](./assets/6_거래내역조회.gif)

✅ 아파트별 상세 거래내역 조회와 좋아요 기능

<br><br>

### **🔗 관심지역**

![07_관심지역](./assets/7_관심지역.gif)

✅ 현재 검색중인 지역을 관심지역에 추가, 선택시 검색 지역 자동 변경

<br><br>

---

### **🔗 공지사항 수정**

![09_공지사항수정](./assets/9_공지사항수정.gif)

✅ 공지사항 상세 조회 버튼을 클릭하여 수정, 공지번호는 수정 불가

<br><br>

### **🔗 공지사항 삭제**

![10_공지사항삭제](./assets/10_공지사항삭제.gif)

✅ 공지사항 삭제 실시

<br><br>



### **🔗 공지사항 등록**

![11_공지사항등록](./assets/11_공지사항등록.gif)

✅ 공지사항 등록 실시

<br><br>

### **🔗 로그아웃**

![12_로그아웃](./assets/12_로그아웃.gif)

✅ 로그인 한 유저를 로그아웃, Vue Store와 Session에 있는 값들을 초기화 함

<br><br>
<!-- Stack Icon Refernces -->

[vue]: ./assets/img/vue.svg
[springboot]: https://destatic.blob.core.windows.net/images/spring-boot-logo.png
[react]: /images/stack/react.svg
[node]: /images/stack/node.svg
