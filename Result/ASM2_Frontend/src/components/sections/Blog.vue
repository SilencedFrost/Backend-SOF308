<script>
import PilatesPost from '@/components/posts/PilatesPost.vue'
import CoreValuePost from '@/components/posts/CoreValuePost.vue'
import OrangePost from '@/components/posts/OrangePost.vue'
import SesameOilPost from '@/components/posts/SesameOilPost.vue'
import SpinachPost from '@/components/posts/SpinachPost.vue'

export default {
    components: {
        PilatesPost,
        CoreValuePost,
        OrangePost,
        SesameOilPost,
        SpinachPost
    }
}
</script>

<template>
    <h2 class="text-info">Blog của tôi</h2>
    <div class="container p-0">
        <section class="row g-2">
            <!-- First column -->
            <div class="col-6">
                <div class="card bg-white h-100">
                    <pilates-post />
                </div>
            </div>
            <!-- Second column -->
            <div class="col-6">
                <div class="card bg-white h-100">
                    <core-value-post />
                    <orange-post />
                    <sesame-oil-post />
                    <spinach-post />
                </div>
            </div>
        </section>
        <div class="p-2 text-center">
            <router-link to="/post">
                <button class="btn btn-info btn-sm p-1">Xem thêm</button>
            </router-link>
        </div>
    </div>
</template>