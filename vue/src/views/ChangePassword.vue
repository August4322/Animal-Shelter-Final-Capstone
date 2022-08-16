<template>
  <div id="change">
    <el-form
      :model="user"
      :rules="resetFormRules"
      ref="resetForm"
      status-icon
      label-width="100px"
    >
      <el-form-item label="Current Password：" prop="password">
        <el-input 
         type="password" v-model="user.password" auto-complete="off" show-password></el-input>
      </el-form-item>
      <el-form-item label="New Password：" prop="newpwd">
        <el-input type="password" v-model="user.newpwd" auto-complete="off" show-password></el-input>
      </el-form-item>
      <el-form-item label="Confirm Password：" prop="newpassword1">
        <el-input type="password" v-model="user.newpassword1" auto-complete="off" show-password></el-input>
      </el-form-item>
      <el-form-item>
        <el-button class="stylebutton" type="primary" @click.prevent="submit">Submit</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import AuthService from '../services/AuthService';

export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (!value) {
        callback(new Error("Please enter new password"));
      } else if (value.toString().length < 6 || value.toString().length > 18) {
        callback(new Error("Password length should be between 6 and 18"));
      } else {
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("Please enter new password again"));
      } else if (value !== this.user.newpwd) {
        callback(new Error("The password you entered is not matching!"));
      } else {
        callback();
      }
    };
    return {
      user: {
      
        newpassword1: "",
        password: "",
        username: ""
      },
      resetFormRules: {
         password: [
            { required: true, message: "please enter current password", trigger: 'blur' }
        ],  
        newpwd: [
            { required: true, validator: validatePass, trigger: 'blur' }
        ],
        newpassword1: [
          { required: true, validator: validatePass2, trigger: "blur" }
        ]
      }
    };
  },
  methods: {
      submit() {
          this.$refs['resetForm'].validate((valid) => {
              if(valid) {
                  AuthService.updateUserPwd(this.user)
                  .then((response) => {
                      if(response.status===200) {
                          this.$router.push({name: "login"});
                      }
                  }

                  )
              }
          }
              
          )
      }
  }
}
</script>

<style scoped>
.el-form {
  
  width: 60%;
  margin: 50px auto 0;
  text-align: center; 
 
}
.stylebutton {
   width: 100px;
  height: 30px;
  background-color: transparent;
}

</style>