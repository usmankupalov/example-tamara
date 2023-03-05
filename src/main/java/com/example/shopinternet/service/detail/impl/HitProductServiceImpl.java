package com.example.shopinternet.service.detail.impl;

import com.example.shopinternet.detail.HitProduct;
import com.example.shopinternet.repository.detail.HitProductRepository;
import com.example.shopinternet.service.detail.HitProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HitProductServiceImpl implements HitProductService {

    @Autowired
    private HitProductRepository hitProductRepository;

    public HitProductServiceImpl(HitProductRepository hitProductRepository) {
        this.hitProductRepository = hitProductRepository;
    }

    @Override
    public void addHitProduct(HitProduct hitProduct) {
        Date registeredTime = new Date();
        hitProduct.setRegisteredTime(registeredTime);
        hitProductRepository.save(hitProduct);
    }

    @Override
    public List<HitProduct> getHitProductsByRegisteredTime() {
        return hitProductRepository.getHitProductsByRegisteredTime();
    }

    @Override
    public void deleteHitProduct(Integer hitProductId) {
        hitProductRepository.deleteHitProductByHitProductId(hitProductId);
    }

    @Override
    public HitProduct findHitProductByHitProductId(Integer hitProductId) {
        return hitProductRepository.findHitProductByHitProductId(hitProductId);
    }
}
