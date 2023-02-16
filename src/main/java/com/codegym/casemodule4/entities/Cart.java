package com.codegym.casemodule4.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Account account;

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

    public Cart(Long id, Account account, String sessionId, short status) {
        this.id = id;
        this.account = account;
        this.sessionId = sessionId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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


}
