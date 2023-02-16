package com.codegym.casemodule4.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart_detail")
public class CartDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "quantity")
    private short quantity;
    @Basic
    @Column(name = "active")
    private byte active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDetail cartItem = (CartDetail) o;
        return id == cartItem.id && productId == cartItem.productId && cart == cartItem.cart && Double.compare(cartItem.price, price) == 0 && quantity == cartItem.quantity && active == cartItem.active && Objects.equals(createdAt, cartItem.createdAt) && Objects.equals(updatedAt, cartItem.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, cart, price, quantity, active, createdAt, updatedAt);
    }
}
