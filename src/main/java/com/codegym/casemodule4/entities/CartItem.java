package com.codegym.casemodule4.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "cart_item", schema = "casemodule4", catalog = "")
@Setter
@Getter
@NoArgsConstructor
public class CartItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "productId")
    private Long productId;
    @Basic
    @Column(name = "cartId")
    private Long cartId;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "quantity")
    private Short quantity;
    @Basic
    @Column(name = "active")
    private Byte active;
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
        CartItem cartItem = (CartItem) o;
        return id == cartItem.id && productId == cartItem.productId && cartId == cartItem.cartId && Double.compare(cartItem.price, price) == 0 && quantity == cartItem.quantity && active == cartItem.active && Objects.equals(createdAt, cartItem.createdAt) && Objects.equals(updatedAt, cartItem.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, cartId, price, quantity, active, createdAt, updatedAt);
    }
}
