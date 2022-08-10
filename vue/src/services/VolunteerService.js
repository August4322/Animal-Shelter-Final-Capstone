import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    findAllVolunteers() {
        return http.get(`/volunteer`);
    },

    findVolunteerById(id) {
        return http.get(`/volunteer/${id}`);
    },

    createVolunteer(volunteer) {
        const url = "/volunteer";
        return http.post(url, volunteer);
    },

    updateVolunteer() {
        return http.put(`/volunteer`);
    },

    deleteVolunteer(id) {
        return http.delete(`/volunteer/${id}`);
    },

    saveVolunteer(volunteer) {
        if(volunteer.id) {
            return this.updateVolunteer(volunteer);
        } else {
            return this.saveVolunteer(volunteer);
        }
    }
}