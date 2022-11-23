<template>
  <div>
    <h1>name: {{ $route.params.no }}</h1>
    <h1>first_name: {{ $route.params.first_name }}</h1>
    <h1>last_name: {{ $route.params.last_name }}</h1>
    <hr>
    <h1>no: {{ no }}</h1>
    <h1>first_name: {{ first_name }}</h1>
    <h1>last_name: {{ last_name }}</h1>
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

</style>
