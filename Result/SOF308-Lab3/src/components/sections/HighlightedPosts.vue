<script>
import SpinachPostExpanded from '@/components/posts/SpinachPostExpanded.vue'
import OrangePostExpanded from '@/components/posts/OrangePostExpanded.vue';
import SesameOilPostExpanded from '@/components/posts/SesameOilPostExpanded.vue';

export default {
    components: {
        SpinachPostExpanded,
        OrangePostExpanded,
        SesameOilPostExpanded
    }
}
</script>

<template>
    <div class="p-2 bg-light">
        <h3 class="text-info">Bài viết nổi bật</h3>
    </div>
    <hr class="m-0">
        <SpinachPostExpanded />
        <OrangePostExpanded />
        <SesameOilPostExpanded />
</template>