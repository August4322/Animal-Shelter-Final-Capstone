<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> &nbsp;
      <router-link v-bind:to="{ name: 'pets-view'}">Browse All Pets</router-link>
    </div>
    
    <router-view />
  </div>
</template>
