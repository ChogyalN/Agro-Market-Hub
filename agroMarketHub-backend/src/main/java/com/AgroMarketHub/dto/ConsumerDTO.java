package com.AgroMarketHub.dto;

public class ConsumerDTO {
    private String consumerName;
    private long phoneNumber;
    private String location;
    private float unit_quantity;

    public ConsumerDTO(String consumerName, long phoneNumber, String location, float unit_quantity) {
        this.consumerName = consumerName;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.unit_quantity = unit_quantity;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getUnit_quantity() {
        return unit_quantity;
    }

    public void setUnit_quantity(float unit_quantity) {
        this.unit_quantity = unit_quantity;
    }
}
