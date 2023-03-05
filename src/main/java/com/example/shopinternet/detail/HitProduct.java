package com.example.shopinternet.detail;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hit_product")
public class HitProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hit_product_id")
    private Integer hitProductId;

    @Column(name = "registered_time", nullable = false)
    private Date registeredTime;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "catalog_id", nullable = false)
    private Catalog catalog;

    public HitProduct(){}

    public Integer getHitProductId() {
        return hitProductId;
    }

    public void setHitProductId(Integer hitProductId) {
        this.hitProductId = hitProductId;
    }

    public Date getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
