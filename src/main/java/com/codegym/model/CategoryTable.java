package com.codegym.model;

import jakarta.persistence.*;

@Entity
public class CategoryTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryTableID;
    private String title;
    private String content;

    public int getCategoryTableID() {
        return categoryTableID;
    }

    public void setCategoryTableID(int categoryTableID) {
        this.categoryTableID = categoryTableID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryTable() {
    }

    public CategoryTable(int categoryTableID, String title, String content) {
        this.categoryTableID = categoryTableID;
        this.title = title;
        this.content = content;
    }
}
