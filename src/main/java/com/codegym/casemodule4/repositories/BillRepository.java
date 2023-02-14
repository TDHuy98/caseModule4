package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<<< HEAD:src/main/java/com/codegym/casemodule4/repositories/UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
========
public interface BillRepository extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {
>>>>>>>> 457a8296d28ac262ef4fc164137a44f50266b351:src/main/java/com/codegym/casemodule4/repositories/BillRepository.java
}