<script>

</script>

<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <!-- Logo -->
            <a class="navbar-brand" href="#">
                <img src="./resources/images/logo-energy-pilates.png" alt="" style="width: 150px;">
            </a>

            <!-- Toggler button -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Navbar content -->
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <!-- Regular nav items -->
                    <li class="nav-item">
                        <router-link class="nav-link d-flex align-items-center" to="/post">
                            <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/journal-text.svg" alt=""
                                width="20" height="20" class="me-2">
                            Bài viết
                        </router-link>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link d-flex align-items-center" href="#">
                            <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/play-circle.svg" alt=""
                                width="20" height="20" class="me-2">
                            Video
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link d-flex align-items-center" href="#">
                            <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/info-circle.svg" alt=""
                                width="20" height="20" class="me-2">
                            Giới thiệu
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link d-flex align-items-center" href="#">
                            <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/calendar-event.svg"
                                alt="" width="20" height="20" class="me-2">
                            Sự kiện
                        </a>
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
                            <li><a class="dropdown-item" href="#">Quên mật khẩu</a></li>
                            <li><a class="dropdown-item" href="#">Đăng ký thành viên</a></li>
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
                        <li class="nav-item"><a class="nav-link ps-4" href="#">Quên mật khẩu</a></li>
                        <li class="nav-item"><a class="nav-link ps-4" href="#">Đăng ký thành viên</a></li>
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