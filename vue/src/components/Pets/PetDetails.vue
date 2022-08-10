<template>
  <div>
    <div>
      <body id="featured">
        <div><h2 id="name">{{ pet.name }}</h2></div>
        <div>
          <img
            v-bind:src="pet.image"
            alt="Are looks all that matter to you?"
            class="petImg"
          />
        </div>
        <div>
          <h3>{{ pet.tagline }}</h3>
          <div>
            <ul>
              <li>{{ pet.gender }}</li>
              <li>{{ pet.age }}</li>
              <li>{{ pet.fixed ? "I am fixed" : "I am not fixed" }}</li>
            </ul>
          </div>
        </div>
      </body>
    </div>
  </div>
</template>

<script>
import petService from "@/services/PetService.js";

export default {
  name: "pet-details",
  data() {
    return {
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
    });
  },
};
</script>

<style scoped>
#name{
    font-size: 5rem;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    margin: auto;
}

#featured {
    display: flex;
  justify-content: space-evenly;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center; 
}
body :first-child{
    justify-items: center;
}
div h3 {
  font-size: 1rem;
}

#attributes-list {

}

.petImg {
  width: 600px;
  height: auto;
  margin-left: auto;
  margin-right: auto;
  border-radius: 50%;
}
#frame {
  height: 200px;
  width: 200px;
}
.petCard {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
  background-color: #d9f1d9;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.petDetails {
  padding-top: 78px;
}

#featured {
 
}
</style>