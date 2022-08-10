<template>
  <div>
    <div v-if="isLoading">
        <img src='/img/yak_loader.gif'/>
    </div>
    <!----------------------------------------------------------------->
      <div class="container">
        <h2 class="name">{{ pet.name }}</h2>
        <div>
          <img class="pic" v-bind:src="pet.image" alt="Are looks all that matter to you?"/>
        </div>
       
          <h3>{{ pet.tagline }}</h3>
          <div class="details">
              <p>Animal Member Id:{{pet.id}}</p>
              <p>Gender: {{pet.gender}}</p>
              <p>Age: {{pet.age}}</p>
              <div v-if="pet.gender === 'female'">
                  <p>{{pet.fixed ? 'Spayed' : 'Spayed'}} </p>
              </div>
              <div v-if="pet.gender === 'male'">
                  <p>Fixed: {{pet.fixed ? 'Neutered': 'Neutered'}}</p>
              </div>
          </div>

        

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
    grid-area: name;
}

.pic{
    width: 440px;
    height: auto;
    border-radius: 12px;
    border: 4px #fffff5;
}

h3{
    font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    font:italic;
    margin: -15px;
}

.details{
    font-size: 20px;
    display: flex;
    justify-content: space-between;
    gap:40px;
}

</style>