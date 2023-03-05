package com.example.shopinternet.repository.detail;

import com.example.shopinternet.detail.Detail;
import com.example.shopinternet.detail.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
    List<Detail> getDetailsByEngineEngineName(String engineName);
    List<Detail> getDetailsByEngineEngineId(Integer engineId);
    Detail findDetailByDetailId(Integer detailId);
    Detail findDetailByVinNumber(String vinNumber);
    List<Detail> getDetailsByDetailName(String detailName);
    List<Detail> getDetailsByCatalogType(String catalogType);
    @Modifying
    @Transactional
    @Query("update Detail b " +
            "set b.image=:image " +
            "where b.detailId=:brakeSystemId")
    void uploadImage(@Param("brakeSystemId") Integer brakeSystemId,
                     @Param("image") Image image);
    @Modifying
    @Transactional
    @Query("update Detail set detailName=:detailName, price=:price, amount=:amount, " +
            "catalogType=:catalogType, vinNumber=:vinNumber, image=:image " +
            "where detailId=:detailId")
    void updateDetail(@Param("detailName") String detailName, @Param("price") double price,
                      @Param("amount") Integer amount, @Param("catalogType") String catalogType,
                      @Param("vinNumber") String vinNumber, @Param("image") Image image,
                      @Param("detailId") Integer detailId);
    @Modifying
    @Transactional
    void deleteDetailByDetailId(Integer detailId);
}
