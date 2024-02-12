package by.moiseenko.productservice.service;

/*
    @author Ilya Moiseenko on 12.02.24
*/

import by.moiseenko.productservice.domain.Product;
import by.moiseenko.productservice.exception.EntityNotFoundException;
import by.moiseenko.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product was not found"));
    }

    public Product createNewProduct(Product product) {
        return productRepository.save(product);
    }
}
