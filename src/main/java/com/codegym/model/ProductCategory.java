package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productCategoryID;
    @ManyToOne
    private Category category;

}
