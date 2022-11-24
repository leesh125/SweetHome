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
                <div class="noticeNo">공지번호 : {{no}}</div>
                <img class="d-flex g-width-50 g-height-50 rounded-circle g-mt-3 g-mr-15" src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Image Description">
                <div class="media-body u-shadow-v18 g-bg-secondary g-pa-30">
                  <div class="g-mb-15">
                    <div style="display: flex;">
                      <h5 class="h5 g-color-gray-dark-v1 mb-0">제목: </h5>
                      <input type="text" :value="title" class="title" disabled/>
                    </div>
                  </div>
                  <div class="g-mb-15">
                    <div style="display: flex;">
                      <h5 class="h5 g-color-gray-dark-v1 mb-0">내용: </h5>
                      <textarea class="textarea" :value="no" disabled/>
                    </div>
                  </div>
                  <div class="g-mb-15">
                    <div style="display: flex;">
                      <h5 class="h5 g-color-gray-dark-v1 mb-0">작성일: </h5>
                      <input type="text" :value="createdDate" class="title" disabled />
                    </div>
                  </div>
                  <!-- <div class="g-mb-15">
                    <div style="display: flex;">
                      <h5 class="h5 g-color-gray-dark-v1 mb-0">조회수: </h5>
                      <div class="title">title{{ title }}</div>
                    </div>
                  </div> -->

                  <p>{{ $route.params.first_name }}</p>
                  <p>{{ $route.params.last_name }}</p>

                  <ul class="list-inline d-sm-flex my-0">
                    <li class="list-inline-item g-mr-20">
                      <a class="u-link-v5 g-color-gray-dark-v4 g-color-primary--hover" href="#!">
                        <i class="fa fa-thumbs-up g-pos-rel g-top-1 g-mr-3"></i>
                        178
                      </a>
                    </li>
                    <li class="list-inline-item g-mr-20">
                      <a class="u-link-v5 g-color-gray-dark-v4 g-color-primary--hover" href="#!">
                        <i class="fa fa-thumbs-down g-pos-rel g-top-1 g-mr-3"></i>
                        34
                      </a>
                    </li>
                    <li class="list-inline-item ml-auto">
                      <a class="u-link-v5 g-color-gray-dark-v4 g-color-primary--hover" href="#!">
                        <i class="fa fa-reply g-pos-rel g-top-1 g-mr-3"></i>
                        Reply
                      </a>
                    </li>
                  </ul>
                </div>
            </div>
        </div>

    </div>
  </div>
</template>

<script>
export default {
    name: 'noticeDetail',
    props: {
        no: {
            type: String,
            default : ''
        },
        first_name: {
            type: String,
            default : ''
        },
        last_name: {
            type: String,
            default : ''
        },
    },
}
</script>

<style>
.noticeNo {
  position: absolute;
  left: 60px;
  top: 10px;
  font-size: 20px;
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
</style>
