package com.blam.ventas.domain;



import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.*;

@Entity
public class Sale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String clientName;


    @Type(type = "date")
    private Date date;

    @OneToMany(mappedBy = "sale")
    //@OneToMany(cascade = CascadeType.ALL)
    private List<ProductSold> products = new ArrayList<>();

    private Double total;

    public Sale() {
    }

    public Sale(Long id, String clientName, Date date, List<ProductSold> products, Double total) {
        this.id = id;
        this.clientName = clientName;
        this.date = date;
        this.products = products;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ProductSold> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSold> products) {
        this.products = products;
    }

    public Double getTotal() {

        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", date=" + date +
                ", products=" + products +
                ", total=" + total +
                '}';
    }
}
