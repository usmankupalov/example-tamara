package com.example.shopinternet.service.detail;

import com.example.shopinternet.detail.HitProduct;

import java.util.List;

public interface HitProductService {
    void addHitProduct(HitProduct hitProduct);
    List<HitProduct> getHitProductsByRegisteredTime();
    void deleteHitProduct(Integer hitProductId);
    HitProduct findHitProductByHitProductId(Integer hitProductId);
}
