<template>
  <div id="main-grid">
    <div v-if="isLoading">
        <img id="loader" src='@/assets/animal_loader.gif'/>
    </div>
    <!----------------------------------------------------------------->
    
      <div class="container" v-else>
      <div id="name">{{ pet.name }}</div>
        <div id="edit">
        <router-link v-bind:to="{name: 'edit', params: {id: pet.id}}" v-if="$store.state.token">Edit Pet</router-link>
        </div>
    
          <img id="pic" v-bind:src="pet.image" alt="Are looks all that matter to you?"/>
        
       
          <h3 id=caption>"{{ pet.tagline }}"</h3>
          <div id="details">
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
          <router-link v-bind:to="{name: 'addVolunteer'}" id="volunteer">Volunteer To Play With Me</router-link>

        

      </div>
    
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
    petService.getPetDetailsById(this.$route.params.id).then(
      (response) => {
           setTimeout( () => {
               this.pet = response.data;
               this.isLoading = false;
            }, 2500);
  })
  }
}

</script>

<style scoped>
#main-grid{
 
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
  "name"
  "edit"
  "pic"
  "details"
  "volunteer"
}
@media screen and (max-height: 800px) {
  #main-grid {
    grid-template-columns: 1fr 1fr 2fr 1fr 3fr 1fr;
    grid-template-areas:
    "name pic "
  }
  
}

.container {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    row-gap: 24px;
    column-gap: 50px;
    align-items: center;
    height: 90vh;
}




#name{
    width: 100%;
    padding-top: 8px;
    font-size: 3rem;
    font-family: 'Lora', 'Arial Narrow', Arial, sans-serif;
    margin: auto;
    color: #d9f1d9;
    text-decoration-line: 1px;
    text-decoration-color: #d9f1d9;
    margin:18px;
    background-color: #434343ff;
    display: block;
    
}

#pic{
    width: 320px;
    height: 520px;
    border-radius: 12px;
 
}

#loader {
    width: auto;
    height: 80vh;
   
}
#caption{
    font-family: 'Lora', Verdana, Geneva, Tahoma, sans-serif;
    font:italic;
    margin: -15px;
}

#details{
   font-size: 20px;
    font-family: 'Lora', Verdana, Geneva, Tahoma, sans-serif;
    display: flex;
    justify-content: space-between;
    gap:40px;
    margin-top: -3px;
}
#volunteer{
  font-family: 'Lora', Verdana, Geneva, Tahoma, sans-serif;
  font-size: 18px;
  padding-bottom: -40px;
  
}
#edit{
  font-size: 20px;
  font-family: 'Lora', Verdana, Geneva, Tahoma, sans-serif;
}

</style>