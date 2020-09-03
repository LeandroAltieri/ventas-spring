package com.blam.ventas.resource.request;

import com.blam.ventas.domain.ProductSold;
import com.blam.ventas.resource.response.ProductResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
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
        private List<ProductSold> productsSold;

        @JsonProperty("total")
        private Double total;

        @JsonCreator
        public SaleRequest(@JsonProperty("id") Long id,
                            @JsonProperty("clientName") String clientName,
                            @JsonProperty("date") Date date,
                            @JsonProperty("products") List<ProductSold> productsSold,
                            @JsonProperty("total") Double total) {
            this.id = id;
            this.clientName = clientName;
            this.date = date;
            this.productsSold = productsSold;
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

        public List<ProductSold> getProductsSold() {
            return productsSold;
        }

        public void setProductsSold(List<ProductSold> productsSold) {
            this.productsSold = productsSold;
        }

        public Double getTotal() {
            return total;
        }

        public void setTotal(Double total) {
            this.total = total;
        }

        @Override
        public String toString() {
            return "SaleResponse{" +
                    "id=" + id +
                    ", clientName='" + clientName + '\'' +
                    ", date=" + date +
                    ", productResponses=" + productsSold +
                    ", total=" + total +
                    '}';
        }
    }
