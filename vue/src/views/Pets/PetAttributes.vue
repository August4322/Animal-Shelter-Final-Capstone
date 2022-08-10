<template>
  <main>
    <div>
    <pet-details id="featured"></pet-details>
    </div>
  </main>
</template>

<script>
import PetDetails from '../../components/Pets/PetDetails.vue'

export default {
  components: { PetDetails },

}
</script>

<style scoped>
  main{
        height: 100vh;
        background-color: #d9f1d9;
        display: flex;
        justify-content: space-around;
        align-items: center;
  }

  #featured {
    width: 100%;
    height: 100%;
  }

  @media screen and (max-width: 800px) {
    main {
      flex-direction: column;
    }
    
  }
</style>