package com.codegym.casemodule4.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.codegym.casemodule4.entities.Product} entity
 */
public class ProductDTO implements Serializable {
    private Long id;
    private int categoryId;
    private String name;
    private double price;
    private String image;


    public ProductDTO() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public ProductDTO(Long id, int categoryId, String name, double price, String image) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.image = image;

    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}