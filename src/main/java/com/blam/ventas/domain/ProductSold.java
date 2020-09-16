package com.blam.ventas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProductSold implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sold_id")
    private Long id;

    @Column(name = "sold_name")
    private String name;

    @Column(name = "sold_price")
    private Double price;

    @Column(name = "sold_quantity")
    private Double quantity;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "sale_sold")
    private Sale  sale;

    private Double total;

    public ProductSold() {
    }

    public ProductSold(Long id, String name, Double price, Double quantity, Sale sale, Double total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sale= sale;
        this.total = total;
    }


    public void setTotal(Double total) {
        this.total = total;
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

    public Double getTotal(){
        return  total;

    }


    public Double Total(){
        this.total = this.quantity * this.price;
        return total;
    }

    @Override
    public String toString() {
        return "ProductSold{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", sale=" + sale +
                ", total=" + total +
                '}';
    }
}

