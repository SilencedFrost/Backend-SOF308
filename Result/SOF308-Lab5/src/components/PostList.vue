<template>
  <div>
    <h2>Danh sách bài viết</h2>
    <div v-for="(post, index) in posts" :key="index" :class="{ 'highlighted': post.title.length > 20 }"
         :style="{ backgroundColor: post.backgroundColor, color: post.textcolor }" class="post">
      <h3 class="text-success">{{ post.title }}</h3>
      <p>{{ post.content }}</p>
      <p>{{ post.author }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PostList',
  props: {
    posts: {
      type: Array,
      required: true
    }
  }
}
</script>

<style>
.post {
  padding: 20px;
  margin: 10px 0;
  border: 1px solid #ddd;
  border-radius: 10px;
}

.highlighted {
  border: 2px solid lightgray;
}
</style>