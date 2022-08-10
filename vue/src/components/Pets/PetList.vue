<template>
  <div>
      <div class="container"> 
      <div class="card" v-for="pet in this.$store.state.pets" v-bind:key="pet.id">
          <div v-if="pet.available">
              <div class="pet-pic">
            <img v-bind:src="pet.image" alt="Adopt this Pet Today!" v-on:click="goToPet(pet.id)"/>
            </div>
            <h2 class="name">{{pet.name}}</h2>
            <p class="tagline">{{pet.tagline}}</p>

           </div> 
        </div> 
      </div>    


  </div>
</template>

<script>
import petService from '@/services/PetService.js';



export default {
    name: 'pet-list',
    components: {
        
    },
    data() {
        return {
           
        }
    },
    created() {
            petService.getListOfAllPets().then(
                response => {
                    let list = response.data;
                    this.$store.commit("ADD_PETS", list);
                }
            );
        
    },
    methods: {
        goToPet(petId) {
            this.$router.push({name: "attributes", params: {id: petId}})
          
        
        }
    }
    
}
</script>

<style scoped>
.card {
     display:flex;
    justify-content: space-evenly;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: center;
}

.pet-pic{
     max-width: 200px;
     height: auto;
     object-fit: contain;
     display: block;
     margin-left: auto;
     margin-right: auto;
     border-radius: 50%;
}

</style>