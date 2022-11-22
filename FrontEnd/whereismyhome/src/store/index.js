import http from "@/util/http-common";
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    search: {
      word: "",
      sidoCode: "",
      gugunCode: "",
      dongCode: "",
    },
    searchHouseList:[],
    locationCode: "",
    currLat: "37.4812845080678",
    currLng: "126.952713197762",
  },
  getters: {
    sidoCode(state) {
      return state.search.sidoCode;
    },
    gugunCode(state) {
      return state.search.gugunCode;
    },
    dongCode(state) {
      return state.search.dongCode;
    },
    searchWord(state) {
      return state.search.word;
    },
    locationCode(state) {
      return state.search.sidoCode + state.search.gugunCode + state.search.dongCode;
    },
    searchHouseList(state) {
      return state.searchHouseList;
    }
  },
  mutations: {
    setSearchElement(state, searchElement) {
      state.search.sidoCode = searchElement.sidoCode;
      state.search.gugunCode = searchElement.gugunCode;
      state.search.dongCode = searchElement.dongCode;
      state.search.word = searchElement.word;
    },
    setLocationCode(state, locationCode) {
      state.locationCode = locationCode;
    },
    setSearchHouseList(state, searchHouseList) {
      state.searchHouseList = searchHouseList;
    }
  },
  actions: {
    searchHouse({commit, getters},searchElement) {
      commit('setSearchElement', searchElement);
      http.get(`/houses?locationCode=${getters.locationCode}&searchWord=${getters.searchWord}`)
        .then(({ data }) => {
          commit('setSearchHouseList', data);
          commit('setLocationCode', getters.locationCode);
      })
    }
  },
  modules: {
  }
})
