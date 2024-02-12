package by.moiseenko.productservice.repository;

import by.moiseenko.productservice.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
    @author Ilya Moiseenko on 12.02.24
*/

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
