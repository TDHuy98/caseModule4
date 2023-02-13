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
public class Cart {
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
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
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
