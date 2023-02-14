package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.CartInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICartInfo extends JpaRepository<CartInfo,Long>, JpaSpecificationExecutor<CartInfo> {
}
