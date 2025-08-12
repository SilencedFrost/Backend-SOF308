import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import App from './App.vue'

// Import Bootstrap
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'

//Router
import Home from '@/components/pages/Home.vue'
import Profile from '@/components/pages/Profile.vue'
import Cart from '@/components/pages/Cart.vue'
import ProductDetail from '@/components/pages/ProductDetail.vue'

const routes = [
    { path: '/', component: Home},
    { path: '/profile', component: Profile},
    { path: '/cart', component: Cart},
    { path: '/product/:id', component: ProductDetail}
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

createApp(App).use(router).mount('#app')