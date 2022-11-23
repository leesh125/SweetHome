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
                <img class="d-flex g-width-50 g-height-50 rounded-circle g-mt-3 g-mr-15" src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Image Description">
                <div class="media-body u-shadow-v18 g-bg-secondary g-pa-30">
                  <div class="g-mb-15">
                    <h5 class="h5 g-color-gray-dark-v1 mb-0">Admin</h5>
                    <span class="g-color-gray-dark-v4 g-font-size-12">5 days ago</span>
                  </div>
            
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
    box-shadow: 0 5px 10px -6px rgba(0, 0, 0, 0.15);
}

.g-color-gray-dark-v4 {
    color: #777 !important;
}

.g-font-size-12 {
    font-size: 0.85714rem !important;
}

.media-comment {
    margin-top:20px
}
</style>
