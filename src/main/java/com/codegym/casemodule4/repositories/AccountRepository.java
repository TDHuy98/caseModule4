package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

public interface AccountRepository extends PagingAndSortingRepository <Account,Long>{
   Account findAccountByUsername(String username);

}
