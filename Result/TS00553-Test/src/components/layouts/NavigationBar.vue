<script setup>
import { useAuthStore } from '@/stores/authStore'
import { useRouter } from 'vue-router'

const router = useRouter()

const authStore = useAuthStore()
</script>

<template>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark border-bottom">
    <div class="container-fluid d-flex align-items-center">
      <router-link class="navbar-brand d-flex align-items-center" to="/">
        Quản lý công việc
      </router-link>
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
            <router-link class="nav-link d-flex align-items-center" to="/"> Danh sách </router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link d-flex align-items-center" to="/edit">
              Thêm công việc
            </router-link>
          </li>
          <li v-if="authStore.isLoggedIn" class="nav-item">
            <div class="nav-link d-flex align-items-center" to="/login">
              Welcome {{ authStore.username }}
            </div>
          </li>
          <div v-if="authStore.isLoggedIn">
            <li class="nav-item">
              <div class="nav-link d-flex align-items-center" @click="authStore.logOut(router)">
                Đăng xuất
              </div>
            </li>
          </div>
          <div v-else>
            <li class="nav-item">
              <router-link class="nav-link d-flex align-items-center" to="/login">
                Đăng nhập
              </router-link>
            </li>
          </div>
        </ul>
      </div>
    </div>
  </nav>
</template>
