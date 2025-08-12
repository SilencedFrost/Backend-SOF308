import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import App from './App.vue'

// Import Bootstrap
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'

//Router
import Home from '@/components/pages/Home.vue'
import Post from '@/components/pages/Post.vue'
import PostDetail from '@/components/pages/PostDetail.vue'
import ProductDetail from '@/components/pages/ProductDetail.vue'

const routes = [
    { path: '/', component: Home },
    { path: '/post', component: Post },
    { path: '/post/detail', component: PostDetail },
    { path: '/ProductDetail', component: ProductDetail }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

createApp(App).use(router).mount('#app')