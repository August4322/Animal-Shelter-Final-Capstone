<template>
  <div class="home">
    <h1>Home</h1>
    
    <p>You must be authenticated to see this</p>
    <!-- <router-link :to="{ name: 'pageForVolunteer' }" v-if="$store.user.role==='ROLE_ADMIN'">volunteer menu</router-link> -->
    
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
