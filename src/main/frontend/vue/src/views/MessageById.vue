<script>

import axios from 'axios'

export default {
  name: 'MessageById',

  data() {
    return {
      data: null
    }
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
  },
  mounted() {
    const id = this.$route.params.id
    this.fetchData(id)
  },
}
</script>

<template>
  <div>
    <h2 v-if="data">Your message id={{data.id}}<br/>You wrote:{{data.message}}</h2>
    <h2 v-else>Loading...</h2>
  </div>
</template>

<style scoped>

</style>