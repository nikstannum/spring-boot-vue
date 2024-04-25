<script>

import axios from 'axios'

export default {
  name: 'MessagesById',

  data() {
    return {
      data: null
    }
  },
  mounted() {
    const id = this.$route.params.id
    this.fetchData(id)
  },
  methods: {
    fetchData(id) {
      axios.get(`/api/messages/${id}`)
        .then(response => {
          this.data = response.data
        })
        .catch(error => {
          console.error(error)
        })
    }
  }
}


</script>

<template>
</template>


<style scoped>

</style>