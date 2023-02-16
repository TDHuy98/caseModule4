package com.codegym.casemodule4.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Account account;

    private String status;

    @JsonManagedReference
    @OneToMany
    @Valid
    private List<BillDetail> billDetail = new ArrayList<>();

    @Transient
    public Double getTotalBillPrice() {
        double sum = 0D;
        List<BillDetail> billDetails = getBillDetail();
        for (BillDetail op : billDetails) {
            sum += op.getTotalPrice();
        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.billDetail.size();
    }

    // standard getters and setters
}