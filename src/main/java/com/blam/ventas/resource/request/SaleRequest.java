package com.blam.ventas.resource.request;

import com.blam.ventas.domain.ProductSold;

import com.blam.ventas.resource.response.ProductSoldResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Date;
import java.util.List;

public class SaleRequest {

        @JsonProperty("id")
        private Long id;

        @JsonProperty("clientName")
        private String clientName;

        @JsonProperty("date")
        private Date date;

        @JsonProperty("products")
        private List<ProductSold> products;

        @JsonProperty("saleTotal")
        private Double saleTotal;

        @JsonCreator
        public SaleRequest(@JsonProperty("id") Long id,
                            @JsonProperty("clientName") String clientName,
                            @JsonProperty("date") Date date,
                            @JsonProperty("products") List<ProductSold> products,
                            @JsonProperty("saleTotal") Double saleTotal) {
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

        public void setProductsSold(List<ProductSold> productsSold) {
            this.products = productsSold;
        }

        public void setTotal(Double total) {
        this.saleTotal = saleTotal;
    }


         public Double getTotal() {
            return saleTotal;
         }

         public Double productsTotal( List<ProductSold> list) {
          Double productsTotal = 0.0;
         for (ProductSold p : list) {
            productsTotal += p.getTotal();
        }
        return productsTotal;
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
