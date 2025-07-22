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
            <img class="img-fluid ratio ratio-1x1 rounded-circle" :src="orange" alt="">
        </div>
        <div class="col-8">
            <b>9 tác dụng tuyệt vời của quả cam</b><br>
            <p>Cam tự hào về khả năng chống lão hoá mạnh mẽ nhờ hàm lượng chất chống oxy hoá cao...</p>
        </div>
    </div>
</template>