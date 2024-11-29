import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {

    get(zipCode) {
        return http.get(`/api/wind/${zipCode}`);
    }
}

