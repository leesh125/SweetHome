<template>
  <div class="overflow-auto">
    <a class="write-a" @click="writeNotice">
      <button class="bn54">
        <span class="bn54span">공지등록</span>
      </button>
    </a>
    <!-- <p class="mt-3">Current Page: {{ currentPage }}</p> -->
    <h1 class="h1-notice">Notice</h1>
    <b-table id="my-table" :items="notices" :per-page="perPage" :current-page="currentPage" @row-clicked="rowClick"></b-table>
    <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" aria-controls="my-table"></b-pagination>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  data() {
    return {
      perPage: 15,
      currentPage: 1,
      notices: []
    }
  },
  computed: {
    rows() {
      return this.notices.length
    }
  },
  created() {
    http.get(`/notices`).then(({ data }) => this.notices = data);
  },
  methods: {
    rowClick(notice) {
      console.log(notice);
      http.get(`/notices/${notice.no}`);
      this.$router.push({
        name: 'detail',
        params: {
          no: notice.no,
          subject: notice.subject,
          content: notice.content,
          createDate: notice.createDate,
          hit: notice.hit
        }
      })
    },writeNotice() {
      this.$router.push("/notice/write")
    }
  },
}
</script>

<style >
.h1-notice{
  padding: 50px 0 30px;
  text-transform: uppercase;
  letter-spacing: 5px;
  transition: 700ms ease;
  font-variation-settings: "wght" 311;
  margin-bottom: 0.8rem;
  color: rgb(2, 161, 74);
  outline: none;
  text-align: center;
  font-weight: 600;

  animation-name: h1-letter;
  animation-duration: 1.5s;
  animation-duration: leaner;
  animation-iteration-count: 2;
  animation-direction: alternate;
  animation-fill-mode: forwards;
}

@keyframes h1-letter {
  0% {
    font-variation-settings: "wght" 311;
    letter-spacing: 5px;
  }

  100% {
    font-variation-settings: "wght" 582;
    letter-spacing: 15px;
  }
}

.overflow-auto {
  position: relative;
  width: 950px;
  margin: 0 auto;
  border-radius: 6px;
  box-shadow: 0 16px 24px 2px rgb(0 0 0 / 14%), 0 6px 30px 5px rgb(0 0 0 / 12%), 0 8px 10px -5px rgb(0 0 0 / 20%);
  margin: 60px auto;
}

.pagination {
  justify-content: center;
}

#my-table tr:hover {
  transition-duration: 0.5s;
  color: white;
  background-color: #42b983;
}

tr > th:nth-child(3), tr>td:nth-child(3) {
  display: none !important;
}

.write-a{
  position: absolute;
  right: 39px;
  top: 50px;
  text-decoration: none;
}

.bn54 {
  position: relative;
  outline: none;
  text-decoration: none;
  border-radius: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  text-transform: uppercase;
  height: 45px;
  width: 130px;
  opacity: 1;
  background-color: #42B983;
  border: 1px solid #349b6d;
}

.bn54 .bn54span {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  color: #ffffff;
  font-size: 16px;
  font-weight: 500;
  letter-spacing: 0.7px;
}

.bn54:hover {
  animation: bn54rotate 0.7s ease-in-out both;
}

.bn54:hover .bn54span {
  animation: bn54storm 0.7s ease-in-out both;
  animation-delay: 0.06s;
}

@keyframes bn54rotate {
  0% {
    transform: rotate(0deg) translate3d(0, 0, 0);
  }

  25% {
    transform: rotate(3deg) translate3d(0, 0, 0);
  }

  50% {
    transform: rotate(-3deg) translate3d(0, 0, 0);
  }

  75% {
    transform: rotate(1deg) translate3d(0, 0, 0);
  }

  100% {
    transform: rotate(0deg) translate3d(0, 0, 0);
  }
}

@keyframes bn54storm {
  0% {
    transform: translate3d(0, 0, 0) translateZ(0);
  }

  25% {
    transform: translate3d(4px, 0, 0) translateZ(0);
  }

  50% {
    transform: translate3d(-3px, 0, 0) translateZ(0);
  }

  75% {
    transform: translate3d(2px, 0, 0) translateZ(0);
  }

  100% {
    transform: translate3d(0, 0, 0) translateZ(0);
  }
}
</style>