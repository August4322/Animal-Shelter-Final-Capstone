<template>
<div>
<div v-for="pet in this.$store.state.pets" v-bind:key="pet.id" class="petCard">
    <div v-if="pet.available">
    <img v-bind:src="pet.image" alt="picture of animal" class="petImg">
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
     height: 
 }
 .petCard {
     border: solid black 1px;
     border-radius: 10px;
     width: 300px;
     height: 500px;
     margin: 15px;
     padding: 10px;

 }
</style>