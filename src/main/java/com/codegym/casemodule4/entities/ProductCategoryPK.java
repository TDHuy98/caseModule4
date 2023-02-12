package com.codegym.casemodule4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
@Setter
@Getter
@NoArgsConstructor
public class ProductCategoryPK implements Serializable {
    @Column(name = "productId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(name = "categoryId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryPK that = (ProductCategoryPK) o;
        return productId == that.productId && categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, categoryId);
    }
}
