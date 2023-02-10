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
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "userId")
    private Long userId;
    @Basic
    @Column(name = "sessionId")
    private String sessionId;
    @Basic
    @Column(name = "status")
    private short status;
    @Basic
    @Column(name = "subTotal")
    private double subTotal;
    @Basic
    @Column(name = "tax")
    private double tax;
    @Basic
    @Column(name = "total")
    private double total;
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
        Order order = (Order) o;
        return id == order.id && status == order.status && Double.compare(order.subTotal, subTotal) == 0 && Double.compare(order.tax, tax) == 0 && Double.compare(order.total, total) == 0 && Objects.equals(userId, order.userId) && Objects.equals(sessionId, order.sessionId) && Objects.equals(createdAt, order.createdAt) && Objects.equals(updatedAt, order.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, sessionId, status, subTotal, tax, total, createdAt, updatedAt);
    }
}
