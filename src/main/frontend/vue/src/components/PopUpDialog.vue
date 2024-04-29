<script setup>
import { ref } from 'vue'

const props = defineProps({
  show: {
    type: Boolean,
    default: false
  }
})
const visible = ref(false)
</script>

<template v-if="props.show">
  <div class="card flex justify-content-center">
    <Button label="Show" @click="visible = true" />
    <Dialog v-model:visible="visible" modal header="Edit Profile" :style="{
      width: '25rem'
    }">
      <span class="p-text-secondary block mb-5">Update your information.</span>
      <div class="flex justify-content-end gap-2">
        <Button type="button" label="Cancel" severity="secondary" @click="visible = false"></Button>
        <Button type="button" label="Save" @click="visible = false"></Button>
      </div>
    </Dialog>
  </div>
</template>