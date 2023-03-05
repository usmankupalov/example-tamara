package com.example.shopinternet.service.detail.impl;

import com.example.shopinternet.detail.Catalog;
import com.example.shopinternet.detail.Image;
import com.example.shopinternet.repository.detail.CatalogRepository;
import com.example.shopinternet.service.detail.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public void addCatalog(Catalog catalog) {
        catalog.setCatalogType(catalog.getCatalogType());
        catalog.setCatalogName(catalog.getCatalogName());
        catalog.setAmount(catalog.getAmount());
        catalog.setPrice(catalog.getPrice());
        catalogRepository.save(catalog);
    }

    @Override
    public List<Catalog> findCatalogsByCatalogType(String catalogType) {
        return catalogRepository.findCatalogsByCatalogType(catalogType);
    }

    @Override
    public List<Catalog> getCatalogs() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findCatalogByCatalogId(Integer catalogId) {
        return catalogRepository.findCatalogByCatalogId(catalogId);
    }

    @Override
    public void updateCatalog(String catalogName, double price, Integer amount, String catalogType, Image image, Integer catalogId) {
        catalogRepository.updateCatalog(catalogName, price, amount, catalogType, image, catalogId);
    }

    @Override
    public void deleteCatalogByCatalogId(Integer catalogId) {
        catalogRepository.deleteCatalogByCatalogId(catalogId);
    }
}
