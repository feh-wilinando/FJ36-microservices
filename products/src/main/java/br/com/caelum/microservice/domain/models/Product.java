package br.com.caelum.microservice.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String stockCode;


    /**
     * @deprecated frameworks only
     */
    @Deprecated
    Product() { }

    public Product(String name, String description, BigDecimal price, String stockCode) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockCode = stockCode;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getStockCode() {
        return stockCode;
    }
}
