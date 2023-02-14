package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BillDetailRepository extends JpaRepository<BillDetail, Long>, JpaSpecificationExecutor<BillDetail> {
}