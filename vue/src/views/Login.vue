<template>
  <div id="login" class="text-center">
    <div class="styleform">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only" >Username</label>
      <el-input
 
        size="medium"
        prefix-icon="el-icon-user"
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <el-input
      size="medium"
      prefix-icon="el-icon-lock"
      
      show-password
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <div class="buttonstyle">
      <router-link :to="{ name: 'register' }" style="background-color: transparent" >Need an account?</router-link>
      <button class="sizebutton" type="submit" style="background-color: transparent">Sign in</button>
      </div>
    </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/home");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style scoped>
.styleform {
  margin: 200px auto;
  background-image: linear-gradient(to bottom right, #FC4668, #3F5EFB);
  width: 350px;
  height: 100%;
  padding: 20px;
  border-radius: 10px;
}
.form-signin {
   background-image: linear-gradient(to bottom right, #FC4668, #3F5EFB);


}
/* .username {
  margin: 10px 0;

}
.password {
  margin: 10px 0;

} */
.buttonstyle {
  margin: 10px 0;
  text-align: right;
  background-color: transparent;
}
.h3 {
  background-color: transparent;
}
.sr-only {
  background-color: transparent;
}
.sizebutton{
  width: 100px;
  height: 30px;
}


</style>