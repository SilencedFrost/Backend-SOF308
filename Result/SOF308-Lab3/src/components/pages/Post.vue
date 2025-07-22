<script>
import TopicList from '@/components/sections/TopicList.vue'
import Carousel from '@/components/sections/Carousel.vue'
import HighlightedPosts from '@/components/sections/HighlightedPosts.vue'
import AllPosts from '@/components/sections/AllPosts.vue'

export default {
    components: {
        Carousel,
        TopicList,
        HighlightedPosts,
        AllPosts
    }
}
</script>
<template>
    <div class="container-fluid p-2">
        <Carousel />
    </div>
    <div class="container-fluid p-2">
        <div class="row g-2 p-0">
            <div class="col-4">
                <div class="py-2"><TopicList /></div>
                <div class="card bg-white"><HighlightedPosts /></div>
            </div>
            <div class="col-8">
                <div class="py-2"><AllPosts /></div>
                <div class="py-2"></div>
            </div>
        </div>
    </div>
</template>