<script>
import corevalue from '@/assets/images/corevalue.jpg'

export default {
    data() {
        return {
            corevalue
        }
    }
}
</script>

<template>
    <div class="row p-2">
        <div class="col-4">
            <img class="img-fluid ratio ratio-1x1" :src="corevalue" alt="">
        </div>
        <div class="col-8">
            <b>Biết ơn đời, đời sẽ thương ta</b><br>
            <img src="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/icons/chat-left.svg" alt="comments" width="20" height="20" class="me-1">
            16
        </div>
    </div>
</template>