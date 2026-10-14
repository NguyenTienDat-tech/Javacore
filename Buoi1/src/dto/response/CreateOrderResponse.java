package dto.response;

import enums.PaymentMethod;

public class CreateOrderResponse {
    private final String productName;
    private final long unitPrice;
    private final int quantity;
    private final PaymentMethod paymentMethod;
    private final long tongPhu;
    private final long phiVanChuyen;
    private final long total;

    public CreateOrderResponse(String productName, long unitPrice, int quantity, PaymentMethod paymentMethod, long tongPhu, long phiVanChuyen, long total) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
        this.tongPhu = tongPhu;
        this.phiVanChuyen = phiVanChuyen;
        this.total = total;
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

    public long getTongPhu() {
        return tongPhu;
    }

    public long getPhiVanChuyen() {
        return phiVanChuyen;
    }

    public long getTotal() {
        return total;
    }
}
