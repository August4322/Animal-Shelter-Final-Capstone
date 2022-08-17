<template>
  <div>
    <head>
    </head>
    <body>
    <h1>Meet Our Volunteers!</h1>
    <div
      class="volunteer"
      v-for="volunteer in this.$store.state.volunteers"
      v-bind:key="volunteer.id"
    > 
    <div v-if="volunteer.applicationStatusId === 2">
      <h2 class="name">{{ volunteer.name }}</h2>
      <p class="email">Email: {{ volunteer.email }}</p>
      <p class="phone">Phone Number: {{ volunteer.phone }}</p>
    </div>
    </div>
    </body>
  </div>
</template>

<script>

export default {
  name: "volunteers",
  components: {},
  data() {
    return {};
  },
  
};
</script>

<style scoped>
</style>