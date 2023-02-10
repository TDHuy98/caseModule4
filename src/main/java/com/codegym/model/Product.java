package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    @ManyToOne
    private Account account;
    private String productNames;
    private String productTypes;
    private Double price;
    private int quantity;

}
