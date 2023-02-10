package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Account account;
    private String oderStatus;
    private Date oderCreateAt;
    private Date oderUpdateAt;
    private Double subTotal;
    private Double tax;
    private Double shipping;
    private Double total;

}
