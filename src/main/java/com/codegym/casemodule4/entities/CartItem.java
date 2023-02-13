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
@Table(name = "cart_item", schema = "casemodule4", catalog = "")
public class CartItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "product_id", nullable = false)
    private long productId;
    @Basic
    @Column(name = "cart_id", nullable = false)
    private long cartId;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Basic
    @Column(name = "quantity", nullable = false)
    private short quantity;
    @Basic
    @Column(name = "active", nullable = false)
    private byte active;
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
        CartItem cartItem = (CartItem) o;
        return id == cartItem.id && productId == cartItem.productId && cartId == cartItem.cartId && Double.compare(cartItem.price, price) == 0 && quantity == cartItem.quantity && active == cartItem.active && Objects.equals(createdAt, cartItem.createdAt) && Objects.equals(updatedAt, cartItem.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, cartId, price, quantity, active, createdAt, updatedAt);
    }
}
