<template>
  <div>
    <div v-if="isLoading">
      <img id="loader" src="@/assets/animal_loader.gif" />
    </div>
    <div>
      <!--bind the imported component props to return property from the view-->
      <pet-details v-bind:petFacts="petCard" id="featured"/>
    </div>
  </div>
</template>

<script>
import PetDetails from "../../components/Pets/PetDetails.vue";

export default {
  components: {
     PetDetails 
     },
  data() {
    return {
      //declare the property to be passed to the imported component through vbind above
      petCard: {},
      isLoading: true,
    }
  },
  created() {
    //load up the object into the above property through 
    //the find method pulling the param off the url
    if (this.$route.params.id) {
      this.petCard = this.$store.state.pets.find((pet) => {
        return pet.id === this.$route.params.id;
      });
      this.isLoading = false;
    }
  },

};
</script>

<style scoped>

</style>