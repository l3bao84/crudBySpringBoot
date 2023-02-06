package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "productID")
    @GeneratedValue(generator = "productGenerator")
    @GenericGenerator(name = "productGenerator", strategy = "com.example.demo.models.ProductIDGenerator")
    private String productID;
    @Column(name = "productName")
    @NotNull
    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(min = 3, max = 300)
    private String productName;
    @Column(name = "productPrice")
    @NotNull
    @Min(0)
    private int productPrice;
    @Column(name = "productNumbers")
    @NotNull
    @Min(0)
    private int productNumbers;
    @Column(name = "productImg")
    @NotNull
    @NotBlank(message = "Bạn chưa điền đường dẫn ảnh")
    @Size(min = 3, max = 300)
    private String productImg;
    @Column(name = "categoryID")
    private String categoryID;

    public Product(){}

    public Product(String productID, String productName, int productPrice, int productNumbers, String productImg, String categoryID) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productNumbers = productNumbers;
        this.productImg = productImg;
        this.categoryID = categoryID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductNumbers() {
        return productNumbers;
    }

    public void setProductNumbers(int productNumbers) {
        this.productNumbers = productNumbers;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }
}
