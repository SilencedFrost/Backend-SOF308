<script>
import pilates from '@/assets/images/tim-mach.jpg'

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
        Tập Pilates có thể cải thiện sức khỏe tim mạch của bạn
        <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/chat-left.svg" alt="comments" width="20" height="20" class="me-1">
        5
    </h5>
    <hr class="m-0">
    <img class="p-2" :src="pilates" alt="">
    <p class="p-2">Tập Pilates không chỉ giúp bạn có một cơ thể khỏe mạnh và linh hoạt mà còn có nhiều lợi ích cho sức khỏe tim mạch, Bài viết này sẽ tìm hiểu sâu hơn về tác động tích cực của việc tập Pilates đối với sức khỏe tim mạch.</p>
</template>