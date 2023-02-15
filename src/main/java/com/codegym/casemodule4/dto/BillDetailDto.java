package com.codegym.casemodule4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.codegym.casemodule4.entities.BillDetail} entity
 */
@Data@Setter
@Getter
@AllArgsConstructor

public class BillDetailDto implements Serializable {
    private final BillDetailPKDto pk;
    private final Integer quantity;
    private final BillDto bill;
    private final ProductDTO product;
    private final Double totalPrice;
}