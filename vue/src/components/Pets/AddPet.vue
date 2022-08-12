<template>
  <div>
      <div>
      <form class="form">
        <div id="gender">
          <label>Gender</label>
          <input type="text" v-model="pet.gender" />
        </div>
        <div id="pet-name">
          <label>Pet Name</label>
          <input type="text" v-model="volunteer.petName" />
        </div>
        <div id="email">
          <label>Email</label>
          <input type="text" v-model="volunteer.email" />
        </div>
        <div id="phone">
          <label>Phone Number</label>
          <input type="long" v-model="volunteer.phone" />
        </div>
        <button type="button" v-on:click="cancel()">Cancel</button> &nbsp;
        <button type="submit" v-on:click="submitForm()">
          Submit Application
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import petService from "@/services/PetService.js";
export default {
    name: 'add-new-pet',
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
                () => {
                    this.$router.push({name:"pets-view"})
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
                this.$router.push("/");
            }
        }
    }


</script>

<style>

</style>