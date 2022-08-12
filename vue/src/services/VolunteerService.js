import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    findAllVolunteers() {
        return http.get(`/volunteers`);
    },

    findVolunteerById(id) {
        return http.get(`/volunteers/${id}`);
    },

    createVolunteer(volunteer) {
        const url = "/volunteers";
        return http.post(url, volunteer);
    },

    updateVolunteer() {
        return http.put(`/volunteers`);
    },

    deleteVolunteer(id) {
        return http.delete(`/volunteers/${id}`);
    },

    saveVolunteer(volunteer) {
        if(volunteer.id) {
            return this.updateVolunteer(volunteer);
        } else {
            return this.createVolunteer(volunteer);
        }
    }
}