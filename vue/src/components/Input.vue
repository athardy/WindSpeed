<template>
  <div class="input-box">
    <input 
      v-model="zipCode" 
      type="text" 
      placeholder="Enter ZIP code" 
    />
    <div class="button-container">
      <button @click="fetchWindDataByZip">Search by ZIP</button>
      <button @click="fetchWindDataByLocation">Current Location</button>
    </div>
  </div>
</template>

<script>
import ReportService from '../services/ReportService.js';

export default {
  data() {
    return {
      zipCode: '',
      errorMessage: '', // Track error messages
    };
  },
  methods: {
    // Fetch wind data using ZIP code
    fetchWindDataByZip() {
      this.errorMessage = ''; // Clear previous error
      ReportService.getByZip(this.zipCode)
        .then(response => {
          this.$emit('wind-data', response.data); // Pass wind data to parent
          this.$emit('error-message', ''); // Clear any previous error
        })
        .catch(error => {
          console.error('Error fetching wind data:', error);
          this.$emit('wind-data', null); // Clear wind data
          this.$emit('error-message', 'Failed to fetch wind data. Please check the ZIP code and try again.');
        });
    },

    // Fetch wind data using current location
    fetchWindDataByLocation() {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
          (position) => {
            const { latitude, longitude } = position.coords;
            this.fetchWindDataByCoordinates(latitude, longitude);
          },
          (error) => {
            console.error('Error getting location:', error.message);
            this.$emit('error-message', 'Unable to retrieve location. Please allow location access.');
          }
        );
      } else {
        this.$emit('error-message', 'Geolocation is not supported by your browser.');
      }
    },

    // Fetch wind data using latitude and longitude
    fetchWindDataByCoordinates(lat, lon) {
      this.errorMessage = ''; // Clear previous error
      ReportService.getByCoordinates(lat, lon) // Assuming this method exists in your service
        .then(response => {
          this.$emit('wind-data', response.data);
          this.$emit('error-message', '');
        })
        .catch(error => {
          console.error('Error fetching wind data by location:', error);
          this.$emit('wind-data', null);
          this.$emit('error-message', 'Failed to fetch wind data for your location. Please try again.');
        });
    }
  }
};
</script>

<style scoped>
.input-box {
  border-radius: 10px;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

input {
  width: 280px;
  border: none;
  border-radius: 4px;
  background-color: #222;
  color: rgb(126, 255, 126);
  font-size: 16px;
  margin-bottom: 20px;
  padding: 10px;
}

.button-container {
  display: flex;
  gap: 10px; /* Creates equal space between the buttons */
  justify-content: center;
  width: 300px;
}

button {
  flex: 1; /* Makes buttons the same size */
  padding: 10px;
  border: none;
  background-color: #5e5f5e;
  color: white;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  box-sizing: border-box;
  transition: box-shadow 0.3s ease, color 0.3s ease;
}

button:hover {
  box-shadow: 0 0 0 2px rgb(126, 255, 126); /* Green border effect on hover */
  color: rgb(126, 255, 126);
}
</style>
