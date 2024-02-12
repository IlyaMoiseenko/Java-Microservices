package by.moiseenko.orderservice.contoller;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.orderservice.domain.Order;
import by.moiseenko.orderservice.domain.dto.OrderRequest;
import by.moiseenko.orderservice.mapper.OrderMapper;
import by.moiseenko.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createNew(@RequestBody OrderRequest request) {
        Order order = orderMapper.toDomain(request);

        return orderService.placeOrder(order);
    }
}
