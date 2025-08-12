<template>
  <div>
    <h3>Nhập điểm của bạn:</h3>
    <input type="number" v-model.number="score" min="0" max="10" />

    <p v-if="score < 5.0">Yếu</p>
    <p v-else-if="score >= 5.0 && score < 6.5">Trung bình</p>
    <p v-else-if="score >= 6.5 && score < 8.0">Khá</p>
    <p v-else-if="score >= 8.0 && score < 9.0">Giỏi</p>
    <p v-else-if="score >= 9.0">Xuất sắc</p>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const score = ref(0);
</script>
