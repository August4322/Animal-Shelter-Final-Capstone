<template>
  <div>
    <div>
      <form v-on:submit.prevent="saveVolunteer()">
        <div id="name">
          <label>Name</label>
          <input type="text" v-model="name" />
        </div>
        <div id="username">
          <label>Username</label>
          <input type="text" v-model="userName" />
        </div>
        <div id="email">
          <label>Email</label>
          <input type="text" v-model="email" />
        </div>
        <div id="phone-number">
          <label>Phone Number</label>
          <input type="long" v-model="phone" />
        </div>
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
      phone: "",
    };
  },
};
</script>

<style>
</style>