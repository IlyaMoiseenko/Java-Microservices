package by.moiseenko.orderservice.service;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.orderservice.domain.Order;
import by.moiseenko.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        order.setOrderNumber(UUID.randomUUID().toString());

        return orderRepository.save(order);
    }
}
