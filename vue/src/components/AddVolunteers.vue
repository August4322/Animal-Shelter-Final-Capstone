<template>
  <div>
    <div>
      <form v-on:submit.prevent="saveVolunteer()">
        <label>Name</label>
        <input type="text" v-model="name" />
        <label>Username</label>
        <input type="text" v-model="userName" />
        <label>email</label>
        <input type="text" v-model="email" />
        <label>Phone Number</label>
        <input type="long" v-model="phone" />
            <button>Submit</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "add-volunteer",
  data() {
    return {
      name: "",
      userName: "",
      email: "",
      phone:"",
    };
  },
};
</script>

<style>
</style>