<script setup>
import { onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { useAuthStore } from '@/stores/authStore'
import googleAuthService from '@/services/googleAuthService'

const authStore = useAuthStore()
const router = useRouter()

onMounted(async () => {
  const success = await googleAuthService.handleRedirectCallback(authStore)
  if (success) {
    router.push('/')
  } else {
    router.push('/login')
  }
})
</script>

<template>
  <div class="text-center mt-5">Đang xác thực Google...</div>
</template>
