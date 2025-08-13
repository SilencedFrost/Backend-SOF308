<template>
  
  <div class="container">
    <div class="row">
      <div :class="'col-sm-' + leftCol" :style="{ backgroundColor: leftColor}" class="border p-4"></div>

      <div :class="'col-sm-' + rightCol" :style="{ backgroundColor: rightColor}" class="border p-4"></div>
    </div>
    <hr>
    <div class="row border mt-3">
      <div class="col-sm-6 mt-3">
        <input type="number" v-model.number="leftCol" />
        <p>Cột trái (col-sm-{{ leftCol }})</p>
        <input type="text" v-model="leftColor" />
        <p>Cột trái (Màu: {{ leftColor }})</p>
      </div>
      <div class="col-sm-6 mt-3">
        <input type="number" v-model.number="rightCol" />
        <p>Cột phải (col-sm-{{ rightCol }})</p>
        <input type="text" v-model="rightColor" />
        <p>Cột trái (Màu: {{ rightColor }})</p>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from "vue";

export default {
  setup() {
    const rightCol = ref(8);
    const leftCol = ref(4);
    const leftColor = ref('red');
    const rightColor = ref('blue');

    return {
      rightCol,
      leftCol,
      leftColor,
      rightColor
    };
  },
};
</script>