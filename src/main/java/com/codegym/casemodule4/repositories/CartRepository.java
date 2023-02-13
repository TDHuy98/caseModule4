package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}