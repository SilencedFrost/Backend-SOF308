<script>
import Hello from '@/components/Hello.vue'
import Bai3 from '@/components/Bai3.vue'
import Bai4 from '@/components/Bai4.vue'

export default {
  components: {
    Hello,
    Bai3,
    Bai4
  }
}
</script>

<template>
  <div class="container-fluid p-2">
    <h4>Bai 2</h4>
    <Hello />
    <hr>
    <h4>Bai 3</h4>
    <Bai3 />
    <hr>
    <h4>Bai 4</h4>
    <Bai4 />
  </div>
</template>
