<template>
  <div>
    <!-- Toggle Button for Mobile -->
    <button 
      class="btn btn-primary sidebar-toggle d-lg-none" 
      type="button" 
      @click="toggleSidebar"
      :class="{ 'active': isOpen }"
    >
      ☰
    </button>

    <!-- Overlay for mobile -->
    <div 
      class="sidebar-overlay d-lg-none" 
      :class="{ 'show': isOpen }" 
      @click="closeSidebar"
    ></div>

    <!-- Sidebar -->
    <div class="sidebar" :class="{ 'show': isOpen }">
      <div class="sidebar-header">
        <h5 class="sidebar-title">Danh mục sản phẩm</h5>
        <button 
          class="btn-close d-lg-none" 
          @click="closeSidebar"
          aria-label="Đóng"
        ></button>
      </div>

      <div class="sidebar-content">
        <!-- Product Categories -->
        <ul class="category-list">
          <li class="category-item">
            <a href="#" class="category-link" @click.prevent="filterProducts('dien-thoai')">
              <div class="category-icon">📱</div>
              <span class="category-name">Điện thoại</span>
              <div class="category-arrow">›</div>
            </a>
          </li>
          <li class="category-item">
            <a href="#" class="category-link" @click.prevent="filterProducts('laptop')">
              <div class="category-icon">💻</div>
              <span class="category-name">Laptop</span>
              <div class="category-arrow">›</div>
            </a>
          </li>
          <li class="category-item">
            <a href="#" class="category-link" @click.prevent="filterProducts('pc')">
              <div class="category-icon">🖥️</div>
              <span class="category-name">PC</span>
              <div class="category-arrow">›</div>
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

<style scoped>
/* Toggle Button */
.sidebar-toggle {
  position: fixed;
  top: 20px;
  left: 20px;
  z-index: 1050;
  border-radius: 8px;
  width: 45px;
  height: 45px;
  display: flex;
  align-items: center;
  justify-content: center;
  box-shadow: 0 2px 10px rgba(0,0,0,0.1);
  transition: all 0.3s ease;
  font-size: 18px;
}

.sidebar-toggle:hover {
  transform: scale(1.05);
}

.sidebar-toggle.active {
  background-color: #dc3545;
  border-color: #dc3545;
}

/* Overlay */
.sidebar-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 1040;
  opacity: 0;
  visibility: hidden;
  transition: all 0.3s ease;
}

.sidebar-overlay.show {
  opacity: 1;
  visibility: visible;
}

/* Sidebar */
.sidebar {
  position: fixed;
  top: 0;
  left: -280px;
  width: 280px;
  height: 100vh;
  background-color: #fff;
  box-shadow: 2px 0 10px rgba(0,0,0,0.1);
  z-index: 1045;
  transition: left 0.3s ease;
  overflow-y: auto;
}

.sidebar.show {
  left: 0;
}

/* Desktop sidebar - always visible */
@media (min-width: 992px) {
  .sidebar {
    position: relative;
    left: 0;
    height: auto;
    box-shadow: none;
    border-right: 1px solid #e0e0e0;
  }
  
  .sidebar-toggle {
    display: none !important;
  }
  
  .sidebar-overlay {
    display: none !important;
  }
}

/* Sidebar Header */
.sidebar-header {
  padding: 1rem;
  border-bottom: 1px solid #e0e0e0;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #f8f9fa;
}

.sidebar-title {
  margin: 0;
  color: #333;
  font-weight: 600;
  font-size: 1.1rem;
}

/* Sidebar Content */
.sidebar-content {
  padding: 0;
}

/* Category List */
.category-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.category-item {
  border-bottom: 1px solid #f0f0f0;
}

.category-item:last-child {
  border-bottom: none;
}

.category-link {
  display: flex;
  align-items: center;
  padding: 1rem;
  color: #333;
  text-decoration: none;
  transition: all 0.2s ease;
  background-color: #fff;
}

.category-link:hover {
  background-color: #f8f9fa;
  color: #0d6efd;
  text-decoration: none;
}

.category-icon {
  width: 24px;
  height: 24px;
  margin-right: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 18px;
}

.category-name {
  flex: 1;
  font-weight: 500;
  font-size: 1rem;
}

.category-arrow {
  font-size: 18px;
  color: #999;
  transition: transform 0.2s ease;
}

.category-link:hover .category-arrow {
  transform: translateX(3px);
  color: #0d6efd;
}

/* Scrollbar styling */
.sidebar::-webkit-scrollbar {
  width: 6px;
}

.sidebar::-webkit-scrollbar-track {
  background: #f1f1f1;
}

.sidebar::-webkit-scrollbar-thumb {
  background: #c1c1c1;
  border-radius: 3px;
}

.sidebar::-webkit-scrollbar-thumb:hover {
  background: #a1a1a1;
}

/* Animation for hover effects */
.category-link {
  position: relative;
}

.category-link::before {
  content: '';
  position: absolute;
  left: 0;
  top: 0;
  bottom: 0;
  width: 3px;
  background-color: #0d6efd;
  transform: scaleY(0);
  transition: transform 0.2s ease;
}

.category-link:hover::before {
  transform: scaleY(1);
}
</style>