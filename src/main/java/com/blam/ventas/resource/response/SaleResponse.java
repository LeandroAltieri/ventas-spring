package com.blam.ventas.resource.response;

import com.blam.ventas.domain.Product;
import com.blam.ventas.domain.ProductSold;


import java.util.Date;
import java.util.List;

public class SaleResponse {

    private Long id;

    private String clientName;

    private Date date;

    private List<ProductSold> products;

    private Double saleTotal;

    public SaleResponse() {
    }

    public SaleResponse(Long id, String clientName, Date date, List<ProductSold> products, Double saleTotal) {
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

    public List<ProductSold> getProductsSold() {
        return products;
    }

    public void setProductSoldResponse(List<ProductSold> productsSold) {
        this.products = productsSold;
    }

    public Double getTotal() {

        return saleTotal;
    }

    public void setTotal(Double total) {
        this.saleTotal = total;
    }

    @Override
    public String toString() {
        return "SaleResponse{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", date=" + date +
                ", productResponses=" + products +
                ", saleTotal=" + saleTotal +
                '}';
    }
}
