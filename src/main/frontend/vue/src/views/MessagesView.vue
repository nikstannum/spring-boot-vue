<script>
import { onMounted, ref } from 'vue'
import DataTable from 'primevue/datatable'
import Column from 'primevue/column'
import axios from 'axios'
import router from '@/router/index.js'

export default {
  components: {
    DataTable,
    Column
  },
  setup() {
    const messages = ref([])

    const fetchData = () => {
      // axios.get('/api/messages')
      //   .then(response => {
      //     messages.value = response.data
      //   })
    }

    const handleDoubleClick = (id) => {
      router.push({ path: `/findById/${id}` })
      // useRouter().push({ path: `/findById/${id}` })
    }

    onMounted(() => {
      fetchData()
    })

    return {
      messages,
      handleDoubleClick
    }
  }
}

</script>

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