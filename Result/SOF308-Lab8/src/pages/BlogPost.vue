<script setup>
import { computed } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()

const postId = computed(() => route.params.id)
</script>

<template>
  Blogpost
  <h5>Post ID: {{ postId }}</h5>
</template>
