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
@Setter
@Getter
@NoArgsConstructor
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
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
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id && status == cart.status && Objects.equals(userId, cart.userId) && Objects.equals(sessionId, cart.sessionId) && Objects.equals(createdAt, cart.createdAt) && Objects.equals(updatedAt, cart.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, sessionId, status, createdAt, updatedAt);
    }
}
