<template>
  <h2>Danh sách sinh viên</h2>
  <table border="1" cellpadding="8" cellspacing="0">
    <thead>
      <tr>
        <th>STT</th>
        <th>Họ và Tên</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(st, index) in students" :key="index">
        <td>{{ index + 1 }}</td>
        <td>{{ st }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script setup>
import { ref } from 'vue';

const students = ref([
  'Hoàng Văn Nam',
  'Vũ Văn Tài',
  'Lê Đức Trí',
  'Lê Thị Hà'
]);
</script>


