<template>
  <div>
          <table>
          <thead>
              <tr>
                  <th>Volunteer Id:</th>
                  <th>Name:</th>
                  <th>Username:</th>
                  <th>Email:</th>
                  <th>Phone:</th>
                  <th>Actions:</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="volunteer in this.$store.state.volunteers" v-bind:key="volunteer.id">
                
                  <td v-if="volunteer.applicationStatusId == 1">{{volunteer.id}}</td>
                  <td v-if="volunteer.applicationStatusId == 1">{{volunteer.name}}</td>
                  <td v-if="volunteer.applicationStatusId == 1">{{volunteer.username}}</td>
                  <td v-if="volunteer.applicationStatusId == 1">{{volunteer.email}}</td>
                  <td v-if="volunteer.applicationStatusId == 1">{{volunteer.phone}}</td>
                  <td v-if="volunteer.applicationStatusId == 1"><a href="#" v-on:click="approveVolunteer(volunteer)"> Approve </a></td>
                  <!--insert a checkbox input to toggle approved status-->
                  <!--<td>{{volunteer.}}</td>-->
                
              </tr>
          </tbody>
          </table>
  </div>
</template>

<script>
import volunteerService from '../services/VolunteerService.js';
export default {
    name: 'approve-volunteers',
    data() {
        return {
          errorMsg: "",

      newVolunteer: {
        id: "",
        name: "",
        email: "",
        phone: "",
        applicationStatusId: "",
        username:""
          
        }
    }
    },
    
  methods: {
    approve(){
      volunteerService.approveVolunteer(this.volunteer).then(
        (response) => {
          if (response.status === 201) {
            this.$router.push({ name: 'admin'});
          }
    });
      
    } 
  }
   

}
</script>

<style>

</style>