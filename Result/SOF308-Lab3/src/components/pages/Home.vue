<script>
import Carousel from '@/components/sections/Carousel.vue'
import About from '@/components/sections/About.vue'
import Blog from '@/components/sections/Blog.vue'
import Frequent from '@/components/sections/Frequent.vue'
import Videos from '@/components/sections/Videos.vue'

export default{
    components: {
        Carousel,
        About,
        Blog,
        Frequent,
        Videos
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
                <div class="py-2"><About /></div>
                <div class="py-2"><Frequent /></div>
            </div>
            <div class="col-8">
                <div class="py-2"><Blog /></div>
                <div class="py-2"><videos /></div>
            </div>
        </div>
    </div>
</template>