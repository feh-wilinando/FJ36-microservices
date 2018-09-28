package br.com.caelum.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class StockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal quantity;


    /**
     * @deprecated frameworks only
     */
    @Deprecated
    StockItem() { }

    public StockItem(String code, BigDecimal quantity) {
        this.code = code;
        this.quantity = quantity;
    }


    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
