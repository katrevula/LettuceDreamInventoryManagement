package com.lettucedream.api.service.impl;

import com.lettucedream.api.dao.BarCodeRepository;
import com.lettucedream.api.model.BarCode;
import com.lettucedream.api.model.Bay;
import com.lettucedream.api.service.BarcodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarcodeServiceImpl implements BarcodeService {

    public static final Logger logger = (Logger) LoggerFactory.getLogger(BarcodeServiceImpl.class);

    @Autowired
    public BarCodeRepository barCodeRepository;


    @Override
    public String GenerateBarcode() {
        return null;
    }

    @Override
    public String GenerateLOTNo() {

        logger.info("in Barcode repository");
        return null;
    }

    @Override
    public List<BarCode> getAllBarcodes() {
        return null;
    }

    @Override
    public boolean isBarCodeExist(BarCode barCode) {
        return false;
    }

    @Override
    public BarCode addBay(Bay bay) {
        return null;
    }

    @Override
    public BarCode getByID(int id) {
        return null;
    }

    @Override
    public BarCode editBarCode(BarCode barCode) {
        return null;
    }

    @Override
    public void deleteBarCode(int id) {

    }
}
