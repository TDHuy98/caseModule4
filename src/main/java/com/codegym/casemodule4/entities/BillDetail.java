package com.codegym.casemodule4.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDetail {
    @EmbeddedId
    @JsonIgnore
    private BillDetailPK pk;

    @Basic
    @Column(nullable = false, name = "quantity")
    private int quantity;
    // hashcode() and equals() methods

//    @ManyToOne
//    @JoinColumn(name = "user_id",nullable = false)
//    private Account account;

    // standard getters and setters

    public BillDetail(Bill bill, Product product, Integer quantity) {
        pk = new BillDetailPK();
        pk.setBill(bill);
//        pk.setAccount(account);
        pk.setProduct(product);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }



}

