<script>
import img1 from '@/assets/images/banner1.jpg'
import img2 from '@/assets/images/banner2.jpg'
import img3 from '@/assets/images/banner3.jpg'


export default {
    data() {
        return {
            items: [{
                title: '8 loại rau củ quả giàu canxi', 
                content: 'Canxi là..', 
                image: img1
                },
                {
                title: 'Các loại gia vị tốt cho sức khỏe', 
                content: 'Một sốt loại gia vị...', 
                image: img2
                },
                {
                title: '9 loại đậu bổ dưỡng nên dùng nhiều', 
                content: 'Đậy láng, đậu nành...', 
                image: img3
                }
            ]
        };
    }
};
</script>

<template>
    <h1 class="text-center">Kiến thức sức khỏe cộng đồng</h1>
    <div class="container-fluid px-3">
        <div class="row p-0 g-3">
            <div class="col-4" v-for="(item, index) in items" :key="index">
                <div class="card p-2 shadow-sm h-100">
                    <img :src="item.image" alt="" class="w-100">
                    <h3>{{ item.title }}</h3>
                    <p>{{ item.content }}</p>
                    <div class="d-flex mt-auto"><button class="btn btn-info">Xem thêm</button></div>
                </div>
            </div>
        </div>
    </div>
</template>