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
    <h6 class="bg-light m-0 p-2">
        Phương pháp tập Pilates giúp phục hồi chấn thương cột sống
        <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/chat-left.svg" alt="comments" width="20" height="20" class="me-1">
        16
    </h6>
    <hr class="m-0">
    <img class="p-2" :src="pilates" alt="">
    <p class="p-2">
        Ngoài việc giúp duy trì vóc dáng, cải thiện sự linh hoạt, dẻo dai cho người tập, Pilates giúp cơ bắp và các khớp mọc dài hơn, kéo giãn hơn...
    </p>
</template>