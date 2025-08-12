<script>
import Navbar from '@/components/layouts/Navbar.vue'
import Sidebar from '@/components/layouts/Sidebar.vue'
import Foot from '@/components/layouts/Footer.vue'

export default {
  components: {
    Navbar,
    Sidebar,
    Foot
  },
  data() {
    return {
      showSidebar: true // Có thể điều khiển việc hiển thị sidebar
    }
  },
  methods: {
    handleFilterProducts(category) {
      // Xử lý filter sản phẩm từ sidebar
      console.log('Filtering products by category:', category);
      // Có thể emit event hoặc sử dụng store để xử lý filter
      this.$router.push({ path: '/products', query: { category } });
    }
  }
}
</script>

<template>
  <div class="d-flex flex-column min-vh-100">
    <header>
      <Navbar />
    </header>
    
    <div class="d-flex flex-fill">
      <!-- Sidebar -->
      <aside v-if="showSidebar" class="sidebar-container d-none d-lg-block">
        <Sidebar @filter-products="handleFilterProducts" />
      </aside>
      
      <!-- Mobile Sidebar (always rendered for mobile toggle) -->
      <Sidebar 
        v-if="showSidebar" 
        @filter-products="handleFilterProducts" 
        class="d-lg-none"
      />
      
      <!-- Main Content -->
      <main class="flex-fill main-content">
        <router-view />
      </main>
    </div>
    
    <footer>
      <Foot />
    </footer>
  </div>
</template>

<style>
.sidebar-container {
  width: 300px;
  flex-shrink: 0;
}

.main-content {
  min-width: 0; /* Prevent flex item from overflowing */
  padding: 1rem;
}

/* Responsive adjustments */
@media (max-width: 991.98px) {
  .main-content {
    padding: 0.5rem;
  }
}
</style>
