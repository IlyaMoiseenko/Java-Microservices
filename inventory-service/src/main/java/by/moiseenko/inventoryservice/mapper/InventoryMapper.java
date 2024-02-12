package by.moiseenko.inventoryservice.mapper;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.inventoryservice.domain.Inventory;
import by.moiseenko.inventoryservice.domain.dto.InventoryResponse;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {

    public InventoryResponse toResponse(Inventory inventory) {
        return InventoryResponse
                .builder()
                .skuCode(inventory.getSkuCode())
                .inStock(inventory.getQuantity() > 0)
                .build();
    }
}
