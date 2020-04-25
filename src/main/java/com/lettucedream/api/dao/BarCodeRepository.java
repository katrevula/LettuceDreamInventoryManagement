package com.lettucedream.api.dao;

import com.lettucedream.api.model.BarCode;
import com.lettucedream.api.model.Bay;
import com.lettucedream.api.service.impl.BarcodeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BarCodeRepository extends JpaRepository<BarCode, Integer> {
    public static final Logger logger = (Logger) LoggerFactory.getLogger(BarcodeServiceImpl.class);


//    @Query("select t from BarCode t where t.barcode_Id = :id")
//    Bay findByBarCodeId(@Param("id") int id);


//    @Query("select t from Bay t where (t.bay_Name = :name)")
//    Bay findByName(@Param("name") char name);
}
