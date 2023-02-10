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
@Table(name = "order_item", schema = "casemodule4", catalog = "")
@Setter
@Getter
@NoArgsConstructor
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "productId")
    private Long productId;
    @Basic
    @Column(name = "orderId")
    private Long orderId;
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
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id && productId == orderItem.productId && orderId == orderItem.orderId && Double.compare(orderItem.price, price) == 0 && quantity == orderItem.quantity && Objects.equals(createdAt, orderItem.createdAt) && Objects.equals(updatedAt, orderItem.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, orderId, price, quantity, createdAt, updatedAt);
    }
}
