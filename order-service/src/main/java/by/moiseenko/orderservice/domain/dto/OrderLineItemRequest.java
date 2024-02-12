package by.moiseenko.orderservice.domain.dto;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItemRequest {

    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
