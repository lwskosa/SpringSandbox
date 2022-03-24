package com.techb.lajoskosa.sandbox;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    // 1:09:43 - how to make it display something else
    @JsonProperty("productNAME")
    private String productName;
    @JsonProperty("productCOST")
    private Double productPrice;
    private int itemCount;

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }


    public Product(String productName, Double productPrice, int itemCount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.itemCount = itemCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getSubTotal(){
        return itemCount * productPrice;
    }




}
