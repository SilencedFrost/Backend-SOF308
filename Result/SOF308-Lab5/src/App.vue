<script setup>
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import Bai1 from './components/Bai1.vue';
import Bai2 from './components/Bai2.vue';
import Bai3 from './components/Bai3.vue';
import Bai4 from './components/CreatePost.vue';
import { ref } from 'vue';
import CreatePost from './components/CreatePost.vue';
import PostList from './components/PostList.vue';
import them from'./components/them.vue';
import p24 from './components/p24.vue';
import p29 from './components/p29.vue';
import p33 from './components/p33.vue';
import baithem from './components/baithem.vue';
const posts = ref([])

function addPost(post) {
  posts.value.push(post)
}
</script>
<template>
<Bai1/>
 <Bai2/>
 <Bai3/> 
 <them/>
 <p24/>
 <p29/>
 <p33/>
    <baithem/>
  <div id="app">
    <h1>Blog với Vue.js</h1>
    <CreatePost @add-post="addPost" />
    <PostList :posts="posts" />
  </div>
</template>

<style>
 #app {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}
</style>
