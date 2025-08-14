<template>
  <div class="container py-4">
    <!-- Header
    <div class="d-flex justify-content-between align-items-center border-bottom mb-4">
      <h3 class="text-warning fw-bold">FPT POLYTECHNIC</h3>
      <h4>LAB 7</h4>
    </div> -->

    <div class="row">
      <!-- Form đăng ký -->
      <div class="col-md-6">
        <h4 class="mb-3">Form Đăng Ký</h4>
        <form @submit.prevent="register">
          <div class="mb-3">
            <label class="form-label">Họ tên:</label>
            <input v-model="user.hoTen" type="text" class="form-control" />
          </div>
          <div class="mb-3">
            <label class="form-label">Email:</label>
            <input v-model="user.email" type="email" class="form-control" />
          </div>
          <div class="mb-3">
            <label class="form-label">Mật khẩu:</label>
            <input v-model="user.matKhau" type="password" class="form-control" />
          </div>
          <div class="mb-3">
            <label class="form-label">Ngày sinh:</label>
            <input v-model="user.ngaySinh" type="date" class="form-control" />
          </div>
          <div class="mb-3">
            <label class="form-label">Giới tính:</label><br />
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" value="Nam" v-model="user.gioiTinh" />
              <label class="form-check-label">Nam</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" value="Nữ" v-model="user.gioiTinh" />
              <label class="form-check-label">Nữ</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" value="Khác" v-model="user.gioiTinh" />
              <label class="form-check-label">Khác</label>
            </div>
          </div>
          <div class="mb-3">
            <label class="form-label">Ngôn ngữ:</label><br />
            <div class="form-check form-check-inline" v-for="lang in allLanguages" :key="lang">
              <input
                class="form-check-input"
                type="checkbox"
                :value="lang"
                v-model="user.ngonNgu"
              />
              <label class="form-check-label">{{ lang }}</label>
            </div>
          </div>
          <button type="submit" class="btn btn-primary">Đăng ký</button>
        </form>
      </div>

      <!-- Thông tin đã đăng ký -->
      <div class="col-md-6" v-if="submitted">
        <h4>Thông tin đã đăng ký:</h4>
        <p><strong>Họ tên:</strong> {{ submitted.hoTen }}</p>
        <p><strong>Email:</strong> {{ submitted.email }}</p>
        <p><strong>Ngày sinh:</strong> {{ submitted.ngaySinh }}</p>
        <p><strong>Giới tính:</strong> {{ submitted.gioiTinh }}</p>
        <p><strong>Ngôn ngữ:</strong> {{ submitted.ngonNgu.join(', ') }}</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue';

const user = reactive({
  hoTen: '',
  email: '',
  matKhau: '',
  ngaySinh: '',
  gioiTinh: 'Nam',
  ngonNgu: []
});

const submitted = ref(null);

const allLanguages = ['Tiếng Việt', 'Tiếng Anh', 'Tiếng Nhật'];

const register = () => {
  submitted.value = { ...user };
  delete submitted.value.matKhau;

  // Reset form
  user.hoTen = '';
  user.email = '';
  user.matKhau = '';
  user.ngaySinh = '';
  user.gioiTinh = 'Nam';
  user.ngonNgu = [];
};
</script>

