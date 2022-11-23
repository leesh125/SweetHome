<template>
<b-container fluid>
    <b-row>
      <select class="col-sm-7 mt-2" @change="selectInterest($event)">
        <option value="" selected>관심지역선택</option>
        <option v-for="interest in interests" :value="interest.dongCode" :key="interest.no">
          {{interest.address.sidoName}} {{interest.address.gugunName}} {{interest.address.dongName}}
        </option>
      </select>
      <b-col cols="5">
        <b-button class="mt-2" variant="outline-primary" @click="addInterest">관심지역 추가</b-button>
      </b-col>
    </b-row>
    <b-row>

    </b-row>
  </b-container>
</template>

<script>
import http from "@/util/http-common";
import eventBus from "@/components/EventBus.vue"

export default {
  name: 'InterestArea',

  data() {
    return {
    };
  },
  created() {
    const userId = this.$store.getters.loginUser.userId;
    http.get(`/interest/${userId}`)
      .then(({ data }) => {
        this.$store.commit("setInterests", data);
      });

    eventBus.$on("addInterest", (interest) => {
      const i = {
        userId: userId,
        dongCode: interest.search.dongCode,
      }

      this.$store.dispatch("addInterest", i);
    });
  },
  mounted() {
    
  },

  methods: {
    addInterest() {
      eventBus.$emit("getCurrentAddress");
    },
    selectInterest(event) {
      console.log(event.target.value);
      eventBus.$emit("selectInterest", event.target.value);
    }
  },
  computed: {
    interests() {
      return this.$store.state.interests; 
    }
  },
  watch: {
    interests(newValue) {
      this.interests = newValue;
    }
  }
};
</script>

<style lang="scss" scoped>

</style>