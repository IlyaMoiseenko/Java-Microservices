package by.moiseenko.inventoryservice.controller;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.inventoryservice.domain.Inventory;
import by.moiseenko.inventoryservice.domain.dto.InventoryResponse;
import by.moiseenko.inventoryservice.mapper.InventoryMapper;
import by.moiseenko.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    private final InventoryMapper inventoryMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodes) {
        List<Inventory> inStock = inventoryService.isInStock(skuCodes);

        return inStock
                .stream()
                .map(inventoryMapper::toResponse)
                .toList();
    }
}
