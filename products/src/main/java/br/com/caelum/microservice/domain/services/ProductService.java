package br.com.caelum.microservice.domain.services;

import br.com.caelum.microservice.domain.dtos.ProductDTO;
import br.com.caelum.microservice.domain.dtos.StockDTO;
import br.com.caelum.microservice.domain.models.Product;
import br.com.caelum.microservice.domain.repositories.ProductRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final LoadBalancerClient discoveryClient;
    private RestTemplate rest = new RestTemplate();


    public ProductService(ProductRepository repository, LoadBalancerClient discoveryClient) {
        this.repository = repository;
        this.discoveryClient = discoveryClient;
    }


    @HystrixCommand(fallbackMethod = "findAllFallback")
    public List<ProductDTO> findAll(){

        System.out.println(discoveryClient.choose("STOCK").getUri());

        return repository.findAll().stream().map(this::mapping)
                .collect(Collectors.toList());
    }

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public Optional<ProductDTO> findById(Long id){
        return repository.findById(id).map(this::mapping);
    }

    private ProductDTO mapping(Product product){
        String stockCode = product.getStockCode();

        ServiceInstance stockInstance = discoveryClient.choose("STOCK");

        String hostName = stockInstance.getUri().toString();

        System.out.println();
        System.out.println(hostName);
        System.out.println();

        StockDTO stock = rest.getForObject(hostName + "/stock/{id}",
                                            StockDTO.class, stockCode);

        return ProductDTO.buildFrom(product, stock);

    }


    public List<ProductDTO> findAllFallback(){
        return repository.findAll().stream().map(this::mappingFallback)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> findByIdFallback(Long id){
        return repository.findById(id).map(this::mappingFallback);
    }

    private ProductDTO mappingFallback(Product product) {
        StockDTO stock = new StockDTO();
        stock.setQuantity(BigDecimal.ZERO);

        return ProductDTO.buildFrom(product, stock);
    }
}
