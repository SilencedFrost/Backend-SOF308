<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import Sidebar from '@/components/layouts/Sidebar.vue'
import Carousel from '@/components/sections/Carousel.vue'

const router = useRouter()

const featuredProducts = ref([
  {
    id: 1,
    name: 'iPhone 15 Pro Max',
    price: '29.990.000',
    originalPrice: '32.990.000',
    image: 'https://images.unsplash.com/photo-1592750475338-74b7b21085ab?w=300&h=300&fit=crop',
    rating: 4.8,
    discount: '9%',
  },
  {
    id: 2,
    name: 'Samsung Galaxy S24 Ultra',
    price: '26.990.000',
    originalPrice: '29.990.000',
    image: 'https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?w=300&h=300&fit=crop',
    rating: 4.7,
    discount: '10%',
  },
  {
    id: 3,
    name: 'MacBook Air M3',
    price: '28.990.000',
    originalPrice: '31.990.000',
    image: 'https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=300&h=300&fit=crop',
    rating: 4.9,
    discount: '9%',
  },
])

const categories = ref([
  {
    name: 'Điện thoại',
    icon: '📱',
    image: 'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=200&h=200&fit=crop',
    count: '500+',
  },
  {
    name: 'Laptop',
    icon: '💻',
    image: 'https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=200&h=200&fit=crop',
    count: '300+',
  },
  {
    name: 'PC',
    icon: '🖥️',
    image: 'https://images.unsplash.com/photo-1593640408182-31c70c8268f5?w=200&h=200&fit=crop',
    count: '200+',
  },
])

function formatPrice(price) {
  return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.')
}

function addToCart(product) {
  console.log('Added to cart:', product)
}

function viewProduct(productId) {
  router.push(`/product/${productId}`)
}

function viewCategory(categoryName) {
  router.push(`/category/${categoryName}`)
}
</script>

<template>
  <div class="row">
    <div class="col-md-3 d-none d-md-block p-0 border-end">
      <Sidebar />
    </div>
    <div class="col-md-9 col-12 container-fluid p-2">
      <carousel />
      <!-- Categories Section -->
      <section class="py-5">
        <div class="container">
          <div class="text-center mb-5">
            <h2 class="fw-bold">Danh mục sản phẩm</h2>
            <p class="text-muted">Khám phá các danh mục sản phẩm đa dạng</p>
          </div>
          <div class="row g-4 justify-content-center">
            <div
              class="col-lg-4 col-md-4 col-6"
              v-for="category in categories"
              :key="category.name"
            >
              <div
                class="text-center p-3 h-100 border rounded shadow-sm"
                @mouseover="$event.currentTarget.classList.add('shadow-lg')"
                @mouseout="$event.currentTarget.classList.remove('shadow-lg')"
                @click="viewCategory(category.name)"
                style="cursor: pointer"
              >
                <div class="mb-3">
                  <img
                    :src="category.image"
                    :alt="category.name"
                    class="img-fluid rounded-circle"
                    style="width: 80px; height: 80px; object-fit: cover"
                  />
                </div>
                <h6 class="fw-bold mb-1">{{ category.name }}</h6>
                <small class="text-muted">{{ category.count }} sản phẩm</small>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- Featured Products Section -->
      <section class="py-5 bg-white">
        <div class="container">
          <div class="text-center mb-5">
            <h2 class="fw-bold">Sản phẩm nổi bật</h2>
            <p class="text-muted">Những sản phẩm bán chạy nhất hiện tại</p>
          </div>
          <div class="row g-4 justify-content-center">
            <div
              class="col-lg-4 col-md-6 col-sm-12"
              v-for="product in featuredProducts"
              :key="product.id"
            >
              <div
                class="card h-100 shadow-sm"
                @mouseover="$event.currentTarget.classList.add('shadow-lg')"
                @mouseout="$event.currentTarget.classList.remove('shadow-lg')"
              >
                <div
                  class="position-relative"
                  @click="viewProduct(product.id)"
                  style="cursor: pointer"
                >
                  <img
                    :src="product.image"
                    :alt="product.name"
                    class="card-img-top"
                    style="height: 250px; object-fit: cover"
                  />
                  <span class="badge bg-danger position-absolute top-0 start-0 m-2">
                    -{{ product.discount }}
                  </span>
                </div>
                <div class="card-body d-flex flex-column">
                  <h6 class="card-title fw-bold">{{ product.name }}</h6>
                  <div class="mb-2">
                    <span class="text-warning"> ★★★★★ </span>
                    <small class="text-muted ms-1">({{ product.rating }})</small>
                  </div>
                  <div class="mb-3">
                    <span class="h5 text-danger fw-bold">{{ formatPrice(product.price) }}₫</span>
                    <small class="text-muted text-decoration-line-through ms-2">
                      {{ formatPrice(product.originalPrice) }}₫
                    </small>
                  </div>
                  <div class="mt-auto">
                    <button class="btn btn-primary w-100" @click="addToCart(product)">
                      <i class="bi bi-cart-plus me-1"></i>
                      Thêm giỏ hàng
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="text-center mt-4">
            <button class="btn btn-outline-primary btn-lg">Xem tất cả sản phẩm</button>
          </div>
        </div>
      </section>
    </div>
  </div>
</template>
