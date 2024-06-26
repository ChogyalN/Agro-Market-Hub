package com.AgroMarketHub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "farm_owner")
public class FarmOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "location")
    private String location;

    @Column(name = "address")
    private String address;

    @Column(name = "farm_size")
    private String farmSize;

    @Column(name = "phone_no")
    private long phoneNumber;
    @Column(name = "dzongkhag")
    private String dzongkhag;

    @Column(name = "gewog")
    private String gewog;

    @Column(name = "village")
    private String village;

    @OneToMany
    @JoinColumn(name = "owner")
    private List<FarmProducts> products;

    public FarmOwner(String name, String location, String address, String farmSize, long phoneNumber, String dzongkhag, String gewog, String village) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.farmSize = farmSize;
        this.phoneNumber = phoneNumber;
        this.dzongkhag = dzongkhag;
        this.gewog = gewog;
        this.village = village;
    }

    public FarmOwner() {}

    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFarmSize() {
        return farmSize;
    }

    public void setFarmSize(String farmSize) {
        this.farmSize = farmSize;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDzongkhag() {
        return dzongkhag;
    }

    public void setDzongkhag(String dzongkhag) {
        this.dzongkhag = dzongkhag;
    }

    public String getGewog() {
        return gewog;
    }

    public void setGewog(String gewog) {
        this.gewog = gewog;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public List<FarmProducts> getProducts() {
        return products;
    }

    public void setProducts(List<FarmProducts> products) {
        this.products = products;
    }
}
