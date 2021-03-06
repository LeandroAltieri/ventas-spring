package com.blam.ventas.resource.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductRequest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("quantity")
    private Double quantity;

    @JsonCreator
    public ProductRequest(@JsonProperty("id") Long id,
                          @JsonProperty("name") String name,
                          @JsonProperty("price") Double price,
                          @JsonProperty("quantity") Double quantity)
                          {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

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
}
