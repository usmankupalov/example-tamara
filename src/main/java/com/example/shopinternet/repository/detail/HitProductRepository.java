package com.example.shopinternet.repository.detail;

import com.example.shopinternet.detail.HitProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HitProductRepository extends JpaRepository<HitProduct, Integer> {
    @Transactional
    @Query(value = "select hp " +
            "from HitProduct hp " +
            "order by hp.registeredTime DESC ")
    List<HitProduct> getHitProductsByRegisteredTime();
    @Modifying
    @Transactional
    @Query("delete from HitProduct hp where hp.hitProductId=:hitProductId")
    void deleteHitProductByHitProductId(@Param("hitProductId") Integer hitProductId);
    HitProduct findHitProductByHitProductId(Integer hitProductId);
}
