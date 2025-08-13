<script>
export default {
    name: 'Home',
    data() {
        return {
            featuredProducts: [
                {
                    id: 1,
                    name: 'iPhone 15 Pro Max',
                    price: '29.990.000',
                    originalPrice: '32.990.000',
                    image: 'https://images.unsplash.com/photo-1592750475338-74b7b21085ab?w=300&h=300&fit=crop',
                    rating: 4.8,
                    discount: '9%'
                },
                {
                    id: 2,
                    name: 'Samsung Galaxy S24 Ultra',
                    price: '26.990.000',
                    originalPrice: '29.990.000',
                    image: 'https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?w=300&h=300&fit=crop',
                    rating: 4.7,
                    discount: '10%'
                },
                {
                    id: 3,
                    name: 'MacBook Air M3',
                    price: '28.990.000',
                    originalPrice: '31.990.000',
                    image: 'https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=300&h=300&fit=crop',
                    rating: 4.9,
                    discount: '9%'
                }
            ],
            categories: [
                {
                    name: 'Điện thoại',
                    icon: '📱',
                    image: 'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=200&h=200&fit=crop',
                    count: '500+'
                },
                {
                    name: 'Laptop',
                    icon: '💻',
                    image: 'https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=200&h=200&fit=crop',
                    count: '300+'
                },
                {
                    name: 'PC',
                    icon: '🖥️',
                    image: 'https://images.unsplash.com/photo-1593640408182-31c70c8268f5?w=200&h=200&fit=crop',
                    count: '200+'
                }
            ]
        }
    },
    methods: {
        formatPrice(price) {
            return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
        },
        addToCart(product) {
            console.log('Added to cart:', product);
        },
        viewProduct(productId) {
            this.$router.push(`/product/${productId}`);
        },
        viewCategory(categoryName) {
            this.$router.push(`/category/${categoryName}`);
        }
    }
}
</script>

<template>
    <!-- Promotion Carousel -->
    <section class="py-5 bg-white">
        <div class="container">
            <div class="text-center mb-4">
                <h2 class="fw-bold">🔥 Ưu đãi hấp dẫn</h2>
                <p class="text-muted">Khuyến mãi đặc biệt - Số lượng có hạn</p>
            </div>
            
            <div id="promotionCarousel" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#promotionCarousel" data-bs-slide-to="0" class="active"></button>
                    <button type="button" data-bs-target="#promotionCarousel" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#promotionCarousel" data-bs-slide-to="2"></button>
                </div>
                
                <div class="carousel-inner rounded shadow">
                    <!-- Slide 1: iPhone 15 Pro Max -->
                    <div class="carousel-item active">
                        <div class="text-white p-5" style="background: linear-gradient(135deg, #1a1a2e 0%, #16213e 50%, #0f3460 100%); min-height: 400px;">
                            <div class="row align-items-center h-100">
                                <div class="col-lg-6">
                                    <span class="badge bg-danger fs-6 px-3 py-2 mb-3">🔥 HOT DEAL</span>
                                    <h2 class="fw-bold mb-3">iPhone 15 Pro Max</h2>
                                    <h3 class="text-warning mb-3">Giảm ngay 3.000.000₫</h3>
                                    <div class="mb-4">
                                        <span class="h4 text-decoration-line-through opacity-75 me-3">32.990.000₫</span>
                                        <span class="h2 fw-bold text-warning">29.990.000₫</span>
                                    </div>
                                    <button class="btn btn-warning btn-lg px-4 fw-bold">
                                        <i class="bi bi-cart-plus me-2"></i>MUA NGAY
                                    </button>
                                </div>
                                <div class="col-lg-6 text-center">
                                    <img src="https://images.unsplash.com/photo-1592750475338-74b7b21085ab?w=400&h=400&fit=crop" 
                                         alt="iPhone 15 Pro Max" class="img-fluid" style="max-height: 350px;">
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Slide 2: Samsung Galaxy S24 Ultra -->
                    <div class="carousel-item">
                        <div class="text-white p-5" style="background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 400px;">
                            <div class="row align-items-center h-100">
                                <div class="col-lg-6">
                                    <span class="badge bg-success fs-6 px-3 py-2 mb-3">⚡ FLASH SALE</span>
                                    <h2 class="fw-bold mb-3">Samsung Galaxy S24 Ultra</h2>
                                    <h3 class="text-warning mb-3">Ưu đãi lên đến 4.000.000₫</h3>
                                    <div class="mb-4">
                                        <span class="h4 text-decoration-line-through opacity-75 me-3">29.990.000₫</span>
                                        <span class="h2 fw-bold text-warning">26.990.000₫</span>
                                    </div>
                                    <button class="btn btn-warning btn-lg px-4 fw-bold">
                                        <i class="bi bi-lightning-fill me-2"></i>MUA NGAY
                                    </button>
                                </div>
                                <div class="col-lg-6 text-center">
                                    <img src="https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?w=400&h=400&fit=crop" 
                                         alt="Samsung Galaxy S24 Ultra" class="img-fluid" style="max-height: 350px;">
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Slide 3: MacBook Air M3 -->
                    <div class="carousel-item">
                        <div class="text-white p-5" style="background: linear-gradient(135deg, #74b9ff 0%, #0984e3 100%); min-height: 400px;">
                            <div class="row align-items-center h-100">
                                <div class="col-lg-6">
                                    <span class="badge bg-info fs-6 px-3 py-2 mb-3">💎 PREMIUM</span>
                                    <h2 class="fw-bold mb-3">MacBook Air M3</h2>
                                    <h3 class="text-warning mb-3">Giảm sốc 5.000.000₫</h3>
                                    <div class="mb-4">
                                        <span class="h4 text-decoration-line-through opacity-75 me-3">33.990.000₫</span>
                                        <span class="h2 fw-bold text-warning">28.990.000₫</span>
                                    </div>
                                    <button class="btn btn-warning btn-lg px-4 fw-bold">
                                        <i class="bi bi-laptop me-2"></i>MUA NGAY
                                    </button>
                                </div>
                                <div class="col-lg-6 text-center">
                                    <img src="https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=400&h=400&fit=crop" 
                                         alt="MacBook Air M3" class="img-fluid" style="max-height: 350px;">
                                </div>
                            </div>
                        </div>
                    </div>


                </div>

                <button class="carousel-control-prev" type="button" data-bs-target="#promotionCarousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#promotionCarousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </button>
            </div>
        </div>
    </section>



    <!-- Categories Section -->
    <section class="py-5">
        <div class="container">
            <div class="text-center mb-5">
                <h2 class="fw-bold">Danh mục sản phẩm</h2>
                <p class="text-muted">Khám phá các danh mục sản phẩm đa dạng</p>
            </div>
            <div class="row g-4 justify-content-center">
                <div class="col-lg-4 col-md-4 col-6" v-for="category in categories" :key="category.name">
                    <div class="text-center p-3 h-100 border rounded shadow-sm card-hover" 
                         @click="viewCategory(category.name)" style="cursor: pointer;">
                        <div class="mb-3">
                            <img :src="category.image" :alt="category.name" 
                                 class="img-fluid rounded-circle" style="width: 80px; height: 80px; object-fit: cover;">
                        </div>
                        <h6 class="fw-bold mb-1">{{ category.name }}</h6>
                        <small class="text-muted">{{ category.count }} sản phẩm</small>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Featured Products Section -->
    <section class="py-5 bg-white">
        <div class="container">
            <div class="text-center mb-5">
                <h2 class="fw-bold">Sản phẩm nổi bật</h2>
                <p class="text-muted">Những sản phẩm bán chạy nhất hiện tại</p>
            </div>
            <div class="row g-4 justify-content-center">
                <div class="col-lg-4 col-md-6 col-sm-12" v-for="product in featuredProducts" :key="product.id">
                    <div class="card h-100 shadow-sm card-hover">
                        <div class="position-relative" @click="viewProduct(product.id)" style="cursor: pointer;">
                            <img :src="product.image" :alt="product.name" class="card-img-top" style="height: 250px; object-fit: cover;">
                            <span class="badge bg-danger position-absolute top-0 start-0 m-2">
                                -{{ product.discount }}
                            </span>
                        </div>
                        <div class="card-body d-flex flex-column">
                            <h6 class="card-title fw-bold">{{ product.name }}</h6>
                            <div class="mb-2">
                                <span class="text-warning">
                                    ★★★★★
                                </span>
                                <small class="text-muted ms-1">({{ product.rating }})</small>
                            </div>
                            <div class="mb-3">
                                <span class="h5 text-danger fw-bold">{{ formatPrice(product.price) }}₫</span>
                                <small class="text-muted text-decoration-line-through ms-2">
                                    {{ formatPrice(product.originalPrice) }}₫
                                </small>
                            </div>
                            <div class="mt-auto">
                                <button class="btn btn-primary w-100" @click="addToCart(product)">
                                    <i class="bi bi-cart-plus me-1"></i>
                                    Thêm giỏ hàng
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-center mt-4">
                <button class="btn btn-outline-primary btn-lg">
                    Xem tất cả sản phẩm
                </button>
            </div>
        </div>
    </section>


</template>

<style scoped>
.card-hover {
  transition: transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out;
}

.card-hover:hover {
  transform: translateY(-5px);
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15) !important;
}
</style>


