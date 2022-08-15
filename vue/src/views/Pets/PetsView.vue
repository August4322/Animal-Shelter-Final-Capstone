<template>
  <div>
      <pet-list/>
  </div>
</template>

<script>

import PetList from '../../components/Pets/PetList.vue'
import petService from "@/services/PetService.js";
export default {
  components: { PetList },
  created() {
    petService.getListOfAllPets().then((response) => {
      let list = response.data;
      this.$store.commit("ADD_PETS", list);
    });
  },


}
</script>

<style scoped>
div {
background: #d9f1d9;
margin-left: auto;
margin-right: auto;
}

</style>>

