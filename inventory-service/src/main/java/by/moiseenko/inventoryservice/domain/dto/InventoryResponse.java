package by.moiseenko.inventoryservice.domain.dto;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponse {

    private String skuCode;
    private boolean inStock;
}
