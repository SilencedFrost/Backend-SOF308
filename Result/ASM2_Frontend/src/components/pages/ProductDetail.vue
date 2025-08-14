<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import axios from 'axios'

// Lấy ID sản phẩm từ URL
const route = useRoute()
const productId = route.params.id

// Reactive state
const product = ref([])
const loading = ref(true)
const error = ref(null)

// Fetch
async function fetchCategories() {
  try {
    const response = await axios.get('http://localhost:8080/api/products/' + productId)
    product.value = response.data
  } catch (err) {
    error.value = 'Failed to load data'
  } finally {
    loading.value = false
  }
}

onMounted(fetchCategories)
</script>

<template>
  <div class="container-fluid p-2">
    <div v-if="loading" class="alert alert-info">Loading categories...</div>
    <div v-else-if="error" class="alert alert-danger">
      {{ error }}
    </div>
    <div v-else>{{ product.productId }}, {{ product.productName }}</div>
  </div>

  <div v-if="false">
    <div class="container py-4">
      <!-- Hiển thị productId -->
      <div class="mb-3">
        <h5>Product ID: {{ productId }}</h5>
      </div>
      <div class="row">
        <!-- Carousel hình ảnh -->
        <div class="col-md-6">
          <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
              <div
                v-for="(img, index) in product.images"
                :key="index"
                :class="['carousel-item', { active: index === 3 }]"
              >
                <img
                  :src="img"
                  class="d-block w-100"
                  :alt="'Hình ' + (index + 1)"
                  style="width: 2000px; height: 500px; object-fit: cover; margin: auto"
                />
              </div>
            </div>
            <button
              class="carousel-control-prev"
              type="button"
              data-bs-target="#productCarousel"
              data-bs-slide="prev"
            >
              <span class="carousel-control-prev-icon"></span>
            </button>
            <button
              class="carousel-control-next"
              type="button"
              data-bs-target="#productCarousel"
              data-bs-slide="next"
            >
              <span class="carousel-control-next-icon"></span>
            </button>
          </div>
        </div>
        <!-- Thông tin sản phẩm -->
        <div class="col-md-6">
          <h3>{{ product.name }}</h3>
          <div class="mb-2 text-warning">
            <span v-for="n in 5" :key="n">
              <span v-if="n <= product.rating">★</span>
              <span v-else>☆</span>
            </span>
            <small class="text-muted">({{ product.reviews }} reviews)</small>
          </div>
          <p><strong>CPU:</strong> {{ product.cpu }}</p>
          <p><strong>Chip:</strong> {{ product.chip }}</p>
          <p><strong>RAM:</strong> {{ product.ram }}</p>
          <p><strong>Kích thước:</strong> {{ product.kichthuoc }}</p>
          <p><strong>Quà tặng kèm:</strong> {{ product.quatangkem }}</p>
          <p class="text-decoration-line-through text-muted">
            Giá cũ: {{ formatPrice(product.oldPrice) }}
          </p>
          <h4 class="text-danger">Giá hiện tại: {{ formatPrice(product.price) }}</h4>
          <!-- Chọn màu -->
          <div class="mb-3">
            <strong>Màu:</strong>
            <button
              v-for="color in product.colors"
              :key="color"
              @click="selectedColor = color"
              :style="{ backgroundColor: color }"
              :class="['btn', 'btn-sm', selectedColor === color ? 'border border-dark' : '']"
            ></button>
          </div>
          <!-- Số lượng -->
          <div class="mb-3">
            <label class="form-label">Số lượng:</label>
            <input type="number" v-model.number="quantity" min="1" class="form-control w-25" />
          </div>
          <!-- Nút hành động -->
          <div class="d-flex gap-2">
            <button class="btn btn-outline-warning" @click="addToCart">Thêm vào giỏ hàng</button>
            <button class="btn btn-danger" @click="buyNow">Mua ngay</button>
          </div>
        </div>
      </div>
      <!-- Tabs thông tin -->
      <div class="mt-5">
        <ul class="nav nav-tabs">
          <li class="nav-item">
            <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#specs">
              Thông số kỹ thuật
            </button>
          </li>
          <li class="nav-item">
            <button class="nav-link" data-bs-toggle="tab" data-bs-target="#info">
              Thông tin sản phẩm
            </button>
          </li>
        </ul>
        <div class="tab-content p-3 border border-top-0">
          <div class="tab-pane fade show active" id="specs">
            <ul>
              <li v-for="spec in product.specs" :key="spec">{{ spec }}</li>
            </ul>
          </div>
          <div class="tab-pane fade" id="info">
            <p>{{ product.description }}</p>
          </div>
        </div>
      </div>
      <!-- Sản phẩm liên quan -->
      <div class="mt-5">
        <h4>Sản phẩm liên quan</h4>
        <div class="row">
          <div v-for="(item, index) in relatedProducts" :key="index" class="col-md-3 text-center">
            <img
              :src="item.image"
              :alt="item.name"
              class="img-fluid border mb-2"
              style="width: 200px; height: 200px; object-fit: cover"
            />
            <h6>{{ item.name }}</h6>
            <div>
              <span v-for="n in 5" :key="n" style="color: gold">
                {{ n <= Math.round(item.rating) ? '★' : '☆' }}
              </span>
              <small>({{ item.rating }})</small>
            </div>
            <div>❤️ {{ item.likes }} lượt thích</div>
            <div class="text-danger fw-bold">{{ item.price }}</div>
          </div>
        </div>
      </div>
      <!-- Bình luận -->
      <div class="mt-5">
        <h4>Bình luận</h4>
        <div class="mb-3">
          <textarea
            v-model="newComment"
            class="form-control"
            placeholder="Viết bình luận..."
            rows="3"
          ></textarea>
        </div>
        <div class="mb-3">
          <label class="form-label">Đánh giá:</label>
          <div>
            <span
              v-for="n in 5"
              :key="n"
              @click="newRating = n"
              style="cursor: pointer; font-size: 1.2rem"
            >
              {{ n <= newRating ? '★' : '☆' }}
            </span>
          </div>
        </div>
        <button class="btn btn-primary mb-4" @click="postComment">Gửi</button>
        <div v-for="(cmt, index) in comments" :key="index" class="border p-2 mb-2">
          <strong>{{ cmt.user }}</strong>
          <span class="text-warning">
            <span v-for="n in 5" :key="n">
              {{ n <= cmt.rating ? '★' : '☆' }}
            </span>
          </span>
          <br />
          {{ cmt.text }}
        </div>
      </div>
    </div>
  </div>
</template>
