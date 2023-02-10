package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Oder oder;

}
