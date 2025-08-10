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
                },
                {
                    id: 4,
                    name: 'AirPods Pro 2',
                    price: '5.990.000',
                    originalPrice: '6.990.000',
                    image: 'https://images.unsplash.com/photo-1606220945770-b5b6c2c55bf1?w=300&h=300&fit=crop',
                    rating: 4.6,
                    discount: '14%'
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
                    image: 'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=200&h=200&fit=crop',
                    count: '200+'
                },
                {
                    name: 'Tai nghe',
                    icon: '🎧',
                    image: 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=200&h=200&fit=crop',
                    count: '150+'
                },
                {
                    name: 'Đồng hồ thông minh',
                    icon: '⌚',
                    image: 'https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=200&h=200&fit=crop',
                    count: '100+'
                },
                {
                    name: 'Tablet',
                    icon: '📱',
                    image: 'https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=200&h=200&fit=crop',
                    count: '80+'
                },
                {
                    name: 'Phụ kiện',
                    icon: '🔌',
                    image: 'https://images.unsplash.com/photo-1572569511254-d8f925fe2cbb?w=200&h=200&fit=crop',
                    count: '300+'
                }
            ]
        }
    },
    methods: {
        formatPrice(price) {
            return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
        },
        addToCart(product) {
            // Thêm vào giỏ hàng
            console.log('Thêm vào giỏ hàng:', product);
            // Có thể emit event hoặc gọi store action
        },
        viewProduct(productId) {
            this.$router.push(`/product/${productId}`);
        },
        viewCategory(categoryName) {
            this.$router.push(`/category/${categoryName.toLowerCase()}`);
        }
    }
}
</script>

<template>
    <!-- Promotion Carousel -->
    <section class="promotion-carousel py-5">
        <div class="container">
            <div class="text-center mb-4">
                <h2 class="fw-bold">🔥 Ưu đãi hấp dẫn</h2>
                <p class="text-muted">Khuyến mãi đặc biệt - Số lượng có hạn</p>
            </div>
            
            <div id="promotionCarousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="4000">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#promotionCarousel" data-bs-slide-to="0" class="active"></button>
                    <button type="button" data-bs-target="#promotionCarousel" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#promotionCarousel" data-bs-slide-to="2"></button>
                    <button type="button" data-bs-target="#promotionCarousel" data-bs-slide-to="3"></button>
                </div>
                
                <div class="carousel-inner rounded-4 shadow-lg">
                    <!-- Slide 1: iPhone 15 Pro Max -->
                    <div class="carousel-item active">
                        <div class="promotion-slide bg-gradient-iphone text-white p-5">
                            <div class="row align-items-center">
                                <div class="col-lg-6">
                                    <div class="promotion-badge mb-3">
                                        <span class="badge bg-danger fs-6 px-3 py-2">🔥 HOT DEAL</span>
                                    </div>
                                    <h2 class="fw-bold mb-3">iPhone 15 Pro Max</h2>
                                    <h3 class="text-warning mb-3">Giảm ngay 3.000.000₫</h3>
                                    <div class="price-info mb-4">
                                        <span class="h4 text-decoration-line-through opacity-75 me-3">32.990.000₫</span>
                                        <span class="h2 fw-bold text-warning">29.990.000₫</span>
                                    </div>
                                    <div class="offer-details mb-4">
                                        <div class="d-flex align-items-center mb-2">
                                            <i class="bi bi-gift-fill text-warning me-2"></i>
                                            <span>Tặng AirPods Pro 2 (trị giá 6.990.000₫)</span>
                                        </div>
                                        <div class="d-flex align-items-center mb-2">
                                            <i class="bi bi-shield-check-fill text-success me-2"></i>
                                            <span>Bảo hành 24 tháng chính hãng</span>
                                        </div>
                                        <div class="d-flex align-items-center">
                                            <i class="bi bi-truck-fill text-info me-2"></i>
                                            <span>Miễn phí giao hàng toàn quốc</span>
                                        </div>
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
                        <div class="promotion-slide bg-gradient-samsung text-white p-5">
                            <div class="row align-items-center">
                                <div class="col-lg-6">
                                    <div class="promotion-badge mb-3">
                                        <span class="badge bg-success fs-6 px-3 py-2">⚡ FLASH SALE</span>
                                    </div>
                                    <h2 class="fw-bold mb-3">Samsung Galaxy S24 Ultra</h2>
                                    <h3 class="text-warning mb-3">Ưu đãi lên đến 4.000.000₫</h3>
                                    <div class="price-info mb-4">
                                        <span class="h4 text-decoration-line-through opacity-75 me-3">29.990.000₫</span>
                                        <span class="h2 fw-bold text-warning">25.990.000₫</span>
                                    </div>
                                    <div class="offer-details mb-4">
                                        <div class="d-flex align-items-center mb-2">
                                            <i class="bi bi-gift-fill text-warning me-2"></i>
                                            <span>Tặng Galaxy Watch6 (trị giá 7.990.000₫)</span>
                                        </div>
                                        <div class="d-flex align-items-center mb-2">
                                            <i class="bi bi-arrow-repeat text-info me-2"></i>
                                            <span>Thu cũ đổi mới giá cao</span>
                                        </div>
                                        <div class="d-flex align-items-center">
                                            <i class="bi bi-credit-card-fill text-success me-2"></i>
                                            <span>Trả góp 0% lãi suất</span>
                                        </div>
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
                        <div class="promotion-slide bg-gradient-macbook text-white p-5">
                            <div class="row align-items-center">
                                <div class="col-lg-6">
                                    <div class="promotion-badge mb-3">
                                        <span class="badge bg-info fs-6 px-3 py-2">💎 PREMIUM</span>
                                    </div>
                                    <h2 class="fw-bold mb-3">MacBook Air M3</h2>
                                    <h3 class="text-warning mb-3">Giảm sốc 5.000.000₫</h3>
                                    <div class="price-info mb-4">
                                        <span class="h4 text-decoration-line-through opacity-75 me-3">33.990.000₫</span>
                                        <span class="h2 fw-bold text-warning">28.990.000₫</span>
                                    </div>
                                    <div class="offer-details mb-4">
                                        <div class="d-flex align-items-center mb-2">
                                            <i class="bi bi-gift-fill text-warning me-2"></i>
                                            <span>Tặng balo Laptop cao cấp</span>
                                        </div>
                                        <div class="d-flex align-items-center mb-2">
                                            <i class="bi bi-tools text-success me-2"></i>
                                            <span>Cài đặt phần mềm miễn phí</span>
                                        </div>
                                        <div class="d-flex align-items-center">
                                            <i class="bi bi-headset text-info me-2"></i>
                                            <span>Hỗ trợ kỹ thuật 24/7</span>
                                        </div>
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

                    <!-- Slide 4: Gaming Setup -->
                    <div class="carousel-item">
                        <div class="promotion-slide bg-gradient-gaming text-white p-5">
                            <div class="row align-items-center">
                                <div class="col-lg-6">
                                    <div class="promotion-badge mb-3">
                                        <span class="badge bg-warning fs-6 px-3 py-2">🎮 GAMING</span>
                                    </div>
                                    <h2 class="fw-bold mb-3">Combo Gaming Siêu Khủng</h2>
                                    <h3 class="text-warning mb-3">Tiết kiệm đến 8.000.000₫</h3>
                                    <div class="price-info mb-4">
                                        <span class="h4 text-decoration-line-through opacity-75 me-3">45.990.000₫</span>
                                        <span class="h2 fw-bold text-warning">37.990.000₫</span>
                                    </div>
                                    <div class="offer-details mb-4">
                                        <div class="d-flex align-items-center mb-2">
                                            <i class="bi bi-pc-display text-warning me-2"></i>
                                            <span>Gaming Laptop + Monitor 4K</span>
                                        </div>
                                        <div class="d-flex align-items-center mb-2">
                                            <i class="bi bi-headphones text-success me-2"></i>
                                            <span>Tặng tai nghe Gaming RGB</span>
                                        </div>
                                        <div class="d-flex align-items-center">
                                            <i class="bi bi-joystick text-info me-2"></i>
                                            <span>Tặng chuột + bàn phím cơ</span>
                                        </div>
                                    </div>
                                    <button class="btn btn-warning btn-lg px-4 fw-bold">
                                        <i class="bi bi-controller me-2"></i>MUA NGAY
                                    </button>
                                </div>
                                <div class="col-lg-6 text-center">
                                    <img src="https://images.unsplash.com/photo-1593640408182-31c70c8268f5?w=400&h=400&fit=crop" 
                                         alt="Gaming Setup" class="img-fluid" style="max-height: 350px;">
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
    <section class="categories-section py-5">
        <div class="container">
            <div class="text-center mb-5">
                <h2 class="fw-bold">Danh mục sản phẩm</h2>
                <p class="text-muted">Khám phá các danh mục sản phẩm đa dạng</p>
            </div>
            <div class="row g-4">
                <div class="col-lg-2 col-md-4 col-6" v-for="category in categories" :key="category.name">
                    <div class="category-card text-center p-3 h-100 border rounded-3 hover-shadow" 
                         @click="viewCategory(category.name)" style="cursor: pointer;">
                        <div class="category-image mb-3">
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
    <section class="featured-products py-5 bg-light">
        <div class="container">
            <div class="text-center mb-5">
                <h2 class="fw-bold">Sản phẩm nổi bật</h2>
                <p class="text-muted">Những sản phẩm bán chạy nhất hiện tại</p>
            </div>
            <div class="row g-4">
                <div class="col-lg-3 col-md-6" v-for="product in featuredProducts" :key="product.id">
                    <div class="product-card card h-100 border-0 shadow-sm hover-shadow">
                        <div class="position-relative">
                            <img :src="product.image" :alt="product.name" class="card-img-top" style="height: 250px; object-fit: cover;">
                            <span class="badge bg-danger position-absolute top-0 start-0 m-2">
                                -{{ product.discount }}
                            </span>
                        </div>
                        <div class="card-body d-flex flex-column">
                            <h6 class="card-title fw-bold">{{ product.name }}</h6>
                            <div class="rating mb-2">
                                <span class="text-warning">
                                    ★★★★★
                                </span>
                                <small class="text-muted ms-1">({{ product.rating }})</small>
                            </div>
                            <div class="price mb-3">
                                <span class="h5 text-danger fw-bold">{{ formatPrice(product.price) }}₫</span>
                                <small class="text-muted text-decoration-line-through ms-2">
                                    {{ formatPrice(product.originalPrice) }}₫
                                </small>
                            </div>
                            <div class="mt-auto d-flex gap-2">
                                <button class="btn btn-primary flex-fill" @click="addToCart(product)">
                                    <i class="bi bi-cart-plus me-1"></i>
                                    Thêm giỏ hàng
                                </button>
                                <button class="btn btn-outline-secondary" @click="viewProduct(product.id)">
                                    <i class="bi bi-eye"></i>
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
.bg-gradient-primary {
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
}

.hover-shadow {
    transition: all 0.3s ease;
}

.hover-shadow:hover {
    transform: translateY(-5px);
    box-shadow: 0 10px 25px rgba(0,0,0,0.15) !important;
}

.category-card:hover {
    background-color: #f8f9fa;
    border-color: #007bff !important;
}

.product-card:hover {
    border-color: #007bff !important;
}

.feature-icon {
    width: 80px;
    height: 80px;
    margin: 0 auto;
    display: flex;
    align-items: center;
    justify-content: center;
    background: white;
    border-radius: 50%;
    box-shadow: 0 5px 15px rgba(0,0,0,0.1);
}

.rating {
    font-size: 0.9rem;
}

/* Carousel Styles */
.promotion-carousel {
    background: linear-gradient(135deg, #f8f9fa 0%, #e9ecef 100%);
}

.promotion-slide {
    min-height: 400px;
    display: flex;
    align-items: center;
    position: relative;
    overflow: hidden;
}

.promotion-slide::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: rgba(0,0,0,0.1);
    z-index: 1;
}

.promotion-slide > .row {
    position: relative;
    z-index: 2;
}

.bg-gradient-iphone {
    background: linear-gradient(135deg, #1a1a2e 0%, #16213e 50%, #0f3460 100%);
}

.bg-gradient-samsung {
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
}

.bg-gradient-macbook {
    background: linear-gradient(135deg, #2c3e50 0%, #34495e 50%, #2c3e50 100%);
}

.bg-gradient-gaming {
    background: linear-gradient(135deg, #ff6b6b 0%, #ee5a24 50%, #ff9ff3 100%);
}

.promotion-badge {
    animation: pulse 2s infinite;
}

@keyframes pulse {
    0% { transform: scale(1); }
    50% { transform: scale(1.05); }
    100% { transform: scale(1); }
}

.carousel-indicators {
    bottom: -50px;
}

.carousel-indicators button {
    width: 12px;
    height: 12px;
    border-radius: 50%;
    margin: 0 8px;
    background-color: #007bff;
    opacity: 0.5;
    border: none;
}

.carousel-indicators button.active {
    opacity: 1;
    transform: scale(1.2);
}

.carousel-control-prev,
.carousel-control-next {
    width: 60px;
    height: 60px;
    background: rgba(0,0,0,0.3);
    border-radius: 50%;
    top: 50%;
    transform: translateY(-50%);
    transition: all 0.3s ease;
}

.carousel-control-prev {
    left: -30px;
}

.carousel-control-next {
    right: -30px;
}

.carousel-control-prev:hover,
.carousel-control-next:hover {
    background: rgba(0,0,0,0.6);
    transform: translateY(-50%) scale(1.1);
}

.carousel-control-prev-icon,
.carousel-control-next-icon {
    width: 24px;
    height: 24px;
}

.offer-details {
    font-size: 0.95rem;
}

.price-info {
    text-shadow: 2px 2px 4px rgba(0,0,0,0.3);
}

@media (max-width: 768px) {
    .hero-section .display-4 {
        font-size: 2rem;
    }
    
    .hero-section .lead {
        font-size: 1rem;
    }
    
    .promotion-slide {
        min-height: 300px;
        padding: 2rem 1rem !important;
    }
    
    .promotion-slide h2 {
        font-size: 1.5rem;
    }
    
    .promotion-slide h3 {
        font-size: 1.2rem;
    }
    
    .price-info .h2 {
        font-size: 1.5rem;
    }
    
    .price-info .h4 {
        font-size: 1rem;
    }
    
    .carousel-control-prev,
    .carousel-control-next {
        display: none;
    }
}

@media (max-width: 576px) {
    .promotion-slide .col-lg-6:last-child {
        display: none;
    }
    
    .promotion-slide {
        text-align: center;
    }
}
</style>