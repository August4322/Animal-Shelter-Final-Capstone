<template>
  <div>
          <table>
          <thead>
              <tr>
                  <th>Volunteer Id:</th>
                  <th>Name:</th>
                  <th>Email:</th>
                  <th>Phone Number:</th>
                  <th>Actions</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="volunteer in this.$store.state.volunteers" :key="volunteer.id">
                  <td>{{volunteer.id}}</td>
                  <td>{{volunteer.name}}</td>
                  <td>{{volunteer.email}}</td>
                  <td>{{volunteer.phone}}</td>
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
            volunteer: {}
        }
    },
    
  methods: {
    approve(){
      volunteerService.approveVolunteer(this.volunteer);
    } 
  }
   

}
</script>

<style>

</style>