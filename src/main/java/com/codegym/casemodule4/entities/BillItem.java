package com.codegym.casemodule4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity@Setter
@Getter
@NoArgsConstructor
@Table(name = "bill_item", schema = "casemodule4", catalog = "")
public class BillItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "product_id", nullable = false)
    private long productId;
    @Basic
    @Column(name = "bill_id", nullable = false)
    private long billId;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Basic
    @Column(name = "quantity", nullable = false)
    private short quantity;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillItem billItem = (BillItem) o;
        return id == billItem.id && productId == billItem.productId && billId == billItem.billId && Double.compare(billItem.price, price) == 0 && quantity == billItem.quantity && Objects.equals(createdAt, billItem.createdAt) && Objects.equals(updatedAt, billItem.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, billId, price, quantity, createdAt, updatedAt);
    }
}
