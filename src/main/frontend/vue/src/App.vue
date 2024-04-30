<script setup>
import PopUpDialog from './components/PopUpDialog.vue'
import { ref } from 'vue'


const dialog = ref(false)
const config = ref(null)


function openDialog(type, message, handleYes, handleNo, handleCancel) {
  config.value = {
    type: type,
    message: message,
    handleYes: handleYes,
    handleNo: handleNo,
    handleCancel: handleCancel
  }
  dialog.value = true
}

</script>

<template>
  <header>
    <div class="wrapper">
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/messages">History</RouterLink>
      </nav>
    </div>
  </header>
  <button
  @click="openDialog('Some header', 'Are you sure?',
  () => console.log('pressed YES'),
  () => console.log('pressed NO'),
  () => console.log('pressed CANCEL'))">Открыть диалог</button>
  <PopUpDialog :show="dialog" :config="config"></PopUpDialog>
  <RouterView />
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 10vh;
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  padding: 10px;
}
</style>
