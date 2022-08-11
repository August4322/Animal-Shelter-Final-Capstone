<template>
  <div id="app">
    <div id="nav">
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link> &nbsp;|&nbsp; -->
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout |</router-link> &nbsp;&nbsp;
      <router-link v-bind:to="{ name: 'pets-view'}">Browse All Pets</router-link> &nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'volunteers' }">View Volunteers</router-link> &nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'addVolunteer' }">Apply To Be a Volunteer!</router-link> &nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'login'}">Log in</router-link> -->
    </div>
    
    <router-view />
  </div>
</template>

<style scoped>
 
</style>