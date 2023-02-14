package com.codegym.casemodule4.dto;

import com.codegym.casemodule4.entities.Account;
import com.codegym.casemodule4.entities.BillDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link com.codegym.casemodule4.entities.Bill} entity
 */
@Data@Setter
@Getter
@AllArgsConstructor

public class BillDto implements Serializable {
    private final long id;
    private final Account account;
    private final Date dateCreated;
    private final String status;
    private final List<BillDetail> billDetail;
    private final double totalBillPrice;
    private final int numberOfProducts;
}