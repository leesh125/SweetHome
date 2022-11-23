import http from "@/util/http-common";
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    interests:[],

    search: {
      word: "",
      sidoCode: "",
      gugunCode: "",
      dongCode: "",
    },
    searchHouseList: [],

    locationCode: "",
    currLat: "37.4812845080678",
    currLng: "126.952713197762",
  },
  getters: {
    interests(state) {
      return state.interests;
    },
    search(state) {
      return state.search;
    },
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
    addInterest(state, interest) {
      state.interests.push(interest);
    },
    setInterests(state, interests) {
      state.interests = interests;
    },
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
    searchHouse({ commit, getters }, searchElement) {
      console.log("search!!!!")
      commit('setSearchElement', searchElement);
      http.get(`/houses?locationCode=${getters.locationCode}&searchWord=${getters.searchWord}`)
        .then(({ data }) => {
          console.log("data : " + JSON.stringify(data[0]))
          commit('setSearchHouseList', data);
          commit('setLocationCode', getters.locationCode);
        })
    },
    addInterest({ commit }, interest) {
      console.log(interest);
      http.post("/interest", interest).then(() => {
        http.get(`/interest/${interest.userId}`)
        .then(({ data }) => {
          commit("setInterests", data);
        })
      })

    }
  },
  modules: {
  }
})
