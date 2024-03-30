package com.AgroMarketHub.dto;

import java.util.Date;

public class FarmProductsDTO {
    private String productName;
    private String productDesc;
    private int quantity;
    private float unitPrice;
    private int unit;
    private Date availableDate;
    private String prodtStatus;
    private String status;

    public FarmProductsDTO() {
    }

    public FarmProductsDTO(String productName, String product_desc, int quantity, float unitPrice, int unit, Date availableDate, String prodtStatus) {
        this.productName = productName;
        this.productDesc = product_desc;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.availableDate = availableDate;
        this.prodtStatus = prodtStatus;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setStatus() {
        this.status = "message.status";
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProduct_desc() {
        return productDesc;
    }

    public void setProduct_desc(String product_desc) {
        this.productDesc = product_desc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    public String getProdtStatus() {
        return prodtStatus;
    }

    public void setProdtStatus(String prodtStatus) {
        this.prodtStatus = prodtStatus;
    }
}
