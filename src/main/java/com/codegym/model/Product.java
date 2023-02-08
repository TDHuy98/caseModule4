package com.codegym.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    @ManyToOne
    private Account account;
    private String productNames;
    private String productTypes;
    private Double price;
    private int quantity;
    @Column(name="describe", columnDefinition = "LONGTEXT")
    private String describe;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getProductNames() {
        return productNames;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames;
    }

    public String getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(String productTypes) {
        this.productTypes = productTypes;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Product() {
    }

    public Product(int productID, Account account, String productNames, String productTypes, Double price, int quantity, String describe) {
        this.productID = productID;
        this.account = account;
        this.productNames = productNames;
        this.productTypes = productTypes;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
    }
}
