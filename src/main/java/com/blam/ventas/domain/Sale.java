package com.blam.ventas.domain;




import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.Serializable;

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
    private List<ProductSold> products;

    private Double saleTotal;

    public Sale() {
    }



    public Sale(Long id, String clientName, Date date, List<ProductSold> products, Double saleTotal) {
        this.id = id;
        this.clientName = clientName;
        this.date = date;
        this.products = products;
        this.saleTotal = saleTotal;
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

        return saleTotal;
    }


    public void setTotal(Double total) {
        this.saleTotal = total;
    }

    public Double productsTotal( List<ProductSold> list) {
        Double productsTotal = 0.0;
        for (ProductSold p : list) {
            productsTotal += p.getTotal();
        }
        System.out.println("lo hago? o soy politico?" + productsTotal);
        return productsTotal;
    }
    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", date=" + date +
                ", products=" + products +
                ", saleTotal=" + saleTotal +
                '}';
    }
}
