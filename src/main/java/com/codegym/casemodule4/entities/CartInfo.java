package com.codegym.casemodule4.entities;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNum;

    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();


    private CartLineInfo findLineByCode(String code) {
        for (CartLineInfo line : this.cartLines) {
            if (line.getProduct().getCode().equals(code)) {
                return line;
            }
        }
        return null;
    }

    public void addProduct(Product product, int quantity) {
        CartLineInfo line = this.findLineByCode(product.getCode());

        if (line == null) {
            line = new CartLineInfo();
            line.setQuantity(0L);
            line.setProduct(product);
            this.cartLines.add(line);
        }
        int newQuantity = (int) (line.getQuantity() + quantity);
        if (newQuantity <= 0) {
            this.cartLines.remove(line);
        } else {
            line.setQuantity((long) newQuantity);
        }
    }

    public void validate() {

    }

    public void updateProduct(String code, int quantity) {
        CartLineInfo line = this.findLineByCode(code);

        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity((long) quantity);
            }
        }
    }

    public void removeProduct(Product product) {
        CartLineInfo line = this.findLineByCode(product.getCode());
        if (line != null) {
            this.cartLines.remove(line);
        }
    }

    public boolean isEmpty() {
        return this.cartLines.isEmpty();
    }


    public int getQuantityTotal() {
        int quantity = 0;
        for (CartLineInfo line : this.cartLines) {
            quantity += line.getQuantity();
        }
        return quantity;
    }


    public void updateQuantity(CartInfo cartForm) {
        if (cartForm != null) {
            List<CartLineInfo> lines = cartForm.getCartLines();
            for (CartLineInfo line : lines) {
                this.updateProduct(line.getProduct().getCode(), Math.toIntExact(line.getQuantity()));
            }
        }

    }

}
