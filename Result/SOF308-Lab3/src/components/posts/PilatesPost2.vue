<script>
import pilates from '@/assets/images/tap-pilates1.jpg'

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
        Đây là những gì 1 giờ tập Pilates có thể làm cho cơ thể của bạn
        <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/chat-left.svg" alt="comments" width="20" height="20" class="me-1">
        8
    </h5>
    <hr class="m-0">
    <img class="p-2" :src="pilates" alt="">
    <p class="p-2">Được thiết kế để xây dựng cơ bắp săn chắc, khỏe mạnh hơn, bài tập này đã trở thành một cái tên quen thuộc nhờ có rất nhiều người nổi tiếng theo dõi.</p>
</template>