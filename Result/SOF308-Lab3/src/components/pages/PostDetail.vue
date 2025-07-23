<script>
import pilates from '@/assets/images/tap-piltes.jpg'
import pilates1 from '@/assets/images/tap-pilates1.jpg'

export default {
    data() {
        return {
            pilates,
            pilates1
        }
    }
}
</script>
<template>
    <br>
    <div class="container-fluid px-5">
        <div class="row g-4 p-0">
            <div class="col-8">
                <div class="text-center text-info">
                    <h3>
                        Phương pháp tập Pilates giúp phục hồi chấn thương cột sống
                    </h3>
                </div>
                <img class="w-100" :src="pilates1" alt="">
                <p>Tập Pilates có thể vẫn còn khá xa lạ với người Việt, nhưng tại các nước phương Tây thì đây chính là phương pháp tập thể dục giúp duy trì vóc dáng, tăng cường ý chí và cải thiện sự linh hoạt, dẻo dai cho người tập. Đặc biệt, các bài tập Pilates còn có khả năng trị đau lưng, là giải pháp hữu hiệu để phục hồi chấn thương cột sống. Sau đây hãy cùng tìm hiểu các phương pháp tập luyện này giúp phục hồi chấn thương cột sống nhanh chóng nhé!</p>
                <h5>Pilates giúp phục hồi chấn thương cột sống nhanh chóng</h5>
                <p>Một trong những căn bệnh ngày càng phổ biến, đặc biệt là dân văn phòng, đó là đau lưng, thoát vị đĩa đệm. Tuy nhiên, nếu điều trị không đúng cách có thể dẫn đến nhiều biến chứng nguy hiểm, bao gồm: Ví dụ, điều trị bằng laser không đúng cách hoặc tập yoga không đúng cách có thể khiến bệnh nhân nằm liệt giường.</p>
                <img class="w-100" :src="pilates" alt="">
                <h5>Phương pháp tập Pilates Cat Cow</h5>
                Các bước thực hiện:
                <ul>
                    <li>Bắt đầu với tư thế 4 điểm. Vai và cổ tay của bạn phải thẳng hàng và vuông góc với thảm, lưng của bạn phải bằng phẳng và xuóng chậu của bạn phải cân đối.</li>
                    <li>Hít vào, võng lưng, nâng cằm lên, mở rộng ngực.</li>
                    <li>Thở ra, cong xương cụt, nâng cong lưng và đưa cằm về gần khoang ngực</li>
                    <li>Lặp đi lặp lại động tác từ 5-7 lần</li>
                </ul>
                <h5>Lời kết</h5>
                <p>Trên đây là phương pháp tập Pilates giúp phục hồi chấn thương cột sống nhanh chóng. Để đạt được kết quả tập luyện như mong muốn, bạn cần duy trì chế độ tập luyện đều đặn, thực hiện đúng động tác, kết hợp cùng chế độ ăn uống khoa học.</p>
            </div>
            <div class="col-4 mt-0">
                <h5>Bình luận bài viết tại đây</h5>
                <textarea class="w-100" id="" placeholder="Nhập bình luận của bạn"></textarea>
                <button class="btn btn-success">Gửi bình luận</button>
                <h5>Danh sách các bình luận:</h5>
                <ul>
                    <li><b>Bình An: </b>Bài viết rất hữu ích</li>
                    <li><b>Bình An: </b>Cảm ơn những chia sẻ bổ ích</li>
                </ul>
            </div>
        </div>
    </div>
</template>