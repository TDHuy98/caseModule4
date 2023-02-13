package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillItemRepository extends JpaRepository<BillItem, Long> {
}