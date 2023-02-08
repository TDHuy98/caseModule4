package com.codegym.model;

import jakarta.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemID;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Cart cart;
    private Double cartItemPrice;
    private int cartItemQuantity;
    private String active;

}
