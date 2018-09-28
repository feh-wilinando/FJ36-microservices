package br.com.caelum.microservice.application.controllers;

import br.com.caelum.microservice.domain.models.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Api(description = "Api for products", tags = "Products")
@RestController
@RequestMapping(value = "products")
public class ProductController {

    @ApiOperation(value = "Get all products value", notes = "Get all products")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> all() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getById(@PathVariable("id") Long id) {
        return new Product("T-Shirt", "The beautiful black t-shirt", BigDecimal.TEN);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> save(@RequestBody Product product){

        URI location = URI.create("/products/2");

        return ResponseEntity.created(location).body(product);
    }

}
