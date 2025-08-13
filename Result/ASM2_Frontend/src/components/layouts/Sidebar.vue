<template>
  <div>
    <!-- Sidebar -->
    <div class="bg-white border-end" style="width: 300px; min-height: 250vh;">
      <!-- Sidebar Content -->
      <div class="p-0">
        <!-- Product Categories -->
        <ul class="list-unstyled mb-0">
          <!-- Điện thoại -->
          <li>
            <a 
              href="#" 
              class="d-flex align-items-center justify-content-between p-3 text-decoration-none text-dark border-start border-3 border-transparent"
              @click.prevent="filterProducts('dien-thoai')"
              @mouseover="$event.target.classList.remove('border-transparent'); $event.target.classList.add('border-primary')"
              @mouseout="$event.target.classList.remove('border-primary'); $event.target.classList.add('border-transparent')"
            >
              <div class="d-flex align-items-center">
                <i class="fas fa-mobile-alt text-primary me-3 fs-5"></i>
                <span class="fw-normal">Điện thoại</span>
              </div>
              <i class="fas fa-chevron-right text-muted small"></i>
            </a>
          </li>

          <!-- Laptop -->
          <li>
            <a 
              href="#" 
              class="d-flex align-items-center justify-content-between p-3 text-decoration-none text-dark border-start border-3 border-transparent"
              @click.prevent="filterProducts('laptop')"
              @mouseover="$event.target.classList.remove('border-transparent'); $event.target.classList.add('border-primary')"
              @mouseout="$event.target.classList.remove('border-primary'); $event.target.classList.add('border-transparent')"
            >
              <div class="d-flex align-items-center">
                <i class="fas fa-laptop text-success me-3 fs-5"></i>
                <span class="fw-normal">Laptop</span>
              </div>
              <i class="fas fa-chevron-right text-muted small"></i>
            </a>
          </li>

          <!-- PC -->
          <li>
            <a 
              href="#" 
              class="d-flex align-items-center justify-content-between p-3 text-decoration-none text-dark border-start border-3 border-transparent"
              @click.prevent="filterProducts('pc')"
              @mouseover="$event.target.classList.remove('border-transparent'); $event.target.classList.add('border-primary')"
              @mouseout="$event.target.classList.remove('border-primary'); $event.target.classList.add('border-transparent')"
            >
              <div class="d-flex align-items-center">
                <i class="fas fa-desktop text-info me-3 fs-5"></i>
                <span class="fw-normal">PC</span>
              </div>
              <i class="fas fa-chevron-right text-muted small"></i>
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
  methods: {
    filterProducts(category) {
      this.$emit('filter-products', category);
    }
  }
}
</script>
