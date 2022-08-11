<template>
  <div>
      <div>
      <form class="form">
        <div id="name">
          <label>Name</label>
          <input type="text" v-model="volunteer.name" />
        </div>
        <div id="username">
          <label>Username</label>
          <input type="text" v-model="volunteer.username" />
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
export default {

}
</script>

<style>

</style>