<script xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
import DataTable from 'primevue/datatable'
import Column from 'primevue/column'
import axios from 'axios'
import ColumnGroup from 'primevue/columngroup'
import Row from 'primevue/row'

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
      axios.get('/api/messages')
        .then(response => {
          this.messages = response.data
        })
    },
    handleDoubleClick(id) {
      this.$router.push({ path: `/findById/${id}` })
    }
  },
  mounted() {
    this.fetchData()
  }
}
</script>

Copy
<template>
  <div class="card">
    <DataTable :value="messages" showGridlines>
      <Column field="id" header="ID" :body-style="{'cursor': 'pointer', 'color': 'blue'}">
        <template #body="slot">
          <span @dblclick="handleDoubleClick(slot.data.id)">{{ slot.data.id }}</span>
        </template>
      </Column>
      <Column field="message" sortable header="Text"></Column>
    </DataTable>
  </div>
</template>

<style scoped>
.card {
  margin-left: 40%;
}
</style>