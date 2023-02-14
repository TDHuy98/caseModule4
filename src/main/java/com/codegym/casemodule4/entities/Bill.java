package com.codegym.casemodule4.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;


import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Account accountByUserId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateCreated;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateUpdated;

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