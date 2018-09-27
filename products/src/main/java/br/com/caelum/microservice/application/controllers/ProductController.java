package br.com.caelum.microservice.application.controllers;

import br.com.caelum.microservice.domain.models.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> all() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getById(@PathVariable("id") Long id) {
        return new Product("T-Shirt", "The beautiful black t-shirt", BigDecimal.TEN);
    }

}
