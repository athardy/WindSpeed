<template>
  <header class="app-header">
    <h1>WindSpeed v1.2</h1>
  </header>  
  <div id="app">
    <Input class="input-box" @wind-data="updateWindData" />
    <Report class="report-box" :windData="windData"/>
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
body {
  background-color: black;
  font-family: Arial, Helvetica, sans-serif;
}

.app-header {
  background-color: rgba(169, 169, 169, 0.452);
  color: white;
  text-align: center;
  margin-bottom: 1rem;
}

.input-box {
  margin-left: 36%;
  margin-bottom: 20px;
}

.report-box {
  margin-left: 36%;
}

</style>