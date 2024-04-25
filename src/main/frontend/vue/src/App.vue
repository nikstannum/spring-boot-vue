<script setup></script>

<template>
  <header>
    <div class="wrapper">
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/messages">History</RouterLink>
      </nav>
    </div>
  </header>

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
