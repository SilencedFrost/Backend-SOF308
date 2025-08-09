<script>
import avatar from '@/assets/images/avatar.png'

export default {
    data() {
        return {
            avatar
        }
    }
}
</script>

<template>
    <h2 class="text-info">Về tôi</h2>
    <div class="card bg-light p-2">
        <div>
            <img class="img-fluid" :src="avatar" alt="">
            <h5>Giới thiệu bản thân</h5>
            <p class="card-text">
                TS. Trần Hoàng, Tổ chức Tư vấn sức khỏe quốc tế độc lập <br>
                Châm ngôn: Ta không được chọn nơi mình sinh ra, nhưng ta được chọn cách mình sẽ sống.
            </p>
        </div>
    </div>
</template>