<template>
  <div>
      <div>
      <form class="form">
        <div id="gender">
          <label>Gender</label>
          <input type="text" v-model="pet.gender" />
        </div>
        <div id="name">
          <label>Name</label>
          <input type="text" v-model="pet.name" />
        </div>
        <div id="type">
          <label>Animal Type</label>
          <input type="text" v-model="pet.type" />
        </div>
        <div id="color">
          <label>Color</label>
          <input type="long" v-model="pet.color" />
        </div>
        <div id="age">
            <label>Age in years</label>
            <input type="decimal" v-model="pet.age"/>
        </div>
        <div id="image">
            <label>Image URL</label>
            <input type ="text" v-model="pet.image"/>
        </div>
        <div id="tagline">
            <label>About Me</label>
            <input type="text" v-model="pet.tagline"/>
        </div>
        <div id="available">
            <label>Available</label>
            <input type="checkbox" v-model="pet.available"/>
        </div>
        <div id="fixed">
            <label>Is Fixed</label>
            <input type="checkbox" v-model="pet.fixed"/>
        </div>
        <button type="button" v-on:click="cancel()">Cancel</button> &nbsp;
        <button type="submit" v-on:click.prevent="savePet()">
          Submit Application
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import petService from "@/services/PetService.js";
export default {
    name: 'add-pet',
    data() {
        return{
            errorMsg: "",
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
    props: ["existingPet"],

    created() {
        if(this.existingPet) {
            this.pet = this.existingPet;
        }

    },

    methods: {
        savePet() {
            petService.addPet(this.pet).then(
                (response) => {
                    if(response.status === 201) {
                    this.$router.push({name:'pets-view'});
                    }
                }
            )
            .catch((error) => {
                 if(error.response) {
                        this.errorMsg = error.response.statusText;
                    } else if (error.request) {
                        this.errorMsg = "We couldn't find the server";
                    } else {
                        this.errorMsg = "Error - we couldn't create the request";
                    }
            });
            },
            cancel() {
                this.$router.push({name: 'pets-view'});
            }
        }
    }


</script>

<style>

</style>