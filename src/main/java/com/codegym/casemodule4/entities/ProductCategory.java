package com.codegym.casemodule4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "product_category", schema = "shopmobile_product_productcategory_category", catalog = "")
@IdClass(ProductCategoryPK.class)
@Setter
@Getter
@NoArgsConstructor
public class ProductCategory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private long product_id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private Long category_id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return product_id == that.product_id && category_id == that.category_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, category_id);
    }
}
