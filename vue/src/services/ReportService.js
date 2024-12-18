import axios from 'axios';

const http = axios.create({
    baseURL: import.meta.env.VITE_REMOTE_API
});

export default {

    getByZip(zipCode) {
        return http.get(`/wind/zip/${zipCode}`);
    },
    
    getByCoordinates(lat, lon) {
        return http.get('wind/coordinates', {
            params: {lat, lon}
        });
    }
}

