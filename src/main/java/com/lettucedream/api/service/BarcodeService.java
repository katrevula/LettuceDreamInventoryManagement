package com.lettucedream.api.service;

import com.lettucedream.api.model.BarCode;
import com.lettucedream.api.model.Bay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarcodeService {

    public String GenerateBarcode();
    public String GenerateLOTNo();

    List<BarCode> getAllBarcodes();


    boolean isBarCodeExist(BarCode barCode);

    BarCode addBay(Bay bay);

    BarCode getByID(int id);

    BarCode editBarCode(BarCode barCode);

    // This method shouldnot delete the barcode, This should only reduce the barcode count in DataBase
    void deleteBarCode(int id);

}
