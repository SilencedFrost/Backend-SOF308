<script setup>
import { RouterView } from 'vue-router'
import NavigationBar from '@/components/layouts/NavigationBar.vue'
</script>

<template>
  <div class="d-flex flex-column vh-100">
    <nav class="sticky-top flex-shrink-0">
      <navigation-bar />
    </nav>
    <main class="flex-grow-1 overflow-hidden bg-light">
      <router-view />
    </main>
    <footer class="flex-shrink-0"></footer>
  </div>
</template>

<style scoped></style>
