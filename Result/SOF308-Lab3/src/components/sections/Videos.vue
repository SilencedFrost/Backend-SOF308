<script>
import GoToGrowPost from '@/components/videoposts/GoToGrowPost.vue'
import YearEndTalkPost from '@/components/videoposts/YearEndTalkPost.vue'
import WishForChildhoodPost from '@/components/videoposts/WishForChildhoodPost.vue'
import ThreeGreatTeachersPost from '@/components/videoposts/ThreeGreatTeachersPost.vue'

export default {
    components: {
        GoToGrowPost,
        YearEndTalkPost,
        WishForChildhoodPost,
        ThreeGreatTeachersPost
    }
}
</script>

<template>
    <div class="text-center">
        <h2 class="text-info">VIDEO - ĐỪNG BỎ LỠ</h2>
    </div>
    <div class="container-fluid p-0">
    <div class="row g-2">
        <div class="col-6">
            <div class="card p-2 h-100">
                <GoToGrowPost />
            </div>
        </div>
        <div class="col-6">
            <div class="card p-2 h-100">
                <YearEndTalkPost />
            </div>
        </div>
    </div>
    <div class="row g-2 mt-0">
        <div class="col-6">
            <div class="card p-2 h-100">
                <WishForChildhoodPost />
            </div>
        </div>
        <div class="col-6">
            <div class="card p-2 h-100">
                <ThreeGreatTeachersPost />
            </div>
        </div>
    </div>
</div>
</template>