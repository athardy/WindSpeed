<template>
    <div class="report-box">
      <!-- Display error message if provided -->
      <div v-if="errorMessage">
        <p class="error-message">{{ typedMessage }}</p>
      </div>
      <!-- Display wind data if available -->
      <div v-else-if="windData">
        <p>{{ typedLocation }}</p>
        <p>{{ typedWindSpeed }}</p>
        <p v-if="windData.windGust !== null">{{ typedWindGust }}</p>
      </div>
      <!-- Display fallback message if no data or error -->
      <div v-else>
        <p>{{ typedFallbackMessage1 }}</p>
        <p>{{ typedFallbackMessage2 }}</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: ['windData', 'errorMessage'],
    data() {
      return {
        typedMessage: '',
        typedLocation: '',
        typedWindSpeed: '',
        typedWindGust: '',
        typedFallbackMessage1: '',
        typedFallbackMessage2: '',
        currentLine: 0, // To track which line to type next
        typingInterval: null, // To store the interval ID and clear it if needed
      };
    },
    watch: {
      // Watch for changes in windData or errorMessage and reset typing effect
      windData: 'startTypingEffect',
      errorMessage: 'startTypingEffect',
    },
    methods: {
      startTypingEffect() {
        // Clear previous typed content and reset line tracking
        this.typedMessage = '';
        this.typedLocation = '';
        this.typedWindSpeed = '';
        this.typedWindGust = '';
        this.typedFallbackMessage1 = '';
        this.typedFallbackMessage2 = '';
        this.currentLine = 0;
  
        // If there's an ongoing typing effect, clear it
        if (this.typingInterval) {
          clearInterval(this.typingInterval);
          this.typingInterval = null;
        }
  
        // Start typing the new content
        if (this.errorMessage) {
          this.typeOutMessage(this.errorMessage, 'typedMessage');
        } else if (this.windData) {
          this.typeOutMessage(this.windData.location, 'typedLocation');
        } else {
          // Fallback message
          this.typeOutMessage('Welcome to WindSpeed', 'typedFallbackMessage1');
        }
      },
  
      // Helper method to simulate typing sequentially
      typeOutMessage(message, property) {
        let i = 0;
        this.typingInterval = setInterval(() => {
          this[property] += message[i];
          i++;
          if (i === message.length) {
            clearInterval(this.typingInterval);
            this.typingInterval = null;
  
            // After the current line finishes, move to the next
            if (this.currentLine === 0 && this.windData) {
              this.currentLine++;
              this.typeOutMessage(`Wind Speed: ${this.windData.windSpeed} mph`, 'typedWindSpeed');
            } else if (this.currentLine === 1 && this.windData) {
              this.currentLine++;
              if (this.windData.windGust !== null) {
                this.typeOutMessage(`Wind Gusts: ${this.windData.windGust} mph`, 'typedWindGust');
              }
            } else if (this.currentLine === 0 && !this.windData && !this.errorMessage) {
              this.currentLine++;
              this.typeOutMessage('How would you like to recieve your wind data?', 'typedFallbackMessage2');
            }
          }
        }, 40); // Adjust typing speed (milliseconds)
      },
    },
    mounted() {
      this.startTypingEffect();
    },
  };
  </script>
  
  <style scoped>
  .report-box {
    width: 260px;  
    height: 120px;
    background-color: #222;
    color: rgb(126, 255, 126);
    border-radius: 5px;
    padding: 20px;
    text-align: left;
  }
  
  .error-message {
    color:rgb(233, 129, 129);
  }
  </style>
