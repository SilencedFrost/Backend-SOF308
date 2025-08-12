<script>
import logoImage from '@/assets/images/logo-energy-pilates.png'

export default {
    data() {
        return {
            logoImage,
            searchQuery: ''
        }
    },
    methods: {
        onSearch() {
            // Xử lý tìm kiếm sản phẩm
            this.$router.push({ path: '/search', query: { q: this.searchQuery } });
        }
    }
}
</script>

<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <!-- Logo -->
            <a class="navbar-brand" href="/">
                <img :src="logoImage" alt="" style="width: 150px;">
            </a>

            <!-- Tìm kiếm sản phẩm -->
            <form class="d-flex me-3" @submit.prevent="onSearch">
                <input class="form-control me-2" type="search" v-model="searchQuery" placeholder="Tìm kiếm sản phẩm" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">
                    <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/search.svg" width="20" height="20" alt="search">
                </button>
            </form>

            <!-- Toggler button -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Navbar content -->
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    
                    <!-- Giỏ hàng -->
                    <li class="nav-item">
                        <router-link class="nav-link d-flex align-items-center" to="/cart">
                            <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/cart.svg" alt=""
                                width="20" height="20" class="me-2">
                            Giỏ hàng
                        </router-link>
                    </li>
                    <!-- Account dropdown/collapse -->
                    <li class="nav-item dropdown">
                        <!-- Desktop dropdown -->
                        <a class="nav-link dropdown-toggle d-flex align-items-center d-none d-lg-flex" href="#"
                            id="userDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/person-circle.svg"
                                alt="" width="20" height="20" class="me-2">
                            Tài khoản
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="userDropdown">
                            <li><a class="dropdown-item" href="#">Đăng nhập</a></li>
                            <li><a class="dropdown-item" href="#">Đăng xuất</a></li>
                            <li><a class="dropdown-item" href="#">Quên mật khẩu</a></li>
                            <li><a class="dropdown-item" href="#">Đăng ký thành viên</a></li>
                            <li><router-link class="dropdown-item" to="/api/user">Quản lý tài khoản</router-link></li>
                        </ul>

                        <!-- Mobile collapse -->
                        <a class="nav-link d-flex align-items-center d-lg-none" href="#userOptions"
                            data-bs-toggle="collapse" aria-expanded="false" aria-controls="userOptions">
                            <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/person-circle.svg"
                                alt="" width="20" height="20" class="me-2">
                            Tài khoản
                        </a>
                    </li>
                </ul>

                <!-- Mobile collapse menu -->
                <div class="collapse d-lg-none" id="userOptions">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link ps-4" href="#">Đăng nhập</a></li>
                        <li class="nav-item"><a class="nav-link ps-4" href="#">Đăng xuất</a></li>
                        <li class="nav-item"><a class="nav-link ps-4" href="#">Quên mật khẩu</a></li>
                        <li class="nav-item"><a class="nav-link ps-4" href="#">Đăng ký thành viên</a></li>
                        <li class="nav-item"><router-link class="nav-link ps-4" to="/api/user">Quản lý tài khoản (API)</router-link></li>
                    </ul>
                </div>

                <!-- Language selection -->
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Tiếng Việt</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Tiếng Anh</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>