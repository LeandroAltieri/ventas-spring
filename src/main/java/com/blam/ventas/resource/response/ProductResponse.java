package com.blam.ventas.resource.response;

public class ProductResponse {

    private Long id;

    private String name;

    private Double price;

    private Double quantity;

    private Double total;

    public ProductResponse() {
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ProductResponse(Long id, String name, Double price, Double total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.total = total;
    }

    public ProductResponse(String name, Double price) {
        this.name = name;
        this.price = price;
    }
/*
    public ProductResponse(Long id, String name, Double price, Double quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
*/
   /* public ProductResponse(String name, Double price, Double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }*/

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

    public Double Total(){
        this.total = this.quantity * this.price;
        return this.total;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
