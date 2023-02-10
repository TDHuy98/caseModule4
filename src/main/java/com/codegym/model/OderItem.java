package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class OderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oderItemID;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Oder oder;
    private Double oderItemPrice;
    private int oderItemQuantity;
    private Date oderItemCreateAt;
    private Date oderItemUpdateAt;

}
