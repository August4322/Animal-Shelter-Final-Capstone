<template>
  <div>
    <h1>Meet Our Volunteers!</h1>
    <div
      class="volunteer"
      v-for="volunteer in this.$store.state.volunteers"
      v-bind:key="volunteer.id"
    >
      <h2 class="name">{{ volunteer.name }}</h2>
      <p class="email">Email: {{ volunteer.email }}</p>
      <p class="phone">Phone Number: {{ volunteer.phone }}</p>
    </div>
  </div>
</template>

<script>
import volunteerService from "@/services/VolunteerService.js";
export default {
  name: "volunteers",
  components: {},
  data() {
    return {};
  },
  created() {
    volunteerService.findAllVolunteers().then((response) => {
      let list = response.data;
      this.$store.commit("ADD_VOLUNTEERS", list);
    });
  },
};
</script>

<style scoped>
</style>