package br.com.caelum.microservice.application.controllers;

import br.com.caelum.microservice.domain.dtos.ProductDTO;
import br.com.caelum.microservice.domain.models.Product;
import br.com.caelum.microservice.domain.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Api(description = "Api for products", tags = "Products")
@RestController
@RequestMapping("products")
public class ProductController {


    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all products value", notes = "Get all products")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> all() {
        return service.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> getById(@PathVariable("id") Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.noContent()::build);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> save(@RequestBody Product product){

        URI location = URI.create("/products/2");

        return ResponseEntity.created(location).body(product);
    }

}
