package com.lettucedream.api.controller;

import com.lettucedream.api.model.BarCode;
import com.lettucedream.api.service.BarcodeService;
import com.lettucedream.api.service.BayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;


@RestController
public class BarcodeController {

    public static final Logger logger = LoggerFactory.getLogger(BarcodeController.class);
    @Autowired
    public BarcodeService barcodeService;
    @Autowired
    public BayService bayService;



/* Generating Barcode - LDO42820A01BR Following Will Explain the Barcode Number
        1. LD --> LettuceDream
        2. 041120(MMddyy) ---> Date Format( 28th April 2020)
        3.  A ---> Is the Bay_Name or Bay_Identification
        4. 01 ---> Increments one on the generation of each box on that day
        5. BR ---->Product Catalog Indentification codes
                    Eg. B- buttercrunch and Romaine ----> R
                        If only Romaine in the PackageType --->  RR
                        Planning to accomidate more than two types of lettuces ---> XX
  */


    @RequestMapping(value = "/GenerateBarcode", method = RequestMethod.POST)
//    public void CreateLOTNumber111(@RequestBody BarCode barCode) {
    public void CreateLOTNumber111(@RequestBody BarCode barCode) {

        Character bname;


// Hard coded  - Input Data Bay - ID ---> Find Bay Name
        barCode.setBay_id(55);
        bname = bayService.getByID(55).getBay_Name();

// LOT Number Date Format

        String LOTNumberDate = null;
        try {
            logger.info(barCode.getHarvestedDate().toString());
            SimpleDateFormat toLOTNumFormat = new SimpleDateFormat("MMddyy");
            LOTNumberDate = toLOTNumFormat.format(barCode.getHarvestedDate()).toString();
            logger.info(LOTNumberDate);
        } catch (Exception e) {
            logger.error("Date parsing Excepption " + e);
        }

// Generating LOT Number - Concatenation of LOTNumber format and Bayname

        String LOTNumber = LOTNumberDate.concat(bname.toString().toUpperCase());
        barCode.setLOTNumber(LOTNumber);

// ProductCatalogs


        char[] arr = { 'a','b','c'};


        barCode.setIdentification_Code123(arr);


        System.out.println("");
        System.out.println("Identification codes");
        for (char iCodes : arr)
            System.out.println(iCodes);


    }

}
