<template>
  <div class="input-box">
    <div class="input-compass-container">
      <input 
        v-model="zipCode" 
        type="text" 
        placeholder="Enter ZIP code" 
        @keyup.enter="fetchWindDataByZip"
      />
      <div class="compass-display"
      >
        <img :src="windDirectionImg" alt="Compass Direction" v-if="windDirectionImg"/>
      </div>
    </div>
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
      windDirectionImg: 'direction_default.gif', // Holds the image URL dynamically and dispalys the default image otherwise
      errorMessage: '', // Tracks error messages
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

          // Dynamically update compass image based on wind direction
          this.updateWindDirection(response.data.windDeg);
        })
        .catch(error => {
          console.error('Error fetching wind data:', error);
          this.$emit('wind-data', null); // Clear wind data
          this.$emit('error-message', 'Failed to fetch wind data. Please check the ZIP code and try again.');
          this.windDirectionImg = '/direction_default.gif'; // Reset to default image
        });
    },

    // Update compass image based on wind direction
    updateWindDirection(windDeg) {
      const windDirectionMap = {
        N: '/direction_n.gif',
        NE: '/direction_ne.gif',
        E: '/direction_e.gif',
        SE: '/direction_se.gif',
        S: '/direction_s.gif',
        SW: '/direction_sw.gif',
        W: '/direction_w.gif',
        NW: '/direction_nw.gif',
      };

      this.windDirectionImg = windDirectionMap[windDeg] || null; // Set image or null if no match
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
            this.windDirectionImg = '/direction_default.gif'; // Reset to default image
          }
        );
      } else {
        this.$emit('error-message', 'Geolocation is not supported by your browser.');
        this.windDirectionImg = '/direction_default.gif'; // Reset to default image
      }
    },

    // Fetch wind data using latitude and longitude
    fetchWindDataByCoordinates(lat, lon) {
      this.errorMessage = ''; // Clear previous error
      ReportService.getByCoordinates(lat, lon) // Assuming this method exists in your service
        .then(response => {
          this.$emit('wind-data', response.data);
          this.$emit('error-message', '');

          // Dynamically update compass image based on wind direction
          this.updateWindDirection(response.data.windDeg);
        })
        .catch(error => {
          console.error('Error fetching wind data by location:', error);
          this.$emit('wind-data', null);
          this.$emit('error-message', 'Failed to fetch wind data for your location. Please try again.');
          this.windDirectionImg = '/direction_default.gif'; // Reset to default image
        });
    },
  },
};
</script>

<style scoped>
.input-box {
  border-radius: 10px;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: left;
}

.input-compass-container {
  display: flex;
  align-items: center; /* Align items vertically in the center */
  gap: 10px; /* Add space between the input and compass */
}

input {
  width: 232px;
  border: none;
  border-radius: 4px;
  background-color: #222;
  color: rgb(126, 255, 126);
  font-size: 16px;
  padding: 10px;
}

.compass-display {
  width: 38px;
  height: 38px;
  border-radius: 50%;
  display: flex;
  align-items: center; /* Center the image vertically */
  justify-content: center; /* Center the image horizontally */
  background-color: #222;

}

.compass-display img {
  width: 100%;
  height: auto; /* Maintain aspect ratio */
}

.button-container {
  display: flex;
  gap: 10px; /* Creates equal space between the buttons */
  justify-content: center;
  width: 300px;
  margin-top: 20px;
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

