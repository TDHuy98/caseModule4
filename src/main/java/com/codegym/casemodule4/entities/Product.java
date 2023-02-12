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
    @Column(name = "user_id")
    private Long user_id;
    @Basic
    @Column(name = "product_name")
    private String product_name;
    @Basic
    @Column(name = "product_type")
    private short product_type;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "quantity")
    private short quantity;
    @Basic
    @Column(name = "created_at")
    private Timestamp created_at;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updated_at;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && user_id == product.user_id && product_type == product.product_type && Double.compare(product.price, price) == 0 && quantity == product.quantity && Objects.equals(product_name, product.product_name) && Objects.equals(created_at, product.created_at) && Objects.equals(updated_at, product.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, product_name, product_type, price, quantity, created_at, updated_at);
    }
}
