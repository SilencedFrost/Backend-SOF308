import { createRouter, createWebHistory } from 'vue-router'
import { useAuthStore } from '@/stores/authStore'

import TodoListPage from '@/components/pages/TodoListPage.vue'
import LoginPage from '@/components/pages/LoginPage.vue'
import EditTodoPage from '@/components/pages/EditTodoPage.vue'
import AuthCallback from '@/components/pages/AuthCallback.vue'

const routes = [
  { path: '/', component: TodoListPage, meta: { title: 'Todo list', requiresAuth: true } },
  { path: '/edit', component: EditTodoPage, meta: { title: 'Edit todo list', requiresAuth: true } },
  { path: '/auth/callback', component: AuthCallback, meta: { title: 'Auth callback' } },
  { path: '/login', component: LoginPage, meta: { title: 'Login' } },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

router.beforeEach((to, from, next) => {
  const authStore = useAuthStore()

  if (to.meta.requiresAuth && !authStore.isLoggedIn) {
    next({
      path: '/login',
      query: { redirect: to.fullPath },
    })
  } else {
    next()
  }
})

router.afterEach((to) => {
  if (to.meta.title) {
    document.title = to.meta.title
  }
})

export default router
