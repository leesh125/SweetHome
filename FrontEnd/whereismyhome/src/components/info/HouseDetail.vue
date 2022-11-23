<template>
  <div>
    <button @click="closeDetail">close</button>
  </div>
</template>

<script>
export default {
  name: 'SweetHomeHouseDetail',

  data() {
    return {
      
    };
  },

  mounted() {
    
  },

  methods: {
    closeDetail() {
      this.$emit('closeDetail');
    }
  },
};
</script>

<style lang="scss" scoped>

</style>