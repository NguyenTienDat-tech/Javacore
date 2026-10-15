package controller;

import dto.request.CreateOrderRequest;
import dto.response.CreateOrderResponse;
import exception.ValidationException;
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
        while (true) {
            String choice = view.inputMenu();

            switch (choice) {
                case "1":
                    createOther();
                    break;

                case "2":
                    showHistory();
                    break;

                case "0":
                    view.showError("Đã thoát ShopMini.");
                    return;

                default:
                    view.showError("Vui lòng chọn 0, 1 hoặc 2.");
            }
        }
    }

    public void createOther() {
        try {
            CreateOrderRequest request = view.inputOrder();
            CreateOrderResponse response = service.createOrder(request);

            view.showInvoice(response);
        }
        catch (ValidationException e) {
            view.showError(e.getMessage());
        }
    }

    public void showHistory() {
        view.showOrderHistory(service.getAllOrders());
    }
}
