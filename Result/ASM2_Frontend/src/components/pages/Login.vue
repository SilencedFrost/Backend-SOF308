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
            :disabled="isLoading"
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
            :disabled="isLoading"
          />
        </div>
        <button type="submit" class="btn btn-primary w-100" :disabled="isLoading">
          <span v-if="isLoading" class="spinner-border spinner-border-sm me-2" role="status"></span>
          {{ isLoading ? 'Đang đăng nhập...' : 'Đăng nhập' }}
        </button>
      </form>
      <button class="btn btn-danger w-100 mt-3" @click="loginWithGoogle" :disabled="isLoading">
        <i class="fab fa-google me-2"></i> Đăng nhập bằng Google
      </button>
      <div class="mt-3 text-center">
        <a href="#" class="text-decoration-none">Quên mật khẩu?</a>
        <span class="mx-2">|</span>
        <router-link to="/register" class="text-decoration-none">Đăng ký tài khoản</router-link>
      </div>
      
      <!-- Success message -->
      <div v-if="success" class="alert alert-success mt-3 py-2">
        <i class="bi bi-check-circle me-2"></i>
        {{ success }}
      </div>
      
      <div v-if="error" class="alert alert-danger mt-3 py-2">
        <i class="bi bi-exclamation-triangle me-2"></i>
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
      success: "",
      isLoading: false
    };
  },
  
  mounted() {
    // Kiểm tra nếu đã đăng nhập thì chuyển về trang chủ
    const savedUser = localStorage.getItem('user');
    if (savedUser) {
      this.$router.push('/');
    }
  },
  
  methods: {
    async onLogin() {
      this.error = "";
      this.success = "";
      
      if (!this.username || !this.password) {
        this.error = "Vui lòng nhập đầy đủ thông tin!";
        return;
      }
      
      this.isLoading = true;
      
      try {
        const res = await fetch("/api/login", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          credentials: "include",
          body: JSON.stringify({
            username: this.username,
            password: this.password,
          }),
        });
        
        if (!res.ok) {
          const errorData = await res.json();
          this.error = errorData.message || "Tên đăng nhập hoặc mật khẩu không đúng!";
          return;
        }
        
        const data = await res.json();
        
        // Lưu thông tin user vào localStorage
        const userData = {
          id: data.id,
          username: data.username || this.username,
          email: data.email,
          firstName: data.firstName,
          lastName: data.lastName,
          phone: data.phone,
          name: data.name || `${data.firstName} ${data.lastName}` || data.username,
          token: data.token,
          ...data
        };
        
        localStorage.setItem("user", JSON.stringify(userData));
        
        this.success = "Đăng nhập thành công! Đang chuyển về trang chủ...";
        
        // Chờ 1 giây rồi chuyển hướng
        setTimeout(() => {
          this.$router.push("/");
          // Reload để navbar cập nhật trạng thái
          window.location.reload();
        }, 1000);
        
      } catch (err) {
        console.error('Login error:', err);
        this.error = "Có lỗi xảy ra, vui lòng thử lại!";
      } finally {
        this.isLoading = false;
      }
    },
    
    loginWithGoogle() {
      const returnUrl = this.$route.query.returnUrl || '/';
      window.location.href = `/api/login/google?returnUrl=${encodeURIComponent(returnUrl)}`;
    },
    
    logout() {
      localStorage.removeUser("user");
      this.$router.push("/");
      window.location.reload();
    }
  },
};
</script>