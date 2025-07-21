<script>
import Navbar from '@/components/layouts/Navbar.vue'
import Foot from '@/components/layouts/Footer.vue'

export default {
  components: {
    Navbar,
    Foot
  }
}
</script>

<template>
  <div class="d-flex flex-column min-vh-100">
    <header>
      <Navbar />
    </header>
    
    <main class="flex-fill">
      <router-view />
    </main>
    
    <footer>
      <Foot />
    </footer>
  </div>
</template>
