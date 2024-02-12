package by.moiseenko.inventoryservice.service;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.inventoryservice.domain.Inventory;
import by.moiseenko.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        Optional<Inventory> bySkuCode = inventoryRepository.findBySkuCode(skuCode);

        return bySkuCode.isPresent();
    }
}
