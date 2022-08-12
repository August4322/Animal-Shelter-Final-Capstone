import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000/"
});



export default {

    getListOfAllPets() {
        
        return http.get('pets');
    },

    getPetDetailsById(id) {
        return http.get(`pets/${id}`);
    },

}