package by.moiseenko.orderservice.service;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.orderservice.domain.Order;
import by.moiseenko.orderservice.domain.OrderLineItem;
import by.moiseenko.orderservice.domain.dto.InventoryResponse;
import by.moiseenko.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public Order placeOrder(Order order) {
        order.setOrderNumber(UUID.randomUUID().toString());

        if (isInStock(order.getOrderLineItems()))
            return orderRepository.save(order);

        throw  new IllegalArgumentException("Product isn't in stock. Try again later");
    }

    private boolean isInStock(List<OrderLineItem> items) {
        List<String> skuCodes = items
                .stream()
                .map(OrderLineItem::getSkuCode)
                .toList();

        InventoryResponse[] inventoryResponses = webClientBuilder.build()
                .get()
                .uri("http://inventory-service/api/v1/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        return Arrays
                .stream(inventoryResponses)
                .allMatch(InventoryResponse::isInStock);
    }
}
