<script setup>
import { ref } from 'vue'
import { useRoute } from 'vue-router' // 👈 import vue-router hook

// Lấy ID sản phẩm từ URL
const route = useRoute()
const productId = route.params.id

const product = ref({
  name: "APPLE IPAD 4 WIFI 16GB",
  rating: 4,
  reviews: 999,
  cpu: "Dual-core Cortex-A9 1GHz",
  chip: "Apple A6X",
  ram: "1GB",
  kichthuoc: "9.7 inch",
  quatangkem: "Bút Apple Pencil",
  oldPrice: 11900000,
  price: 11800000,
  sizes: ["S", "M", "L", "XL"],
  colors: ["orange", "blue", "green"],
  images: [
    "https://www.duchuymobile.com/images/detailed/17/mo-hop-ipad-4_7p4b-i3.jpg",
    "https://www.duchuymobile.com/images/detailed/17/man-hinh-ipad-4_d4ox-uy.jpg",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLzwMJ_Ogw4jDwgY1pM3MdUZg7a3Z-DpOlPtqZpZi1GUSDvvpl1ph4xW6NFzO4kFw92ys&usqp=CAU",
    "https://www.jaknovy.cz/9107-medium_default/apple-ipad-4-wifi-16gb-a-used-12-months-warranty.jpg",
    "https://cdn2.fptshop.com.vn/unsafe/1920x0/filters:format(webp):quality(75)/2014_5_24_201405240755115846_apple-ipad-mini-wi-fi-and-cellular-16gb-extralarge.jpg"
  ],
  specs: [
    "Màn hình: 9.7 inch Retina",
    "CPU: Dual-core 1GHz",
    "RAM: 1GB",
    "Bộ nhớ: 16GB",
    "Chip: Apple A6X"
  ],
  description:
    "Apple iPad 4 với thiết kế sang trọng, hiệu năng ổn định, phù hợp cho học tập và giải trí giá cả rất hợp với túi tiền của mọi người ngại gì không rước em nó về ngay kẻo hết."
})

const selectedSize = ref(null)
const selectedColor = ref(null)
const quantity = ref(1)

const relatedProducts = ref([
  {
    name: "iPad Mini",
    image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdyS9F7cKkQyeX5j6KRJz2ca0sy0oYqwN1eQ&s",
    price: "8.000.000 VNĐ",
    rating: 4.5,
    likes: 120,
  },
  {
    name: "iPad Air",
    image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUPWLDInX1gQaig1pjcxKGggVD0e33xZvDzg&s",
    price: "10.000.000 VNĐ",
    rating: 4.5,
    likes: 120,
  },
  {
    name: "iPad Pro",
    image: "https://traidepbaniphone.com/thumbs/760x540x2/upload/product/ipadpro11-inwi-fispacegray2-upscreenusen-1035.png",
    price: "15.000.000 VNĐ",
    rating: 4.5,
    likes: 120,
  },
  {
    name: "iPad Gen 9",
    image: "https://macvn.com.vn/wp-content/uploads/2024/12/ipad-gen-9.jpg",
    price: "7.000.000 VNĐ",
    rating: 4.5,
    likes: 120,
  }
])

const comments = ref([
  { user: "Nguyễn Văn A", text: "Sản phẩm rất tốt!", rating: 5 },
  { user: "Trần Thị B", text: "Giá hơi cao nhưng chất lượng tuyệt vời.", rating: 4 },
  { user: "Nguyễn Thị M", text: "Sản phẩm chạy ngon", rating: 5 },
  { user: "Cao Văn H", text: "Giá rất phải chăng", rating: 5 },
  { user: "Hứa Văn M", text: "Sản phẩm rất vừa ý", rating: 5 },
  { user: "Nguyễn Viết T", text: "Sản phẩm đẹp nhưng chạy chưa được mượt.", rating: 4 }
])

const newComment = ref("")
const newRating = ref(0)

// Methods
function formatPrice(value) {
  return value.toLocaleString("vi-VN") + " VNĐ"
}

function addToCart() {
  alert(`Đã thêm ${quantity.value} sản phẩm vào giỏ hàng!`)
}

function buyNow() {
  alert("Mua ngay sản phẩm!")
}

function postComment() {
  if (newComment.value.trim() !== "" && newRating.value > 0) {
    comments.value.push({ user: "Khách", text: newComment.value, rating: newRating.value })
    newComment.value = ""
    newRating.value = 0
  } else {
    alert("Vui lòng nhập bình luận và chọn số sao!")
  }
}
</script>

<template>
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
                style="width: 2000px; height: 500px; object-fit: cover; margin: auto;" 
              />
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#productCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#productCarousel" data-bs-slide="next">
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
            style="width: 200px; height: 200px; object-fit: cover;"
          />
          <h6>{{ item.name }}</h6>
          <div>
            <span v-for="n in 5" :key="n" style="color: gold;">
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
            style="cursor: pointer; font-size: 1.2rem;"
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
</template>