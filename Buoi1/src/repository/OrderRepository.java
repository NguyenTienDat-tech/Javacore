package repository;

import dto.response.CreateOrderResponse;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private final List<CreateOrderResponse> orderResponseList = new ArrayList<>();

    public void save(CreateOrderResponse orderResponse) {
        orderResponseList.add(orderResponse);
    }

    public List<CreateOrderResponse> findAll() {
        return new ArrayList<>(orderResponseList);
    }
}
