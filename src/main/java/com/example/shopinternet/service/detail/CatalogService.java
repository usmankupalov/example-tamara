package com.example.shopinternet.service.detail;

import com.example.shopinternet.detail.Catalog;
import com.example.shopinternet.detail.Image;

import java.util.List;

public interface CatalogService {
    void addCatalog(Catalog catalog);
    List<Catalog> findCatalogsByCatalogType(String catalogType);
    List<Catalog> getCatalogs();
    Catalog findCatalogByCatalogId(Integer catalogId);
    void updateCatalog(String catalogName, double price, Integer amount, String catalogType, Image image, Integer catalogId);
    void deleteCatalogByCatalogId(Integer catalogId);
}
