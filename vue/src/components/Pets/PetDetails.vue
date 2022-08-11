<template>
  <div>
    <div v-if="isLoading">
        <img src='/img/yak_loader.gif'/>
    </div>
    <!----------------------------------------------------------------->
      <div class="container">
        <h2 class="name">{{ pet.name }}</h2>
        
          <img class="pic" v-bind:src="pet.image" alt="Are looks all that matter to you?"/>
        
       
          <h3>"{{ pet.tagline }}"</h3>
          <div class="details">
              <p>Animal Member Id: &emsp;{{pet.id}}</p>
              <p>Gender: {{pet.gender}}</p>
              <p>Age: {{pet.age}}</p>
              <div v-if="pet.gender === 'Female' && pet.type != 'bunny'">
                  <p>{{pet.fixed ? 'Spayed' : 'Spayed'}} </p>
              </div> 
              <div v-if="pet.gender === 'Male'">
                  <p>Fixed: {{pet.fixed ? 'Neutered': 'Neutered'}}</p>
              </div>
          </div>

        

      </div>
    <router-link v-bind:to="{name: 'addVolunteer'}" id="volunteer">Volunteer To Play With Me</router-link>
  </div>
</template>

<script>
import petService from "@/services/PetService.js";

export default {
  name: "pet-details",
  data() {
    return {
        isLoading: true,
        pet: {
        id: "",
        gender: "",
        name: "",
        type: "",
        color: "",
        age: "",
        image: "",
        tagline: "",
        available: "",
        fixed: "",
      },
    };
  },
  created() {
    petService.getPetDetailsById(this.$route.params.id).then((response) => {
      this.pet = response.data;
      this.isLoading = false;
    });
  },
};
</script>

<style scoped>

.container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    row-gap: 20px;
    column-gap: 50px;
    align-items: center;
    height: 90vh;
}
.name{
    padding-top: 8px;
    font-size: 3rem;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    margin: auto;
    color: #000000;
    text-decoration: underline overline;
    
}

.pic{
    width: 420px;
    height: 620px;
    border-radius: 12px;
    border: 4px #f6f6de;
}

h3{
    font-family:Verdana, Geneva, Tahoma, sans-serif;
    font:italic;
    margin: -15px;
}

.details{
    font-size: 20px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    display: flex;
    justify-content: space-between;
    gap:40px;
    margin-top: -3px;
}
#volunteer{
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  font-size: 18px;
  padding-bottom: -40px;
  
}

</style>