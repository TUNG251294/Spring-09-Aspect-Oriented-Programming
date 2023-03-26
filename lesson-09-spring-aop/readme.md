# Notes:
- Chương trình này có 2 PointCut được cấu hình ở package aspect và logger theo 2 phong cách khác nhau
- Bài này chỉ handle exception bằng cách ghi log để quan sát ngoại lệ, giúp tracking log trên production
- Bài sau sẽ handle exception bằng cách đẩy sang trang error
- Chương trình sẽ xảy ra lỗi vì hiện tại ở lớp CustomerService đang có giả lập 1 exception với message: a dummy exception
- Muốn bỏ qua lỗi trên, comment dòng code quăng lỗi trong hàm findAll đi