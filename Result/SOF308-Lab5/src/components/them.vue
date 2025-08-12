<template>
  Name: <input type="text" v-bind:value="name">
  <p>Xin chào {{ name }}</p>

  Username: <input type="text" v-model="userName">
  <p>Xin chào: {{ userName }}</p>
</template>

<script>
import { ref } from 'vue'

export default {
  setup() {
    const name = ref('Bình');
    const userName = ref('VueJS');
    return { name, userName };
  }
}
</script>
