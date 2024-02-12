package by.moiseenko.orderservice.repository;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.orderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
