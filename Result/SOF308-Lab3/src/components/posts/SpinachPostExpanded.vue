<script>
import spinach from '@/assets/images/spinach_300x300.jpg'

export default {
    data() {
        return {
            spinach
        }
    }
}
</script>

<template>
    <div class="row p-2">
        <div class="col-4">
            <img class="img-fluid ratio ratio-1x1 rounded-circle" :src="spinach" alt="">
        </div>
        <div class="col-8">
            <b>Lợi ích khi ăn rau mỗi ngày</b><br>
            <p>Tiêu thụ rau xanh hàng ngày sẽ giúp tăng cường thị lực, kiểm soát cân nặng, ngăn ngừa ung thư...</p>
        </div>
    </div>
</template>