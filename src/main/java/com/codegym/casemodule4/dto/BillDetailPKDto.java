package com.codegym.casemodule4.dto;

import com.codegym.casemodule4.entities.BillDetailPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link BillDetailPK} entity
 */
@Data@Setter
@Getter
@AllArgsConstructor

public class BillDetailPKDto implements Serializable {
    private final BillDto bill;
    private final ProductDTO product;
}