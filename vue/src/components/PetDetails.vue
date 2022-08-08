<template>
<div class="pet">
    <img v-bind:src="pet.image" alt="picture of animal" class="petImage">
    

 

</div>



  
</template>

<script>
import petService from '@/services/PetService'
export default {
    create(){
        this.load()
    },
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
    load() {
        petService.get("http://localhost:9000/pets").then(res => {this.pet = res.name})
    }

}
</script>

<style>

</style>