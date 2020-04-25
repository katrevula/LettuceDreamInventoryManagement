package com.lettucedream.api.controller;


import com.lettucedream.api.model.Packagetype;
import com.lettucedream.api.model.ProductCatalog;
import com.lettucedream.api.service.ProductCatalogService;
import com.lettucedream.api.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class ProductCatalogController {


    public static final Logger logger = LoggerFactory.getLogger(ProductCatalogController.class);
    @Autowired
    public ProductCatalogService productCatalogSerice;

    @RequestMapping(value = "/ProductCatalog", method = RequestMethod.GET)
    public ResponseEntity<?> GetProductCatalog() {
        List<ProductCatalog> productCatalogs = productCatalogSerice.getAllProductCatalogs();
        if (productCatalogs.isEmpty()) {
            logger.error("Running GetProductCatfdafdsafasdfdasalog method controller");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            logger.error("Running GetProductCatalog method controller");
            return new ResponseEntity<List<ProductCatalog>>(productCatalogs, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/CreateProductCatalog", method = RequestMethod.POST)
    public ResponseEntity<?> CreateProductCatalog(@RequestBody ProductCatalog productCatalog, UriComponentsBuilder uriComponentsBuilder) {
        ProductCatalog currentProductCatalogByName = productCatalogSerice.getProductCatalogByName(productCatalog.getProductcatalog_Name());
        if (currentProductCatalogByName != null) {
            logger.error("Unable to create the ProductCatalog with name {} already exist", productCatalog.getProductcatalog_Name());
            return new ResponseEntity(new CustomErrorType("Unable to create. ProductCatalog type with following Name already exist: " + productCatalog.getProductcatalog_Name()),
                    HttpStatus.CONFLICT);
        }
        productCatalogSerice.addProductCatalog(productCatalog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/api/ProductCatalog/{productCatalog.getProductcatalog_Name()}").buildAndExpand(productCatalog.getProductcatalog_Name()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    // Write code for Identification letter are unique or not. They cann/t be duplicated. In Repository, Identification letter - UniqueContoller(Unique)

    @RequestMapping(value = "/updateProductCatalog", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateProductCatalog(@RequestBody ProductCatalog productCatalog) {
        logger.info(productCatalog.getProductcatalog_Name());

        ProductCatalog currentProductCatalogByName = productCatalogSerice.getProductCatalogByName(productCatalog.getProductcatalog_Name());

        logger.info(currentProductCatalogByName.getProductcatalog_Name());
        if (currentProductCatalogByName == null) {

            logger.error((" Unable to update. productCatalog with " + productCatalog.getProductcatalog_Name() + " in the database with Packagetype_id#" + currentProductCatalogByName.getProductcatalog_Id()));
            return new ResponseEntity(new CustomErrorType(" Unable to update. Packagetype with " + productCatalog.getProductcatalog_Name() + ". Check the productCataloglist productCatalog_id#" + currentProductCatalogByName.getProductcatalog_Id()), HttpStatus.NOT_FOUND);
        } else {
            int currentProductCatalogById = currentProductCatalogByName.getProductcatalog_Id();
            currentProductCatalogByName.setDaysOfExpiration(productCatalog.getDaysOfExpiration());
            currentProductCatalogByName.setIdentification_Code(productCatalog.getIdentification_Code());
            productCatalogSerice.editProductCatalog(currentProductCatalogByName);
            return new ResponseEntity<>(currentProductCatalogByName, HttpStatus.OK);
        }
    }



// Not Working Check this later
    @RequestMapping(value = "/DeleteProductCatalog", method = RequestMethod.DELETE)
    public ResponseEntity<?> DeleteProductCatalog(@RequestBody ProductCatalog productCatalog) {

        ProductCatalog currentProductCatalogByName = productCatalogSerice.getProductCatalogByName(productCatalog.getProductcatalog_Name());
        if (currentProductCatalogByName == null) {
            logger.error("Packagetype with name " + productCatalog.getProductcatalog_Name() + " does not exist.  Please check the package name");
            return new ResponseEntity(new CustomErrorType("Packagetype with name " + productCatalog.getProductcatalog_Name() + " does not exist.  Please check the package name"), HttpStatus.NOT_FOUND);
        }
        productCatalogSerice.deleteProductCatalog(currentProductCatalogByName);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

}
