<template>
    <div>
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