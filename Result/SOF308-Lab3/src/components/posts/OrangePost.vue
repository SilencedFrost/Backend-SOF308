<script>
import orange from '@/assets/images/orange_300x300.jpg'

export default {
    data() {
        return {
            orange
        }
    }
}
</script>

<template>
    <div class="row p-2">
        <div class="col-4">
            <img class="img-fluid ratio ratio-1x1" :src="orange" alt="">
        </div>
        <div class="col-8">
            <b>9 tác dụng tuyệt vời của quả cam</b><br>
            <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/chat-left.svg" alt="comments" width="20" height="20" class="me-1">
            16
        </div>
    </div>
</template>