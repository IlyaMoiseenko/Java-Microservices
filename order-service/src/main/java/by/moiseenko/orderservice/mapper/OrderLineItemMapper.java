package by.moiseenko.orderservice.mapper;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.orderservice.domain.OrderLineItem;
import by.moiseenko.orderservice.domain.dto.OrderLineItemRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderLineItemMapper {

    public OrderLineItem toDomain(OrderLineItemRequest request) {
        return OrderLineItem
                .builder()
                .price(request.getPrice())
                .skuCode(request.getSkuCode())
                .quantity(request.getQuantity())
                .build();
    }

    public OrderLineItemRequest toRequest(OrderLineItem orderLineItem) {
        return OrderLineItemRequest
                .builder()
                .price(orderLineItem.getPrice())
                .skuCode(orderLineItem.getSkuCode())
                .quantity(orderLineItem.getQuantity())
                .build();
    }
}
