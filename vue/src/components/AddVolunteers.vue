<template>
  <div>
    <div>
      <form class="form">
        <div id="name">
          <label>Name</label>
          <input type="text" v-model="volunteer.name" />
        </div>
        <div id="username">
          <label>Username</label>
          <input type="text" v-model="volunteer.username" />
        </div>
        <div id="email">
          <label>Email</label>
          <input type="text" v-model="volunteer.email" />
        </div>
        <div id="phone">
          <label>Phone Number</label>
          <input type="long" v-model="volunteer.phone" />
        </div>
        <button type="button" v-on:click="cancel()">Cancel</button> &nbsp;
        <button type="submit" v-on:click="submitForm()">
          Submit Application
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import volunteerService from "@/services/VolunteerService.js";
export default {
  name: "add-volunteer",
  data() {
    return {
      volunteer: {
        name: "",
        username: "",
        email: "",
        phone: "",
      },
    };
  },
  methods: {
    submitForm() {
      volunteerService
        .createVolunteer(this.volunteer)
        .then((response) => {
          if (response.status === 201) {
            this.$router.push("/");
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
    cancel() {
      this.$router.push("/");
    },
  },
};
</script>

<style scoped>
.form {
  background-color: white;
}
</style>