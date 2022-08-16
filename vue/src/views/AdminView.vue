<template>
<div>
 
    <approve-volunteers/>
  </div>
</template>

<script>
import ApproveVolunteers from '../components/ApproveVolunteers.vue';

export default {
  components: { ApproveVolunteers },
  data() {
    return {
      isReady: true,
      volunteers: {}
    }
  }
}


  

</script>

<style>

</style>