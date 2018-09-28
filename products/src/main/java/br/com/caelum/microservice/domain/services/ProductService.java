package br.com.caelum.microservice.domain.services;

import br.com.caelum.microservice.domain.dtos.ProductDTO;
import br.com.caelum.microservice.domain.dtos.StockDTO;
import br.com.caelum.microservice.domain.models.Product;
import br.com.caelum.microservice.domain.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private RestTemplate rest = new RestTemplate();


    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public List<ProductDTO> findAll(){
        return repository.findAll().stream().map(this::mapping)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> findById(Long id){
        return repository.findById(id).map(this::mapping);
    }

    private ProductDTO mapping(Product product){
        String stockCode = product.getStockCode();

        StockDTO stock = rest.getForObject("http://localhost:8090/stock/{id}",
                                            StockDTO.class, stockCode);

        return ProductDTO.buildFrom(product, stock);

    }
}
