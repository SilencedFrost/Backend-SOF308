<script>
import pilates from '@/assets/images/tap-piltes.jpg'

export default {
    data() {
        return {
            pilates
        }
    }
}
</script>

<template>
    <h5 class="bg-light m-0 p-2">
        Phương pháp tập Pilates giúp phục hồi chấn thương cột sống
        <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/chat-left.svg" alt="comments" width="20" height="20" class="me-1">
        16
    </h5>
    <hr class="m-0">
    <img class="p-2" :src="pilates" alt="">
    <p class="p-2">Ngoài việc duy trì vóc dáng, cải thiện sự linh hoạt, dẻo dai, các bài tập Pilates còn có khả năng trị đau lưng, là giải pháp hữu hiệu để phục hồi chấn thương cột sống.</p>
</template>