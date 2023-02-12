package com.codegym.casemodule4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "userId")
    private Long userId;
    @Basic
    @Column(name = "productName")
    private String productName;
    @Basic
    @Column(name = "productType")
    private short productType;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "quantity")
    private short quantity;
    @Basic
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updatedAt")
    private Timestamp updatedAt;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && userId == product.userId && productType == product.productType && Double.compare(product.price, price) == 0 && quantity == product.quantity && Objects.equals(productName, product.productName) && Objects.equals(createdAt, product.createdAt) && Objects.equals(updatedAt, product.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productName, productType, price, quantity, createdAt, updatedAt);
    }
}
