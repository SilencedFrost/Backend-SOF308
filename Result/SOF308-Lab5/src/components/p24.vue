<script>
import {ref} from "vue";

export default {
  setup() {
    // Tạo 1 ref object user
    const user = ref({name: "Nam", role: "Admin"});

    const updateUser = () => {
      // Cập nhật ref object qua thuộc tính value
      user.value = {name: "NamDN", role: "Nhân viên"};
    };

    return {
      user, updateUser,
    };
  },
};
</script>
<template>
  <h4>Tài khoản: {{ user.name }}</h4>
  <h4>Vai trò: {{ user.role }}</h4>

  <button class="btn btn-danger" 
   @click="updateUser">Cập nhật</button>
</template>

