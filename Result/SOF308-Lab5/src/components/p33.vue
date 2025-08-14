<template>
  <div style="color: red;">VueJS</div>
  <div :style="{ color: textColor, fontSize: fontSize + 'px' }">
    FPT
  </div>
  <div>
    Color: <input type="text" v-model="textColor"> <br>
    Size: <input type="number" v-model="fontSize">
  </div>
</template>
 <script>
import { ref } from 'vue';

export default {
  setup() {
    const textColor = ref('blue');
    const fontSize = ref(16);
    
    return {
      textColor,
      fontSize,
     
    };
  }
};
</script>