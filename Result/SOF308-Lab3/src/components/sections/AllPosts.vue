<script>
import PilatesPost from '@/components/posts/PilatesPost.vue'
import PilatesPost2 from '@/components/posts/PilatesPost2.vue'
import PilatesPost3 from '@/components/posts/PilatesPost3.vue'
import EatClean from '@/components/posts/EatClean.vue'

export default {
    components: {
        PilatesPost,
        PilatesPost2,
        PilatesPost3,
        EatClean
    }
}
</script>

<template>
    <div class="container-fluid p-0">
        <h2 class="text-info">Tất cả bài viết</h2>
        <router-link to="/post/detail" class="text-decoration-none">
        <div class="row g-2">
            <div class="col-6">
                <div class="card h-100"><PilatesPost /></div>
            </div>
            <div class="col-6">
                <div class="card h-100"><PilatesPost2 /></div>
            </div>
        </div>
        <div class="row g-2 mt-0">
            <div class="col-6">
                <div class="card h-100"><PilatesPost3 /></div>
            </div>
            <div class="col-6">
                <div class="card h-100"><EatClean /></div>
            </div>
        </div>
        <div class="container-fluid text-center p-2">
            <div class="btn-group" role="group" aria-label="Pagination">
                <button type="button" class="btn btn-outline-primary">
                    <i class="bi bi-chevron-left"></i>
                    ←
                </button>
                <button type="button" class="btn btn-primary">1</button>
                <button type="button" class="btn btn-outline-primary">2</button>
                <button type="button" class="btn btn-outline-primary">3</button>
                <button type="button" class="btn btn-outline-primary">
                    →
                    <i class="bi bi-chevron-right"></i>
                </button>
            </div>
        </div>
        </router-link>
    </div>
</template>