package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<<< HEAD:src/main/java/com/codegym/casemodule4/repositories/UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
========
public interface BillRepository extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {
>>>>>>>> origin/master:src/main/java/com/codegym/casemodule4/repositories/BillRepository.java
}