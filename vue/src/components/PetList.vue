<template>
  <div>
      <pet-details/>
                 


  </div>
</template>

<script>
import petService from '@/services/PetService.js';
import PetDetails from './PetDetails.vue';


export default {
    name: 'pet-list',
    components: {
        PetDetails
    },
    data() {
        return {
            petsList: []
        }
    },
    created() {
            // petService.getListOfAllPets().then( response => {
            //     this.petsList = response.data;
            //     console.log(response);
            // })

            petService.getListOfAllPets().then(
                response => {
                    let list = response.data;
                    this.$store.commit("ADD_PETS", list);
                }
            );
        
    }
    
}
</script>

<style>

</style>