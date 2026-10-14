package service;

import model.OrderModel;

public class OrderService {
    private static final long NGUONG_MIEN_PHI_VAN_CHUYEN = 500000;
    private static final long PHI_VAN_CHUYEN_TIEU_CHUAN = 30000;


    public boolean hopLe(OrderModel orderModel) {
        return orderModel.getUnitPrice() > 0 && orderModel.getQuantity() > 0;
    }

    public long tinhTongPhu(OrderModel orderModel) {
        return orderModel.getUnitPrice() * orderModel.getQuantity();
    }

    public long tinhPhiVanChuyen(long tongPhu) {
        if (tongPhu >= NGUONG_MIEN_PHI_VAN_CHUYEN) {
            return 0;
        }

        return PHI_VAN_CHUYEN_TIEU_CHUAN;
    }

    public long tinhTong(long tongPhu, long phiVanChuyen) {
        return tongPhu + phiVanChuyen;
    }
}
