<template>
  <div class="overflow-auto">

    <!-- <p class="mt-3">Current Page: {{ currentPage }}</p> -->
    <h1 class="h1-notice">Notice</h1>
    <b-table id="my-table" :items="items" :per-page="perPage" :current-page="currentPage" @row-clicked="rowClick"></b-table>
    <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" aria-controls="my-table"></b-pagination>
  </div>
</template>

<script>
export default {
  data() {
    return {
      perPage: 15,
      currentPage: 1,
      items: [
        { id: 1, first_name: 'Fred', last_name: 'Flintstone' },
        { id: 2, first_name: 'Wilma', last_name: 'Flintstone' },
        { id: 3, first_name: 'Barney', last_name: 'Rubble' },
        { id: 4, first_name: 'Betty', last_name: 'Rubble' },
        { id: 5, first_name: 'Pebbles', last_name: 'Flintstone' },
        { id: 6, first_name: 'Bamm Bamm', last_name: 'Rubble' },
        { id: 7, first_name: 'The Great', last_name: 'Gazzoo' },
        { id: 8, first_name: 'Rockhead', last_name: 'Slate' },
        { id: 9, first_name: 'Pearl', last_name: 'Slaghoople' },
        { id: 10, first_name: 'Pearl', last_name: 'Slaghoople' },
        { id: 11, first_name: 'Fred', last_name: 'Flintstone' },
        { id: 12, first_name: 'Wilma', last_name: 'Flintstone' },
        { id: 13, first_name: 'Barney', last_name: 'Rubble' },
        { id: 14, first_name: 'Betty', last_name: 'Rubble' },
        { id: 15, first_name: 'Pebbles', last_name: 'Flintstone' },
        { id: 16, first_name: 'Bamm Bamm', last_name: 'Rubble' },
        { id: 17, first_name: 'The Great', last_name: 'Gazzoo' },
        { id: 18, first_name: 'Rockhead', last_name: 'Slate' },
        { id: 19, first_name: 'Pearl', last_name: 'Slaghoople' },
        { id: 1, first_name: 'Fred', last_name: 'Flintstone' },
        { id: 2, first_name: 'Wilma', last_name: 'Flintstone' },
        { id: 3, first_name: 'Barney', last_name: 'Rubble' },
        { id: 4, first_name: 'Betty', last_name: 'Rubble' },
        { id: 5, first_name: 'Pebbles', last_name: 'Flintstone' },
        { id: 6, first_name: 'Bamm Bamm', last_name: 'Rubble' },
        { id: 7, first_name: 'The Great', last_name: 'Gazzoo' },
        { id: 8, first_name: 'Rockhead', last_name: 'Slate' },
        { id: 9, first_name: 'Pearl', last_name: 'Slaghoople' },
        { id: 10, first_name: 'Pearl', last_name: 'Slaghoople' },
        { id: 11, first_name: 'Fred', last_name: 'Flintstone' },
        { id: 12, first_name: 'Wilma', last_name: 'Flintstone' },
        { id: 13, first_name: 'Barney', last_name: 'Rubble' },
        { id: 14, first_name: 'Betty', last_name: 'Rubble' },
        { id: 15, first_name: 'Pebbles', last_name: 'Flintstone' },
        { id: 16, first_name: 'Bamm Bamm', last_name: 'Rubble' },
        { id: 17, first_name: 'The Great', last_name: 'Gazzoo' },
        { id: 18, first_name: 'Rockhead', last_name: 'Slate' },
        { id: 19, first_name: 'Pearl', last_name: 'Slaghoople' },
        { id: 1, first_name: 'Fred', last_name: 'Flintstone' },
        { id: 2, first_name: 'Wilma', last_name: 'Flintstone' },
        { id: 3, first_name: 'Barney', last_name: 'Rubble' },
        { id: 4, first_name: 'Betty', last_name: 'Rubble' },
        { id: 5, first_name: 'Pebbles', last_name: 'Flintstone' },
        { id: 6, first_name: 'Bamm Bamm', last_name: 'Rubble' },
        { id: 7, first_name: 'The Great', last_name: 'Gazzoo' },
        { id: 8, first_name: 'Rockhead', last_name: 'Slate' },
        { id: 9, first_name: 'Pearl', last_name: 'Slaghoople' },
        { id: 10, first_name: 'Pearl', last_name: 'Slaghoople' },
        { id: 11, first_name: 'Fred', last_name: 'Flintstone' },
        { id: 12, first_name: 'Wilma', last_name: 'Flintstone' },
        { id: 13, first_name: 'Barney', last_name: 'Rubble' },
        { id: 14, first_name: 'Betty', last_name: 'Rubble' },
        { id: 15, first_name: 'Pebbles', last_name: 'Flintstone' },
        { id: 16, first_name: 'Bamm Bamm', last_name: 'Rubble' },
        { id: 17, first_name: 'The Great', last_name: 'Gazzoo' },
        { id: 18, first_name: 'Rockhead', last_name: 'Slate' },
        { id: 19, first_name: 'Pearl', last_name: 'Slaghoople' }
      ]
    }
  },
  computed: {
    rows() {
      return this.items.length
    }
  },
  methods: {
    rowClick(item) {
      console.log(item);
      this.$router.push({
        name: 'detail',
        params: {
          no: item.id,
          first_name: item.first_name,
          last_name: item.last_name,
        }
      })
    }
  },
}
</script>

<style>
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
</style>