package by.moiseenko.orderservice.mapper;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.orderservice.domain.Order;
import by.moiseenko.orderservice.domain.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderLineItemMapper orderLineItemMapper;

    public Order toDomain(OrderRequest request) {
        return Order
                .builder()
                .orderLineItems(request.getOrderLineItemRequestList().stream().map(orderLineItemMapper::toDomain).toList())
                .build();
    }
}
