package com.example.shopinternet.repository.detail;

import com.example.shopinternet.detail.Catalog;
import com.example.shopinternet.detail.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
    List<Catalog> findCatalogsByCatalogType(String catalogType);
    Catalog findCatalogByCatalogId(Integer catalogId);
    @Modifying
    @Transactional
    @Query("update Catalog set catalogName=:catalogName, price=:price, amount=:amount," +
            " catalogType=:catalogType, image=:image " +
            "where catalogId=:catalogId")
    void updateCatalog(@Param("catalogName") String catalogName, @Param("price") double price,
                       @Param("amount") Integer amount, @Param("catalogType") String catalogType,
                       @Param("image") Image image, @Param("catalogId") Integer catalogId);
    @Modifying
    @Transactional
    void deleteCatalogByCatalogId(Integer catalogId);
}
