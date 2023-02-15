package com.codegym.casemodule4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.codegym.casemodule4.entities.Account} entity
 */
@Data
@Setter@Getter@AllArgsConstructor
public class AccountDto implements Serializable {
    private final long id;
    private final String userName;
    private final String encrytedPassword;
    private final boolean active;
    private final String userRole;



}