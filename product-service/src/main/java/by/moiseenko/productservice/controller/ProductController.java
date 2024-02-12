package by.moiseenko.productservice.controller;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.productservice.domain.Product;
import by.moiseenko.productservice.domain.dto.ProductRequest;
import by.moiseenko.productservice.domain.dto.ProductResponse;
import by.moiseenko.productservice.mapper.ProductMapper;
import by.moiseenko.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createNew(@RequestBody ProductRequest request) {
        Product product = productMapper.toDomain(request);

        return productService.createNewProduct(product);
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable("id") String id) {
        return productMapper.toResponse(
                productService.getById(id)
        );
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        List<Product> allProducts = productService.getAll();

        return allProducts
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }
}
