<script setup>
import { ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { useAuthStore } from '@/stores/authStore'
import googleAuthService from '@/services/googleAuthService'

const authStore = useAuthStore()
const router = useRouter()
const route = useRoute()

const username = ref('')
const password = ref('')
const errorMessage = ref('')

function validateUsernameOrEmail() {
  return username.value != null && username.value.trim() !== ''
}
function validatePassword() {
  return password.value != null && password.value.trim() !== ''
}

function redirectAfterLogin() {
  const redirectPath = route.query.redirect || '/'
  router.push(redirectPath)
}

async function onLogin() {
  errorMessage.value = ''
  if (!validateUsernameOrEmail() || !validatePassword()) {
    errorMessage.value = 'Please enter both username/email and password.'
    return
  }

  try {
    authStore.setLoading(true)
    await authStore.login(username.value, password.value)
    redirectAfterLogin()
  } catch {
    errorMessage.value = 'Invalid credentials. Please try again.'
  } finally {
    authStore.setLoading(false)
  }
}
</script>

<template>
  <div class="container d-flex justify-content-center align-items-center h-100">
    <div class="card shadow-sm p-3" style="max-width: 400px; width: 100%">
      <h2 class="mb-3 text-center text-primary">Đăng nhập</h2>
      <hr class="p-0 m-2" />

      <div v-if="errorMessage" class="alert alert-danger py-2">{{ errorMessage }}</div>

      <!-- Mock login form -->
      <form @submit.prevent="onLogin">
        <div class="mb-3">
          <label for="username" class="form-label">Tên đăng nhập hoặc email</label>
          <input
            type="text"
            id="username"
            v-model="username"
            class="form-control"
            required
            autocomplete="username"
            placeholder="Username or email"
            :disabled="authStore.isLoading"
          />
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Mật khẩu</label>
          <input
            type="password"
            id="password"
            v-model="password"
            class="form-control"
            required
            autocomplete="current-password"
            placeholder="Password"
            :disabled="authStore.isLoading"
          />
        </div>
        <button type="submit" class="btn btn-primary w-100" :disabled="authStore.isLoading">
          <span
            v-if="authStore.isLoading"
            class="spinner-border spinner-border-sm me-2"
            role="status"
          ></span>
          {{ authStore.isLoading ? 'Đang đăng nhập...' : 'Đăng nhập' }}
        </button>
      </form>

      <!-- Google redirect login -->
      <a class="btn btn-danger w-100 mt-3" :href="googleAuthService.getAuthUrl()">
        <i class="fab fa-google me-2"></i> Đăng nhập bằng Google
      </a>
    </div>
  </div>
</template>
