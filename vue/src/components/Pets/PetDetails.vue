<template>
<div>
    <div id="container">
<div v-for="pet in this.$store.state.pets" v-bind:key="pet.id" class="petCard">
    
     <div id="frame">
    <img v-bind:src="pet.image" alt="picture of animal" class="petImg">
     </div>
     <div class="petDetails" >
    <h2 class="petName">{{pet.name}}</h2>
    <h3>{{pet.tagline}}</h3>
   <ul class="details">
        <li>{{pet.gender}}</li>
        <li>{{pet.age}}</li>
        <li>{{pet.fixed ? "I am fixed" : "I am not fixed"}} </li>
    </ul>
    
    </div>
</div>

     
 
</div>
</div>



  
</template>

<script>
import petService from '@/services/PetService.js'

export default {
    name: 'pet-details',
    data() {
        return {
            pet: {
                id: '',
                gender: '',
                name: '',
                type: '',
                color: '',
                age: '',
                image: '',
                tagline: '',
                available: '',
                fixed: '',

            }
        }
    },
    created() {
    petService.getPetDetailsById(this.$route.params.id).then(
      (response) => {
        this.pet = response.data;
      }
    )
  }


    }
   

</script>

<style scoped>
.petName {
font-size: 1.5rem;
}
div h3 {
font-size: 1rem;
}


 .petImg {
     max-width: 200px;
     height: auto;
     object-fit: contain;
     display: block;
     margin-left: auto;
     margin-right: auto;
     border-radius: 50%;
     

 }
 #frame {
    height: 200px;
    width: 200px;
    
}
 .petCard {
     border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    background-color: #d9f1d9;
    display: flex;
    flex-direction: column;
    align-items:center;

    
 }
 .petDetails{

    padding-top: 78px;
 }

 #container {
     display:flex;
    justify-content: space-evenly;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: center;
 }
</style>