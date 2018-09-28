package br.com.caelum.microservice.domain.repositories;

import br.com.caelum.microservice.domain.models.Product;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends Repository<Product, Long> {
    void save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);
}
