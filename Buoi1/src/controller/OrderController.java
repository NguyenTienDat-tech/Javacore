package controller;

import model.OrderModel;
import service.OrderService;
import view.OrderView;

public class OrderController {
    private final OrderView view;
    private final OrderService service;

    public OrderController(OrderView view, OrderService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        OrderModel orderModel = view.inputOrder();

        if (!service.hopLe(orderModel)) {
            view.showError("Đơn giá và số lượng phải lớn hơn 0.");
            return;
        }

        long tongPhu = service.tinhTongPhu(orderModel);
        long phiVanChuyen = service.tinhPhiVanChuyen(tongPhu);
        long tong = service.tinhTong(tongPhu, phiVanChuyen);


        view.showInvoice(orderModel, tongPhu, phiVanChuyen, tong);
    }
}
