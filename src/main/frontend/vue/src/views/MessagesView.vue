<script>

import DataTable from 'primevue/datatable'
import Column from 'primevue/column'
import axios from 'axios'

export default {
  name: 'MessagesView',
  components: {
    DataTable,
    Column
  },
  data() {
    return {
      messages: []
    }
  },
  methods: {
    fetchData() {
      axios.get('messages')
        .then(response => {
          this.messages = response.data
        })
    }
  },
  mounted() {
    this.fetchData()
  },
  handleDoubleClick(id) {
    axios.get('messages/' + id)
    this.$router.push({ path: `/MessageById/${id}` })
  }
}


</script>

<template>
  <div class="card">
    <DataTable :value="messages">
      <Column field="id" header="ID" :body-style="{'cursor': 'pointer', 'color': 'blue'}" :body="row => row.id"
              @dblclick="handleDoubleClick(row.id)"></Column>
      <Column field="message" sortable header="Text"></Column>
    </DataTable>
  </div>
</template>


<style scoped>
.card {
  margin-left: 40%;
}
</style>