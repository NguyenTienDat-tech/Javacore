package service;

import config.OrderConfig;
import dto.request.CreateOrderRequest;
import dto.response.CreateOrderResponse;
import exception.ValidationException;
import repository.OrderRepository;

import java.util.List;

public class OrderService {
    private final OrderRepository repository;


    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        validation(request);

        long tongPhu = tinhTongPhu(request);
        long phiVanChuyen = tinhPhiVanChuyen(tongPhu);
        long total = tinhTong(tongPhu, phiVanChuyen);

        CreateOrderResponse response = new CreateOrderResponse(
                request.getProductName().trim(),
                request.getUnitPrice(),
                request.getQuantity(),
                request.getPaymentMethod(),
                tongPhu,
                phiVanChuyen,
                total
        );

        repository.save(response);

        return response;
    }

    public void  validation(CreateOrderRequest request) {
        if (request.getProductName() == null || request.getProductName().trim().isEmpty()) {
            throw new ValidationException("Tên sản phẩm không được để trống");
        }
        if (request.getUnitPrice() <= 0) {
            throw new ValidationException("Đơn giá phải lớn hơn 0.");
        }
        if (request.getQuantity() <= 0) {
            throw new ValidationException("Số lượng phải lớn hơn 0.");
        }

        if (request.getPaymentMethod() == null) {
            throw new ValidationException("Phải chọn phương thức thanh toán.");
        }
    }

    public long tinhTongPhu(CreateOrderRequest orderRequest) {
        return orderRequest.getUnitPrice() * orderRequest.getQuantity();
    }

    public long tinhPhiVanChuyen(long tongPhu) {
        if (tongPhu >= OrderConfig.NGUONG_MIEN_PHI_VAN_CHUYEN) {
            return 0;
        }

        return OrderConfig.PHI_VAN_CHUYEN_TIEU_CHUAN;
    }

    public long tinhTong(long tongPhu, long phiVanChuyen) {
        return tongPhu + phiVanChuyen;
    }

    public List<CreateOrderResponse> getAllOrders() {
        return repository.findAll();
    }
}
