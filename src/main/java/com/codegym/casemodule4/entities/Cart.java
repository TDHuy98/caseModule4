package com.codegym.casemodule4.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double price;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_Name")
    private Account account;

    @ManyToOne()
    @JoinColumn(name = "Code")
    private Product product;
}
