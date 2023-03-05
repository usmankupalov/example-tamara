package com.example.shopinternet.detail;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private Integer catalogId;

    @NotBlank
    @Column(name = "catalog_name", nullable = false)
    private String catalogName;

    @Min(1)
    @Column(name = "price", nullable = false)
    private Double price;

    @Min(1)
    @Column(name = "amount", nullable = false)
    private Integer amount;

    @NotBlank
    @Column(name = "catalog_type", nullable = false)
    private String catalogType;

    @ManyToOne
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;

    public Catalog() {}

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(String catalogType) {
        this.catalogType = catalogType;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
