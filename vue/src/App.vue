<template>
  <div class="device-overlay">
    <h1>WindSpeed v1.3</h1>
    <div id="app">
      <Report 
        class="report-box" 
        :windData="windData" 
        :errorMessage="errorMessage" 
      />
      <Input 
        class="input-box" 
        @wind-data="updateWindData" 
        @error-message="updateErrorMessage" 
      />
    </div>
  </div>
</template>

<script>
import Input from './components/Input.vue';
import Report from './components/Report.vue';

export default {
  components: { Input, Report },
  data() {
    return {
      windData: null,
      errorMessage: '',
    };
  },
  methods: {
    updateWindData(data) {
      this.windData = data;
    },
    updateErrorMessage(message) {
      this.errorMessage = message;
    },
  },
};
</script>


<style>
#app {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 5px; /* Adjust spacing between the Input and Report boxes */
  width: 100%; /* Ensures child elements take up full width if needed */
}

body {
  background-color: black;
  font-family: Arial, Helvetica, sans-serif;
}

.device-overlay {
  border-radius: 10px;
  background-color: gray;
  width: 340px;
  height: 360px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: start;
  gap: 20px; /* Sets spacing between child elements */
  padding-top: 20px; /* Adds space above the first child element */
}

h1 {
  color: white;
  margin: 0; 
} 

</style>