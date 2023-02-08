package com.codegym.model;

import jakarta.persistence.*;

@Entity
public class productCategoryTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productCategoryTableID;

}
