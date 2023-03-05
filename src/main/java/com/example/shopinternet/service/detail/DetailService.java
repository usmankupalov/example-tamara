package com.example.shopinternet.service.detail;

import com.example.shopinternet.detail.Detail;
import com.example.shopinternet.detail.Image;
import com.example.shopinternet.model.Engine;

import java.util.List;

public interface DetailService {
    void addDetail(Detail detail);
    Detail findDetailByVinNumber(String vinNumber);
    List<Detail> findDetailsByEngineName(String engineName);
    List<Detail> findDetailsByEngineId(Integer engineId);
    List<Detail> findDetailsByDetailName(String detailName);
    Detail findDetailByDetailId(Integer brakeSystemId);
    List<Detail> findDetailsByCatalogType(String catalogType);
    void uploadImage(Integer detailId, Image image);
    List<Detail> getDetails();
    void updateDetail(String detailName, double price, Integer amount, String catalogType, String vinNumber,
                      Image image, Integer detailId);
    void deleteDetailByDetailId(Integer detailId);
}
