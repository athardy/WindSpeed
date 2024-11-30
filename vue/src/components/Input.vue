<template>
    <div class="input-box">
        <input v-model="zipCode" type="text" placeholder="Enter ZIP Code" />
        <button @click="fetchWindData">Get Wind Data</button>
    </div>
</template>

<script>
import ReportService from '../services/ReportService.js';

export default {
    data() {
        return {
            zipCode: '',
        };
    },
    methods: {
        fetchWindData() {
            ReportService.get(this.zipCode).then(response => {
                this.$emit('wind-data', response.data);
            })
            .catch(error => {
                console.error('Error fetching wind data:', error);
            });
        }
    }
}
</script>

<style scoped>
.input-box {
  border-radius: 25px;
  background: #4cad1f85;
  padding: 20px;
  width: 280px;
  height: 25px;
}

</style>