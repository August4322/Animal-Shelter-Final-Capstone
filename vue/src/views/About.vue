<template>
  <div>
    <section id="left-panel">
    <header>
      <h1>Welcome</h1>
    </header>
    <h2>Animal shelter</h2>
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Fuga eaque quo cumque minus accusamus maiores
      consectetur! Expedita quis cumque, voluptatibus voluptatem laboriosam nobis unde! Porro consequuntur ad
      repudiandae doloribus odio?</p>
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia tenetur earum eligendi dicta magni vel illo
      architecto maiores, explicabo consequatur, hic omnis ex, vero quod porro beatae! Nobis, beatae accusantium.</p>
    <nav>
      <ul class="linkstyle">
        <!-- <li><a href="#">Home</a></li> -->
        <!-- <li><a href="#">About</a></li>
        <li><a href="#">Portfolio</a></li>
        <li><a href="#">Services</a></li>
        <li><a href="#">Contact</a></li> -->
       <li> <router-link v-bind:to="{name: 'login'}">Log in</router-link></li>
       <li> <router-link v-bind:to="{ name: 'home' }">Home</router-link> </li>
       <li><router-link v-bind:to="{ name: 'pets-view'}">Browse All Pets</router-link> </li>
       <li><router-link v-bind:to="{ name: 'volunteers' }">View Volunteers</router-link> </li>
       <li><router-link v-bind:to="{ name: 'addVolunteer' }">Apply To Be a Volunteer!</router-link> </li>
       <li><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout |</router-link></li>
      </ul>
    </nav>
    <footer>
      <ul class="social-icons">
        <li><a href="#"><i class="fab fa-facebook fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-instagram fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-twitter fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-pinterest fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-behance fa-3x"></i></a></li>
      </ul>
    </footer>
  </section>

   <section id="right-panel">
    <div id="welcome">
      <img class="imgstyle" src="/img/shelter.jpg" alt="">
    </div>
  </section> 




  </div>
</template>





<script>
export default {

}
</script>

<style scoped>

body {
  margin: 0;
  padding: 0;
  min-height: 100vh;
 
  display: flex;
  flex-direction: row;
 
}

#left-panel {
  background-color: #F7F7F7;
  width:35%;
  display:flex;
  flex-direction: column;
}

ul.social-icons {
  list-style-type: none;
  margin: 20px 20px;
  padding: 0;
  display: flex;
  flex-direction: row;
  gap:10px;
  /*flex-wrap:wrap;*/
  justify-content: space-between;

}
nav {
  display: flex;
  flex-direction: column;
  flex-grow:1;
}

#right-panel {
  display:flex;
  flex-direction: row;
  flex-grow: 1;
  justify-content:center;
  align-items: center;
  
  
}
h1,
h2 {
  font-family: 'Kalam', cursive;
  margin: 0;
  text-align: center;
}

h1 {
  font-size: 5rem;
}

h2 {
  font-size: 2rem;
  font-weight: 400;
  margin: 20px 0;
}

header {
  background-color: #F2CC65;
}

p {
  font-family: 'Oswald', sans-serif;
  font-weight: 300;
  font-size: 1.1rem;
  line-height: 2.1rem;
  padding: 0 20px;
}
nav ul {
  list-style-type: none;
  margin: 0 20px 0 20px;
  padding: 0;
}

/* nav ul li*/ .linkstyle { 
  font-family: 'Oswald', sans-serif;
  font-size: 2rem;
  font-weight: 400;
  text-transform: uppercase;
  border-bottom: 1px solid #707070;
  padding-top: 30px;
 
}

nav a,
nav a:visited {
  text-decoration: none;
  color: #1b1b1b;
}

nav a:hover {
  color: #F2CC65;
  padding-left: 5px;
}

.fab {
  color: #3A3B00
}
.social-icons li a:hover .fab {
  color: #F2CC65
}

 .imgstyle {
/* 
   background-color: #F2CC65;
  font-family: 'Kalam', cursive;
  text-align: center;
  font-size: 5rem;
  padding: 20px;
  border-radius: 10px; */

   display:flex;
  flex-direction: row;
  flex-grow: 1;
  justify-content:center;
  align-items: center;
 
 }



</style>

