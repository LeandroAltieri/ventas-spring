package com.blam.ventas.resource.response;

import com.blam.ventas.domain.Sale;

public class ProductSoldResponse {

    private Long id;

    private String name;

    private Double price;

    private Double quantity;

    private Sale sale;

    public ProductSoldResponse() {
    }

    public ProductSoldResponse(String name, Double price, Double quantity, Sale sale) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sale = sale;
    }

    public ProductSoldResponse(Long id, String name, Double price, Double quantity, Sale sale) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sale = sale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
