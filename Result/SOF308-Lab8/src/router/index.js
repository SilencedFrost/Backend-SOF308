import { createRouter, createWebHistory } from 'vue-router'

import Home from '@/pages/Home.vue'
import BlogList from '@/pages/BlogList.vue'
import BlogPost from '@/pages/BlogPost.vue'
import UserProfile from '@/pages/UserProfile.vue'
import Login from '@/pages/Login.vue'
import Dashboard from '@/pages/Dashboard.vue'
import ProfileInfo from '@/pages/ProfileInfo.vue'
import ProfileSettings from '@/pages/ProfileSettings.vue'

let isAuthenticated = false

const routes = [
  { path: '/', component: Home },
  { path: '/blog/list', component: BlogList },
  { path: '/blog/post/:id', component: BlogPost },
  {
    path: '/profile',
    component: UserProfile,
    children: [
      { path: 'info', component: ProfileInfo },
      { path: 'settings', component: ProfileSettings },
    ],
    alias: '/me',
  },
  { path: '/login', component: Login },
  { path: '/dashboard', component: Dashboard, meta: { requiresAuth: true } },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth && !isAuthenticated) {
    next('/login')
  } else {
    next()
  }
})

export default router
