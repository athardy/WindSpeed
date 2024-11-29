<template>
    <div v-if="windData">
        <h3>Wind Report for {{ windData.location }}</h3>
        <p>Wind Speed: {{ windData.windSpeed }}</p>
        <p v-if="windData.windGust !== null">Wind Gusts: {{ windData.windGust }} mph</p>
    </div>
    <div v-else>
        <p>No data available</p>
    </div>
</template>

<script>
export default {
    props: ['windData'],
};
</script>