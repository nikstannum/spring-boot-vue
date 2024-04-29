<script setup>
import { ref } from 'vue'
import Button from 'primevue/button';
import Dialog from 'primevue/dialog';

const props = defineProps({
  show: {
    type: Boolean,
    default: false
  },
   config: {
      type: Object,
      default: null
    },
})
const visible = ref(false)
</script>

<template>
  <div v-if="props.show" class="card flex justify-content-center">
    <Button label="Show" @click="visible = true" />
    <Dialog v-model:visible="visible" modal :header="config.type" :style="{
      width: '25rem'
    }">
      <span class="p-text-secondary block mb-5">{{ config.message }}</span>
      <div class="flex justify-content-end gap-2">
        <Button v-if="config.handleCancel" type="button" label="Cancel" severity="secondary" @click="config.handleCancel()"></Button>
        <Button v-if="config.handleNo" type="button" label="No" severity="secondary" @click="config.handleNo()"></Button>
        <Button v-if="config.handleYes" type="button" label="Yes" @click="config.handleYes()"></Button>
      </div>
    </Dialog>
  </div>
</template>