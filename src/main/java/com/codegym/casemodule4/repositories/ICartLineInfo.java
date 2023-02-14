package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.CartInfo;
import com.codegym.casemodule4.entities.CartLineInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICartLineInfo extends JpaRepository<CartLineInfo,Long>, JpaSpecificationExecutor<CartLineInfo> {
}
