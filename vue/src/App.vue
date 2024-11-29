<template>
  <header>
    <h1>WindSpeed v1.2</h1>
  </header>  
  <div id="app">
    <Input @wind-data="updateWindData" />
    <Report :windData="windData"/>
  </div>
</template>

<script>
import Input from './components/Input.vue';
import Report from './components/Report.vue';

export default {
  components: {
    Input,
    Report,
  },
  data() {
    return {
      windData: null,
    };
  },
  methods: {
    updateWindData(data) {
      this.windData = data;
    },
  },
};
</script>

<style>

</style>

