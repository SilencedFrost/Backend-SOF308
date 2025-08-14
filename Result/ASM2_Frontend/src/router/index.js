import { createRouter, createWebHistory } from 'vue-router'

import Home from '@/components/pages/Home.vue'
import Profile from '@/components/pages/Profile.vue'
import Cart from '@/components/pages/Cart.vue'
import ProductDetail from '@/components/pages/ProductDetail.vue'
import Login from '@/components/pages/Login.vue'

const routes = [
  { path: '/', component: Home },
  { path: '/profile', component: Profile },
  { path: '/cart', component: Cart },
  { path: '/product/:id', component: ProductDetail },
  { path: '/login', component: Login },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router
