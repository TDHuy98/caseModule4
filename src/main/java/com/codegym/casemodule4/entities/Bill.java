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
public class Bill {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Long userId;
    @Basic
    @Column(name = "session_id", nullable = false, length = 100)
    private String sessionId;
    @Basic
    @Column(name = "status", nullable = false)
    private short status;
    @Basic
    @Column(name = "sub_total", nullable = false, precision = 0)
    private double subTotal;
    @Basic
    @Column(name = "tax", nullable = false, precision = 0)
    private double tax;
    @Basic
    @Column(name = "total", nullable = false, precision = 0)
    private double total;
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
        Bill bill = (Bill) o;
        return id == bill.id && status == bill.status && Double.compare(bill.subTotal, subTotal) == 0 && Double.compare(bill.tax, tax) == 0 && Double.compare(bill.total, total) == 0 && Objects.equals(userId, bill.userId) && Objects.equals(sessionId, bill.sessionId) && Objects.equals(createdAt, bill.createdAt) && Objects.equals(updatedAt, bill.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, sessionId, status, subTotal, tax, total, createdAt, updatedAt);
    }
}
