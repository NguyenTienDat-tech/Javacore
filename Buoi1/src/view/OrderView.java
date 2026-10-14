package view;

import config.OrderConfig;
import dto.request.CreateOrderRequest;
import dto.response.CreateOrderResponse;
import enums.PaymentMethod;
import util.CurrencyFormatter;

import java.util.List;
import java.util.Scanner;

public class OrderView {
    private final Scanner scanner;


    public OrderView(Scanner scanner) {
        this.scanner = scanner;
    }

    public CreateOrderRequest inputOrder() {
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();

        System.out.print("Nhập đơn giá: ");
        long unitPrice = Long.parseLong(scanner.nextLine());

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        PaymentMethod paymentMethod = inputPaymentMethod();

        return new CreateOrderRequest(productName, unitPrice, quantity, paymentMethod);
    }

    public void showError(String message) {
        System.out.println("Lỗi: " + message);
    }

    public void showInvoice(CreateOrderResponse orderResponse) {
        System.out.println();
        System.out.println("========== " + OrderConfig.nameShop + " ==========");
        System.out.println("Sản phẩm: " + orderResponse.getProductName());
        System.out.println("Đơn giá: " + CurrencyFormatter.format(orderResponse.getUnitPrice()));
        System.out.println("Số lượng: " + orderResponse.getQuantity());
        System.out.println("Tiền hàng: " + CurrencyFormatter.format(orderResponse.getTongPhu()));
        System.out.println("Phí giao hàng: " + CurrencyFormatter.format(orderResponse.getPhiVanChuyen()));
        System.out.println("Tổng thanh toán: " + CurrencyFormatter.format(orderResponse.getTotal()));
        System.out.println("Thanh toán: " + getPaymentMethodLabel(orderResponse.getPaymentMethod()));
        System.out.println("==============================");
    }

    public PaymentMethod inputPaymentMethod() {
        while (true) {
            System.out.println("Chọn phương thức thanh toán:");
            System.out.println("1. Chuyển khoản");
            System.out.println("2. Tiền mặt");
            System.out.print("Lựa chọn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    return PaymentMethod.THE;

                case "2":
                    return PaymentMethod.TIEN_MAT;

                default:
                    showError("Vui lòng chọn 1 hoặc 2.");
            }
        }
    }

    private String getPaymentMethodLabel(PaymentMethod paymentMethod) {
        switch (paymentMethod) {
            case THE:
                return "Chuyển khoản";

            case TIEN_MAT:
                return "Tiền mặt";

            default:
                throw new IllegalArgumentException(
                        "Phương thức thanh toán chưa được hỗ trợ."
                );
        }
    }

    public void showOrderHistory(List<CreateOrderResponse> orders) {
        System.out.println();
        System.out.println("========== LỊCH SỬ HÓA ĐƠN ==========");

        if (orders.isEmpty()) {
            System.out.println("Chưa có hóa đơn nào.");
            return;
        }

        for (CreateOrderResponse order : orders) {
            showInvoice(order);
        }
    }

}
