<script setup>
import PopUpDialog from './components/PopUpDialog.vue'
import { ref } from 'vue'

const dialog = ref(false)

function openDialog() {
  dialog.value = !dialog.value
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
<!--  <button @click="openDialog">Открыть диалог</button>-->
  <PopUpDialog :show="dialog"></PopUpDialog>
  <RouterView />
  <!--  <button id="app__button__dialog" @click="router.push('/dialog')">Dialog</button>-->
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
