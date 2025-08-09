<script>
import sesameOil from '@/assets/images/sesameoil_300x300.jpg'

export default {
    data() {
        return {
            sesameOil
        }
    }
}
</script>

<template>
    <div class="row p-2">
        <div class="col-4">
            <img class="img-fluid ratio ratio-1x1 rounded-circle" :src="sesameOil" alt="">
        </div>
        <div class="col-8">
            <b>10 công dụng bất ngờ từ dầu dừa</b><br>
            <p>Dầu dừa như một loại kem dưỡng ẩm tự nhiên cho cơ thể, giúp việc sản xuất collagen trong các tế bào...</p>
        </div>
    </div>
</template>