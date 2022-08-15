import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },
  updateUserPwd(user){
    return axios.post('/changePassword', user)
  }

}
