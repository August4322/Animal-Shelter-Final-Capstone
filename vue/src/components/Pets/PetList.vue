<template>
  <div>
    <div id="container">
      <div
        class="petCard"
        v-for="pet in this.$store.state.pets"
        v-bind:key="pet.id"
      >
        <div v-if="pet.available">
          <div v-on:click="goToPet(pet.id)">
            <img id="frame" v-bind:src="pet.image" alt="Adopt this Pet Today!"/>
          </div>
          <h2 class="name">{{ pet.name }}</h2>
          <p class="tagline">{{ pet.tagline }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import petService from "@/services/PetService.js";

export default {
  name: "pet-list",
  components: {},
  data() {
    return {};
  },
  created() {
    petService.getListOfAllPets().then((response) => {
      let list = response.data;
      this.$store.commit("ADD_PETS", list);
    });
  },
  methods: {
    goToPet(petId) {
      this.$router.push({ name: "attributes", params: { id: petId } });
    },
  },
};
</script>

<style scoped>
.petCard {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
  border: 2px solid black;
  border-radius: 10px;
  width:  400px;
  height: auto;
  margin: 20px;
  background-color: #d9f1d9;
}


.petName {
  font-size: 1.5rem;
}
div h3 {
  font-size: 1rem;
}

#frame {
  height: 60%;
  width: 40%;
}
.petImg {
  max-width: 400px;
  height: 200px;
  object-fit: contain;
  display: block;
  margin-left: auto;
  margin-right: auto;
  border-radius: 50%;
}



.petDetails {
  padding-top: 78px;
}

#container {
  display: flex;
  justify-content: center;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
  margin: auto;
}
</style>