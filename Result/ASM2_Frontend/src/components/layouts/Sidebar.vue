<template>
  <div>
    <!-- Toggle Button for Mobile -->
    <button 
      class="btn d-lg-none position-fixed" 
      :class="isOpen ? 'btn-danger' : 'btn-primary'"
      type="button" 
      @click="toggleSidebar"
      style="top: 20px; left: 20px; z-index: 1050; width: 45px; height: 45px;"
    >
      <i class="fas fa-bars" v-if="!isOpen"></i>
      <i class="fas fa-times" v-else></i>
    </button>

    <!-- Overlay for mobile -->
    <div 
      class="d-lg-none position-fixed w-100 h-100" 
      @click="closeSidebar"
      :style="{
        top: 0, 
        left: 0, 
        background: 'rgba(0,0,0,0.6)', 
        zIndex: 1040, 
        opacity: isOpen ? 1 : 0, 
        visibility: isOpen ? 'visible' : 'hidden', 
        transition: 'all 0.3s ease'
      }"
    ></div>

    <!-- Sidebar -->
    <div 
      class="bg-white shadow-sm position-fixed position-lg-relative"
      :style="{
        top: '60px',
        left: isOpen ? '0' : '-280px',
        width: '280px',
        height: 'calc(100vh - 60px)',
        zIndex: 1045,
        transition: 'left 0.3s ease'
      }"
      style="left: 0 !important;"
    >
      <!-- Sidebar Header -->
      <div class="p-3 border-bottom bg-light">
        <div class="d-flex justify-content-between align-items-center">
          <h5 class="mb-0 fw-bold">Danh mục sản phẩm</h5>
          <button 
            class="btn-close d-lg-none" 
            @click="closeSidebar"
            aria-label="Đóng"
          ></button>
        </div>
      </div>

      <!-- Sidebar Content -->
      <div class="p-3">
        <!-- Product Categories -->
        <ul class="list-unstyled mb-0">
          <li class="mb-2">
            <a 
              href="#" 
              class="d-flex align-items-center p-2 text-decoration-none rounded text-dark"
              @click.prevent="filterProducts('dien-thoai')"
              @mouseover="$event.target.classList.add('bg-light', 'text-primary')"
              @mouseout="$event.target.classList.remove('bg-light', 'text-primary')"
            >
              <i class="fas fa-mobile-alt text-success me-3"></i>
              <span>Điện thoại</span>
            </a>
          </li>
          <li class="mb-2">
            <a 
              href="#" 
              class="d-flex align-items-center p-2 text-decoration-none rounded text-dark"
              @click.prevent="filterProducts('laptop')"
              @mouseover="$event.target.classList.add('bg-light', 'text-primary')"
              @mouseout="$event.target.classList.remove('bg-light', 'text-primary')"
            >
              <i class="fas fa-laptop text-primary me-3"></i>
              <span>Laptop</span>
            </a>
          </li>
          <li class="mb-2">
            <a 
              href="#" 
              class="d-flex align-items-center p-2 text-decoration-none rounded text-dark"
              @click.prevent="filterProducts('pc')"
              @mouseover="$event.target.classList.add('bg-light', 'text-primary')"
              @mouseout="$event.target.classList.remove('bg-light', 'text-primary')"
            >
              <i class="fas fa-desktop text-info me-3"></i>
              <span>PC</span>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Sidebar',
  data() {
    return {
      isOpen: false
    }
  },

  methods: {
    toggleSidebar() {
      this.isOpen = !this.isOpen;
      this.toggleBodyScroll();
    },
    closeSidebar() {
      this.isOpen = false;
      this.toggleBodyScroll();
    },
    toggleBodyScroll() {
      // Ngăn scroll body khi sidebar mở trên mobile
      if (window.innerWidth < 992) {
        document.body.style.overflow = this.isOpen ? 'hidden' : '';
      }
    },
    filterProducts(category) {
      // Emit event để parent component xử lý filter
      this.$emit('filter-products', category);
      this.closeSidebar();
    },
    handleResize() {
      // Đóng sidebar khi chuyển sang desktop
      if (window.innerWidth >= 992) {
        this.isOpen = false;
        document.body.style.overflow = '';
      }
    }
  },
  mounted() {
    // Lắng nghe resize event
    window.addEventListener('resize', this.handleResize);
  },
  beforeUnmount() {
    // Cleanup
    window.removeEventListener('resize', this.handleResize);
    document.body.style.overflow = '';
  }
}
</script>
