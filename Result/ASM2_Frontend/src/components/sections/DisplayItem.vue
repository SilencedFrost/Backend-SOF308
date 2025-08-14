<script setup>
import { useRouter } from 'vue-router'
import { defineProps, defineEmits } from 'vue'

const props = defineProps({
  product: {
    type: Object,
    required: true,
  },
})

function addToCart() {
  emits('add-to-cart', props.product)
}

const router = useRouter()

function viewProduct() {
  router.push(`/product/${props.product.productId}`)
}

function formatPrice(price) {
  return price?.toLocaleString('vi-VN') || '0'
}
</script>
<template>
  <div class="card h-100 shadow-sm">
    <div class="position-relative" @click="viewProduct()" style="cursor: pointer">
      <img :src="product.imageUrl" :alt="product.productName" class="card-img-top p-2" />
      <hr />
      {{ product.imageUrl }}
    </div>
    <div class="card-body d-flex flex-column">
      <h6 class="card-title fw-bold">{{ product.productName }}</h6>
      <div class="mb-3">
        <span class="h5 text-danger fw-bold">{{ formatPrice(product.price) }}$</span>
      </div>
      <div class="mt-auto">
        <button class="btn btn-success w-100" @click="addToCart()">
          <i class="bi bi-cart-plus me-1"></i>
          Thêm vào giỏ hàng
        </button>
      </div>
    </div>
  </div>
</template>
