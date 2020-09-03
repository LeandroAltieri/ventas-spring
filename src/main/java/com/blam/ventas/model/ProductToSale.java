package com.blam.ventas.model;

import com.blam.ventas.resource.response.ProductResponse;

public class ProductToSale extends ProductResponse {

    private Double quantity;

    public ProductToSale() {
    }

    public ProductToSale(Long id, String name, Double price, Double quantity) {
        super(id, name, price);
        this.quantity = quantity;

    }

    public ProductToSale(String name, Double price, Double quantity) {
        super(name, price);
        this.quantity = quantity;

    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotal(){
        return this.getPrice() * this.quantity;
    }
}
