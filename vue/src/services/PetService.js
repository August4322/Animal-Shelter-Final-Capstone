import axios from 'axios';

const http = axios.create({
    baseURL: "https://localhost:9000"
});



export default {

    getListOfAllPets() {
        
        return http.get('/pets');
    },

  
}