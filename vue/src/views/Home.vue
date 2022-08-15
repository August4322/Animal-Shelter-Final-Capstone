<template>
  <div class="home">
    <h1>Welcome to Wildbreath Animal Shelter!</h1>

    <p>
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Fuga eaque quo
      cumque minus accusamus maiores consectetur! Expedita quis cumque,
      voluptatibus voluptatem laboriosam nobis unde! Porro consequuntur ad
      repudiandae doloribus odio?
    </p>
    <!-- <router-link :to="{ name: 'pageForVolunteer' }" v-if="$store.user.role==='ROLE_ADMIN'">volunteer menu</router-link> -->
    <div>
      <iframe width="560" height="315" src="https://www.youtube.com/embed/cKgVCF0tlPI" 
      frameborder="0" 
      allow="autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture">
      </iframe>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>
