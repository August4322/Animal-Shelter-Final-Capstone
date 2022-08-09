<template>
<div>
<div v-for="pet in this.$store.state.pets" v-bind:key="pet.id" class="petCard">
    <img v-bind:src="pet.image" alt="picture of animal" class="petImg">
    <h2 class="petName">{{pet.name}}</h2>
    <h3>{{pet.tagline}}</h3>
     
 
</div>
</div>



  
</template>

<script>

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
   

}
</script>

<style scoped>
 .petImg {
     width: 200px;
 }
</style>