package dto.request;

import enums.PaymentMethod;

public class CreateOrderRequest {
    private final String productName;
    private final long unitPrice;
    private final int quantity;
    private final PaymentMethod paymentMethod;


    public CreateOrderRequest(String productName, long unitPrice, int quantity, PaymentMethod paymentMethod) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
    }

    public String getProductName() {
        return productName;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
