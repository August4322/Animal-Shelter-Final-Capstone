<template>
  <div class="home">
    <head>
    </head>
    <body>
      <h1>Welcome to WildBreath Animal Shelter!</h1>
      <p>In the market for a new best friend? Check out our adoptable animals!</p>
      <div>
        <video width=800px height=600px  controls autoplay muted >
           <source src="/video/6mbs.mp4" type="video/mp4">Your browser does not support the video tag
           </video>
          <!--
        <iframe id="cats"
          width= 1000px;
          height=600px;
          src="https://www.youtube.com/embed/KvE92fCMbmc?autoplay=1"
          title="YouTube video player"
          frameborder="0"
          autoplay muted
          allow="autoplay"
          
        >
        </iframe>
        -->
      </div>
    </body>
  </div>
</template>

<script>
import volunteerService from '@/services/VolunteerService.js';
import petService from '@/services/PetService.js';

export default {
  name: "home",
   created() {
    volunteerService.findAllVolunteers().then((response) => {
      let list = response.data;
      this.$store.commit("ADD_VOLUNTEERS", list);
    });
     petService.getListOfAllPets().then((response) => {
      let list = response.data;
      this.$store.commit("ADD_PETS", list);
    });


    
    
  },

};
</script>
