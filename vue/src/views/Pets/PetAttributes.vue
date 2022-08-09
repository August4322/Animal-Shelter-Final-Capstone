<template>
  <div>
    <pet-details/>
  </div>
</template>

<script>
import PetDetails from '../../components/Pets/PetDetails.vue'

export default {
  components: { PetDetails },

}
</script>

<style scoped>
    div {
        background: chocolate;
    }
</style>