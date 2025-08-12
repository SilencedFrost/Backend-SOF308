<template>
  <div :class="{ active: isActive, 'text-danger': hasError }">Hello World</div>
</template>
<script>
import { ref } from 'vue';
export default {
  setup() {
    const isActive = ref(true);
    const hasError = ref(true);

    return { isActive, hasError };
  }
};
</script>

