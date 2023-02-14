package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.BillDetail;
import com.codegym.casemodule4.entities.BillDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface BillDetailRepository extends JpaRepository<BillDetail, BillDetailPK>, JpaSpecificationExecutor<BillDetail> {
}