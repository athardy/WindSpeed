<template>
    <div class="report-box">
        <div v-if="windData">
            <h2>{{ windData.location }}</h2>
            <p>Wind Speed: {{ windData.windSpeed }} mph</p>
            <p v-if="windData.windGust !== null">Wind Gusts: {{ windData.windGust }} mph</p>
        </div>
        <div v-else>
            <p>No data available</p>
        </div>
    </div>
</template>

<script>
export default {
    props: ['windData'],
};
</script>

<style scoped>
.report-box {
  border-radius: 25px;
  background: #3351fd9a;
  color: white;
  padding: 20px;
  width: 280px;
  height: 140px;
}

h2, p {
    text-align: center;
}
</style>