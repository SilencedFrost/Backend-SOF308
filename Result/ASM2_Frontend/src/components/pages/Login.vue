<template>
  <div class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="card shadow-sm p-4" style="max-width: 400px; width: 100%;">
      <h3 class="mb-4 text-center text-primary">Đăng nhập</h3>
      <form @submit.prevent="onLogin">
        <div class="mb-3">
          <label for="username" class="form-label">Tên đăng nhập</label>
          <input
            type="text"
            id="username"
            v-model="username"
            class="form-control"
            required
            autocomplete="username"
          />
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Mật khẩu</label>
          <input
            type="password"
            id="password"
            v-model="password"
            class="form-control"
            required
            autocomplete="current-password"
          />
        </div>
        <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
      </form>
      <button class="btn btn-danger w-100 mt-3" @click="loginWithGoogle">
        <i class="fab fa-google me-2"></i> Đăng nhập bằng Google
      </button>
      <div class="mt-3 text-center">
        <a href="#" class="text-decoration-none">Quên mật khẩu?</a>
        <span class="mx-2">|</span>
        <a href="#" class="text-decoration-none">Đăng ký tài khoản</a>
      </div>
      <div v-if="error" class="alert alert-danger mt-3 py-2">
        {{ error }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      username: "",
      password: "",
      error: "",
    };
  },
  methods: {
    async onLogin() {
      this.error = "";
      if (!this.username || !this.password) {
        this.error = "Vui lòng nhập đầy đủ thông tin!";
        return;
      }
      try {
        const res = await fetch("/api/login", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            username: this.username,
            password: this.password,
          }),
        });
        if (!res.ok) {
          this.error = "Tên đăng nhập hoặc mật khẩu không đúng!";
          return;
        }
        const data = await res.json();
        localStorage.setItem("user", JSON.stringify(data));
        this.$router.push("/");
      } catch (err) {
        this.error = "Có lỗi xảy ra, vui lòng thử lại!";
      }
    },
    loginWithGoogle() {
      // Redirect to Google OAuth (ví dụ)
      window.location.href = "/api/login/google";
    },
    logout() {
      localStorage.removeItem("user");
      this.$router.push("/");
    }
  },
};
</script>