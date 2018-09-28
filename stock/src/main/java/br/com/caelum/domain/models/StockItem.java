package br.com.caelum.domain.models;

import java.math.BigDecimal;

public class StockItem {
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
