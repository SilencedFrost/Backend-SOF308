<script>
import CoreValuePost from '@/components/posts/CoreValuePost.vue'
import SesameOilPost from '@/components/posts/SesameOilPost.vue'
import SpinachPost from '@/components/posts/SpinachPost.vue'

export default {
    
    components: {
        CoreValuePost,
        SesameOilPost,
        SpinachPost
    }
}
</script>

<template>
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active text-info" data-bs-toggle="tab" href="#Read"><b>Đọc nhiều</b></a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-info" data-bs-toggle="tab" href="#Watch"><b>Xem nhiều</b></a>
        </li>
    </ul>
    <div class="tab-content">
        <div id="Read" class="tab-pane active">
            <CoreValuePost />
            <SesameOilPost />
            <SpinachPost />
        </div>
        <div id="Watch" class="tab-pane">
            <SesameOilPost />
            <SpinachPost />
            <CoreValuePost />
        </div>
    </div>
</template>