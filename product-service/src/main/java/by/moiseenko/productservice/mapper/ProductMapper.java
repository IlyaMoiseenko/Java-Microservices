package by.moiseenko.productservice.mapper;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.productservice.domain.Product;
import by.moiseenko.productservice.domain.dto.ProductRequest;
import by.moiseenko.productservice.domain.dto.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toDomain(ProductRequest request) {
        return Product
                .builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }

    public ProductResponse toResponse(Product product) {
        return ProductResponse
                .builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
