<script setup>
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import Bai1 from './components/Bai1.vue';
import Bai2 from './components/Bai2.vue';
import Bai3 from './components/Bai3.vue';
import { ref } from 'vue';
import LoginComponent from './components/LoginComponent.vue';
import CommentComponent from './components/CommentComponent.vue';

const isLoggedIn = ref(false);
const loggedInUser = ref('');

function handleLoginSuccess(username) {
  loggedInUser.value = username;
  isLoggedIn.value = true;
}

</script>
<template>
  <!-- <Bai1 />
  <Bai2 />
  <Bai3 /> -->
  <div>
    <!-- Nếu chưa đăng nhập thì hiển thị form đăng nhập -->
    <LoginComponent
      v-if="!isLoggedIn"
      @loggedIn="handleLoginSuccess"
    />

    <!-- Nếu đã đăng nhập thì hiển thị form bình luận -->
    <CommentComponent
      v-else
      :username="loggedInUser"
    />
  </div>
</template>

