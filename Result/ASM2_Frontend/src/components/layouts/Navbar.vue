<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import logoImage from '@/assets/images/logo.png'

const searchQuery = ref('')
const router = useRouter()

function onSearch() {
  router.push({ path: '/search', query: { q: searchQuery.value } })
}

function goHome() {
  router.push('/').then(() => {
    window.scrollTo({ top: 0, behavior: 'smooth' }) // scroll to top
  })
}
</script>

<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div class="container-fluid d-flex align-items-center">
      <!-- Logo -->
      <div class="navbar-brand flex-shrink-0">
        <img :src="logoImage" alt="" style="width: 50px" @click="goHome" />
      </div>

      <!-- Search -->
      <form class="d-flex flex-grow-1 mx-3" @submit.prevent="onSearch">
        <input
          class="form-control me-2"
          type="search"
          v-model="searchQuery"
          placeholder="Tìm kiếm"
          aria-label="Search"
        />
        <button class="btn btn-outline-secondary" type="submit">
          <i class="bi bi-search"></i>
        </button>
      </form>

      <!-- Burger button -->
      <button
        class="navbar-toggler flex-shrink-0"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- Navbar content -->
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <!-- Giỏ hàng -->
          <li class="nav-item">
            <router-link class="nav-link d-flex align-items-center" to="/cart">
              <i class="bi bi-cart me-2" style="font-size: 20px"></i>
              Giỏ hàng
            </router-link>
          </li>
          <!-- Account dropdown/collapse -->
          <li class="nav-item dropdown">
            <!-- Desktop dropdown -->
            <a
              class="nav-link dropdown-toggle d-flex align-items-center d-none d-lg-flex"
              href="#"
              id="userDropdown"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              <i class="bi bi-person-circle me-2" style="font-size: 20px"></i>
              Tài khoản
            </a>
            <ul class="dropdown-menu" aria-labelledby="userDropdown">
              <li>
                <router-link class="dropdown-item" to="/login">Đăng nhập</router-link>
              </li>
              <li>
                <router-link class="dropdown-item" to="/logout">Đăng xuất</router-link>
              </li>
              <li>
                <router-link class="dropdown-item" to="/forgot-password">Quên mật khẩu</router-link>
              </li>
              <li>
                <router-link class="dropdown-item" to="/register">Đăng ký thành viên</router-link>
              </li>
              <li>
                <router-link class="dropdown-item" to="/api/user">Quản lý tài khoản</router-link>
              </li>
            </ul>

            <!-- Mobile collapse -->
            <a
              class="nav-link d-flex align-items-center d-lg-none"
              href="#userOptions"
              data-bs-toggle="collapse"
              aria-expanded="false"
              aria-controls="userOptions"
            >
              <i class="bi bi-person-circle me-2" style="font-size: 20px"></i>
              Tài khoản
            </a>
          </li>
        </ul>

        <div class="collapse d-lg-none" id="userOptions">
          <ul class="navbar-nav">
            <li class="nav-item">
              <router-link class="nav-link ps-4" to="/login">Đăng nhập</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link ps-4" to="/logout">Đăng xuất</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link ps-4" to="/forgot-password">Quên mật khẩu</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link ps-4" to="/register">Đăng ký thành viên</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link ps-4" to="/api/user">Quản lý tài khoản</router-link>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </nav>
</template>
