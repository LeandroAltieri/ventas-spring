package com.blam.ventas.resource.request;

import com.blam.ventas.domain.Sale;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductSoldRequest {
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("quantity")
    private Double quantity;

    @JsonCreator
    public ProductSoldRequest() {
    }

    @JsonCreator
    public ProductSoldRequest(@JsonProperty("name") String name, @JsonProperty("quantity") Double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @JsonCreator
    public ProductSoldRequest(@JsonProperty("name") String name) {
        this.name = name;
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
