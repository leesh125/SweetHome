<template>
<b-container fluid>
    <b-row>
      <b-col cols="6">
        <b-button class="mt-2" variant="outline-primary">관심지역으로 추가</b-button>
      </b-col>
      <b-col cols="6">
        <b-button class="mt-2" variant="outline-primary">선택한 관심지역 삭제</b-button>
      </b-col>
    </b-row>
    <b-row>
        <select class="col-sm-12 mt-2">
              <option value="" selected>관심지역선택</option>
        </select>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: 'InterestArea',

  data() {
    return {
      interests:[]
    };
  },
  created() {
    const userId = 'ssafy@ssafy.com'
    http.get(`/interest/${userId}`)
      .then(({ data }) => {
        console.log(data);
      })
    ;
  },
  mounted() {
    
  },

  methods: {
    
  },
};
</script>

<style lang="scss" scoped>

</style>