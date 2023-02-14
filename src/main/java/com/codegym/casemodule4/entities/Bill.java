package com.codegym.casemodule4.entities;


import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Bill", //
        uniqueConstraints = {@UniqueConstraint(columnNames = "Bill_Num")})
public class Bill implements Serializable {

    private static final long serialVersionUID = -2576670215015463100L;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Bill_Date", nullable = false)
    private Date billDate;

    @Column(name = "Bill_Num", nullable = false)
    private int billNum;

    @Column(name = "Amount", nullable = false)
    private double amount;

    @Column(name = "Customer_Name", length = 255, nullable = false)
    private String customerName;

    @Column(name = "Customer_Address", length = 255, nullable = false)
    private String customerAddress;

    @Column(name = "Customer_Email", length = 128, nullable = false)
    private String customerEmail;

    @Column(name = "Customer_Phone", length = 128, nullable = false)
    private String customerPhone;
//    @Column(name = "status", nullable = false)
//    private short status;
//    @Basic
//    @Column(name = "sub_total", nullable = false, precision = 0)
//    private double subTotal;
//    @Basic
//    @Column(name = "tax", nullable = false, precision = 0)
//    private double tax;
//    @Basic
//    @Column(name = "total", nullable = false, precision = 0)
//    private double total;
//    @Basic
//    @Column(name = "created_at", nullable = false)
//    private Timestamp createdAt;
//    @Basic
//    @Column(name = "updated_at", nullable = true)
//    private Timestamp updatedAt;
//



}
