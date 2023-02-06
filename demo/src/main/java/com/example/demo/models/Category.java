package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Controller;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @Column(name = "categoryID")
    private String categoryID;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "categoryImg")
    private String categoryImg;

    public Category(){}

    public Category(String categoryID, String categoryName, String categoryImg) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryImg = categoryImg;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }
}
