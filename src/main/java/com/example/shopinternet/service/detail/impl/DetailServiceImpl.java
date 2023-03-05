package com.example.shopinternet.service.detail.impl;

import com.example.shopinternet.detail.Detail;
import com.example.shopinternet.detail.Image;
import com.example.shopinternet.model.Engine;
import com.example.shopinternet.repository.detail.DetailRepository;
import com.example.shopinternet.service.detail.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailRepository detailRepository;

    public DetailServiceImpl(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public void addDetail(Detail detail) {
        detail.setAmount(detail.getAmount());
        detail.setDetailName(detail.getDetailName());
        detail.setPrice(detail.getPrice());
        detail.setCatalogType(detail.getCatalogType());
        detailRepository.save(detail);
    }

    @Override
    public Detail findDetailByVinNumber(String vinNumber) {
        return detailRepository.findDetailByVinNumber(vinNumber);
    }

    public List<Detail> findDetailsByEngineName(String engineName) {
        return detailRepository.getDetailsByEngineEngineName(engineName);
    }

    @Override
    public List<Detail> findDetailsByEngineId(Integer engineId) {
        return detailRepository.getDetailsByEngineEngineId(engineId);
    }

    @Override
    public List<Detail> findDetailsByDetailName(String detailName) {
        return detailRepository.getDetailsByDetailName(detailName);
    }

    @Override
    public Detail findDetailByDetailId(Integer detailId) {
        return detailRepository.findDetailByDetailId(detailId);
    }

    @Override
    public List<Detail> findDetailsByCatalogType(String catalogType) {
        return detailRepository.getDetailsByCatalogType(catalogType);
    }

    @Override
    public void uploadImage(Integer detailId, Image image) {
        detailRepository.uploadImage(detailId, image);
    }

    @Override
    public List<Detail> getDetails() {
        return detailRepository.findAll();
    }

    @Override
    public void updateDetail(String detailName, double price, Integer amount, String catalogType, String vinNumber, Image image, Integer detailId) {
        detailRepository.updateDetail(detailName, price, amount, catalogType, vinNumber, image, detailId);
    }

    @Override
    public void deleteDetailByDetailId(Integer detailId) {
        detailRepository.deleteDetailByDetailId(detailId);
    }
}
