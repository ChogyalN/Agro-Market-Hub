package com.AgroMarketHub.dto;

import java.util.Date;

public class OrdersDTO {

    private int quantityOrder;
    private Date orderDate;
    private String orderStatus;

    public OrdersDTO(int quantityOrder, Date orderDate, String orderStatus) {
        this.quantityOrder = quantityOrder;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
