<template>
  <div>
      <h1>Test Typing
      </h1>
  </div>
</template>

<script>
import volunteerService from '@/services/VolunteerService.js';
export default {
    name: 'volunteers',
    components: {
    },
    data() {
        return {
            volunteers: []
        }
    },
    created() {
        volunteerService.findAllVolunteers().then(
            (response) => {
                let list = response.data;
                this.$store.commit("ADD_VOLUNTEERS", list);
            }
        )
    }

}
</script>

<style>

</style>