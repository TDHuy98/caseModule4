package com.codegym.casemodule4.entities;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class CartLineInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Product product;
    private Long quantity;

    public CartLineInfo() {
        this.quantity = 0L;
    }

}
