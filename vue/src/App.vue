<template>
  <div id="app">
    <div id="nav">
      <router-link class="link" v-bind:to="{ name: 'home' }">Home</router-link> &nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{ name: 'pets-view'}">Browse All Pets</router-link> &nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{ name: 'volunteers' }">View Volunteers</router-link> &nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{ name: 'addVolunteer' }">Apply To Be a Volunteer!</router-link> &nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{name: 'login'}">Log in</router-link> &nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout </router-link> &nbsp;&nbsp;
      <router-link class="link" v-bind:to="{name: 'create'}" v-if="$store.state.token">&nbsp;| Add a Pet</router-link>
    </div>
    
    <router-view />
    <div id="footer"><img id="logo" src='../public/img/wildbreath.jpg'/> </div>
  </div>
</template>

<style scoped>
 #nav{
   display: flex;
   justify-content: space-evenly;
   flex-direction: row;
   width: 100vw;
   border-color: #434343ff;
   background-color: #434343ff;
   
 }

 .link{
   background-color: #434343ff;
   color: #d9f1d9;

 }

 #footer{
   display:flex
 }

 #logo{
   width: 100px;
   height: 100px;
 }

</style>