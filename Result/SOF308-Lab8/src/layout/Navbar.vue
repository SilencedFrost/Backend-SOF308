<script>
export default {
  name: 'Navbar',
  data() {
    return {
      navLinks: [
        { label: 'Home', path: '/' },
        { label: 'Blog List', path: '/blog/list' },
        { label: 'Blog Post 1', path: '/blog/post/1' },
        { label: 'Blog Post 2', path: '/blog/post/2' },
        { label: 'Blog Post 3', path: '/blog/post/3' },
        { label: 'Profile', path: '/profile' },
        { label: 'Profile (/me)', path: '/me' },
        { label: 'Login', path: '/login' },
        { label: 'Dashboard', path: '/dashboard' },
      ],
    }
  },
  methods: {
    goTo(path) {
      this.$router.push(path)
    },
  },
}
</script>

<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <!-- Brand -->
      <a class="navbar-brand" href="javascript:void(0)" @click="goTo('/')"> MyApp </a>

      <!-- Mobile toggle button -->
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- Links -->
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li v-for="(item, index) in navLinks" :key="index" class="nav-item">
            <a href="javascript:void(0)" class="nav-link" @click="goTo(item.path)">
              {{ item.label }}
            </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>
