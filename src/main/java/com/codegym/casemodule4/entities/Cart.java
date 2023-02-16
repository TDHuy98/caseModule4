package com.codegym.casemodule4.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "cart")
    @Valid
    private List<CartDetail> cartDetails = new ArrayList<>();

    @Basic
    @Column(name = "sessionId")
    private String sessionId;
    @Basic
    @Column(name = "status")
    private short status;

    public Cart() {
    }

    public Cart(Long id, User user, String sessionId, short status) {
        this.id = id;
        this.user = user;
        this.sessionId = sessionId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id && status == cart.status && Objects.equals(user, cart.user) && Objects.equals(sessionId, cart.sessionId) && Objects.equals(createdAt, cart.createdAt) && Objects.equals(updatedAt, cart.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, sessionId, status);
    }
}
