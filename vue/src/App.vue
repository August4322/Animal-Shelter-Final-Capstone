<template>
  <div id="app">
    <head>
      <title>Navigation Bar</title>
      <link rel="stylesheet" type="text/css" href="src/assets/global.css" />
    </head>
    <body>
      <div class="mainContainer">
        <div id="header">
<<<<<<< HEAD
         <img src="/img/Banner900.jpg" alt="WildBreath Animal Shelter Banner"/>
=======
          <img
            src="/public/img/Banner900.jpg"
            alt="WildBreath Animal Shelter Banner"
          />
>>>>>>> ca876a6ae99786fb9523ac1e3ab89a4aff2b5c77
        </div>
        <div id="nav">
          <router-link class="link" v-bind:to="{ name: 'home' }"
            >Home</router-link
          >
          &nbsp;&nbsp;
          <router-link class="link" v-bind:to="{ name: 'about' }"
            >About Us</router-link
          >
          &nbsp;&nbsp;
          <router-link class="link" v-bind:to="{ name: 'pets-view' }"
            >Browse All Pets</router-link
          >
<<<<<<< HEAD
            &nbsp;&nbsp;
=======
          &nbsp;|&nbsp;
>>>>>>> ca876a6ae99786fb9523ac1e3ab89a4aff2b5c77
          <router-link
            class="link"
            v-bind:to="{ name: 'create' }"
            v-if="$store.state.token"
            >Add a Pet</router-link
          >

<<<<<<< HEAD

          &nbsp;&nbsp;
          <router-link class="link" v-bind:to="{ name: 'volunteers' }"
            >View Volunteers</router-link
          >
          
          &nbsp;&nbsp;
=======
          &nbsp;|&nbsp;
          <router-link class="link" v-bind:to="{ name: 'volunteers' }"
            >View Volunteers</router-link
          >

          &nbsp;|&nbsp;
>>>>>>> ca876a6ae99786fb9523ac1e3ab89a4aff2b5c77
          <router-link class="link" v-bind:to="{ name: 'addVolunteer' }"
            >Apply To Be a Volunteer!</router-link
          >
          &nbsp;&nbsp;
          <router-link
            class="link"
            v-bind:to="{ name: 'login' }"
            v-show="!$store.state.token"
            >Log in</router-link
          >
<<<<<<< HEAD
          &nbsp;&nbsp;
          <!--v-if="$store.state.user.authorities[0].name === 'ROLE_ADMIN'"  check the truthyness of using an && to check two things    
          <router-link class="link" v-bind:to="{name: 'admin'}" v-if="$store.state.user || $store.state.user.authorities[0].name === 'ROLE_ADMIN' ">Admin</router-link>
          -->
=======
>>>>>>> ca876a6ae99786fb9523ac1e3ab89a4aff2b5c77

          &nbsp;&nbsp;
          <router-link
            class="link"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout
          </router-link>
        </div>

        <router-view />
        <div id="footer">
          <img id="logo" src="../public/img/wildbreath.jpg" />
        </div>
      </div>
    </body>
  </div>
</template>
