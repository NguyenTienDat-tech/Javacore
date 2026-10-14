package view;

import model.OrderModel;

import java.util.Scanner;

public class OrderView {
    private static final String nameShop = "ShopMini";
    private final Scanner scanner;


    public OrderView(Scanner scanner) {
        this.scanner = scanner;
    }

    public OrderModel inputOrder() {
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();

        System.out.print("Nhập đơn giá: ");
        long unitPrice = Long.parseLong(scanner.nextLine());

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        return new OrderModel(productName, unitPrice, quantity);
    }

    public void showError(String message) {
        System.out.println("Lỗi: " + message);
    }

    public void showInvoice(OrderModel orderModel, long tongPhu, long phiVanChuyen, long tong) {
        System.out.println();
        System.out.println("========== " + nameShop + " ==========");
        System.out.println("Sản phẩm: " + orderModel.getProductName());
        System.out.println("Đơn giá: " + orderModel.getUnitPrice() + " VND");
        System.out.println("Số lượng: " + orderModel.getQuantity());
        System.out.println("Tiền hàng: " + tongPhu + " VND");
        System.out.println("Phí giao hàng: " + phiVanChuyen + " VND");
        System.out.println("Tổng thanh toán: " + tong + " VND");
        System.out.println("==============================");
    }

}
