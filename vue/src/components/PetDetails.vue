<template>
<div>
<div v-for="pet in this.$store.state.pets" v-bind:key="pet.id" class="petCard">
    <div v-if="pet.available">
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
.petName {
font-size: 1.5rem;
}
div h3 {
font-size: 1rem;
}


 .petImg {
     max-width: 100%;
     height: auto;
     object-fit: contain;
     display: block;
     margin-left: auto;
     margin-right: auto;
     border-radius: 50%;
     

 }
 #frame {
    max-height: 200px;
    max-width: 200px;
}
 .petCard {
     /* border: solid black 1px;
     border-radius: 10px;
     width: 300px;
     height: 500px;
     margin: 15px;
     padding: 10px; */
     border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;

 }
 .petDetails{

    padding-top: 78px;
 }
</style>