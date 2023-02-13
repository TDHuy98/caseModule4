package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}