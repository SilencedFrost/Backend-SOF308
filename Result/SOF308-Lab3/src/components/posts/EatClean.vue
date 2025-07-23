<script>
import eatClean from '@/assets/images/eat-clean.png'

export default {
    data() {
        return {
            eatClean
        }
    }
}
</script>

<template>
    <h5 class="bg-light m-0 p-2">
        EAT CLEAN: Nên và Không Nên Thực Phẩm Nào?
        <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/chat-left.svg" alt="comments" width="20" height="20" class="me-1">
        3
    </h5>
    <hr class="m-0">
    <img class="p-2" :src="eatClean" alt="">
    <p class="p-2">Chúng ta luôn chú trọng lựa chọn thực phẩm sạch và duy trì lối sống lành mạnh. Vậy chế độ Eat clean nên và không nên ăn gì trong thực đơn hằng ngày để cân bằng tháp dinh dưỡng cho cơ thể?</p>
</template>