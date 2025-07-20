<script>
import Navbar from './components/Navbar.vue'

export default {
  components: {
    Navbar
  }
}
</script>

<template>
    <Navbar />

  <main>
    <router-view />
  </main>
  
  <footer>

  </footer>
</template>
