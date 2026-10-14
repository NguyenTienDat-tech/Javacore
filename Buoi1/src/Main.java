import controller.OrderController;
import repository.OrderRepository;
import service.OrderService;
import view.OrderView;

import java.util.Scanner;

/*
1. Đề bài
ShopMini cần một chương trình tính tiền cho đơn hàng có một loại sản phẩm.
Chương trình phải:
- Nhập tên sản phẩm, đơn giá và số lượng.
- Đơn giá dùng long, số lượng dùng int; tiền tính theo VND.
- Nếu đơn giá hoặc số lượng không lớn hơn 0, báo lỗi và dừng chương trình.
- Nếu tiền hàng từ 500000 VND trở lên, miễn phí giao hàng; dưới mức đó, phí giao hàng là 30000 VND.
- In hóa đơn gồm tên shop, tên sản phẩm, đơn giá, số lượng, tiền hàng, phí giao hàng và tổng thanh toán.
Ví dụ:
Nhập tên sản phẩm: Áo thun
Nhập đơn giá (VND): 120000
Nhập số lượng: 2

========== SHOPMINI ==========
Sản phẩm: Áo thun
Đơn giá: 120000 VND
Số lượng: 2
Tiền hàng: 240000 VND
Phí giao hàng: 30000 VND
Tổng thanh toán: 270000 VND
==============================
*/
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            OrderRepository repository = new OrderRepository();


            OrderView view = new OrderView(scanner);
            OrderService service = new OrderService(repository);


            OrderController controller = new OrderController(view, service);
            controller.run();


            controller.showHistory();
        }
    }
}