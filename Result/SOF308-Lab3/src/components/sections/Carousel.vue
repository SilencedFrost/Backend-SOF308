<script>
import banner1 from '@/assets/images/banner1.jpg'
import banner2 from '@/assets/images/banner2.jpg'
import banner3 from '@/assets/images/banner3.jpg'

export default{
    data() {
        return {
            banner1,
            banner2,
            banner3
        }
    }
}
</script>

<template>
    <div id="imageCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img :src="banner1" class="d-block w-100" alt="green field">
            </div>
            <div class="carousel-item">
                <img :src="banner2" class="d-block w-100" alt="green planet">
            </div>
            <div class="carousel-item">
                <img :src="banner3" class="d-block w-100" alt="happy earth">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#imageCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#imageCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</template>