package fr.fms.shop.model;

import java.math.BigDecimal;

public class Article {
    private int id;
    private String description;
    private String brand;
    private BigDecimal unitaryPrice;
    private Integer idCategory;

    public Article(String description, String brand) {
        this.description = description;
        this.brand = brand;
        this.unitaryPrice = BigDecimal.ZERO;
    }

    public Article(String description, String brand, BigDecimal unitaryPrice) {
        this.description = description;
        this.brand = brand;
        this.unitaryPrice = unitaryPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(BigDecimal unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
