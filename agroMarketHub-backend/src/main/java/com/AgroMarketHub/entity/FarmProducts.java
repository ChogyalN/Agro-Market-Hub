package com.AgroMarketHub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class FarmProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private String productDesc;
    private int quantity;
    private float unitPrice;
    private int unit;
    private Date availableDate;
    private String prodtStatus;

    public FarmProducts(String productName, String productDesc, int quantity, float unitPrice, int unit, Date availableDate, String prodtStatus) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.availableDate = availableDate;
        this.prodtStatus = prodtStatus;
    }

    public FarmProducts() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
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

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
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
