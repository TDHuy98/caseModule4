package com.codegym.casemodule4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity@Setter
@Getter
@NoArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Basic
    @Column(name = "productname", nullable = false, length = 75)
    private String productname;
    @Basic
    @Column(name = "producttype", nullable = false)
    private short producttype;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Basic
    @Column(name = "quantity", nullable = false)
    private short quantity;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && userId == product.userId && producttype == product.producttype && Double.compare(product.price, price) == 0 && quantity == product.quantity && Objects.equals(productname, product.productname) && Objects.equals(createdAt, product.createdAt) && Objects.equals(updatedAt, product.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productname, producttype, price, quantity, createdAt, updatedAt);
    }
}
