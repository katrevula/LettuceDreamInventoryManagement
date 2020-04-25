package com.lettucedream.api.controller;


import com.lettucedream.api.model.Packagetype;
import com.lettucedream.api.service.PackagetypeService;
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
@CrossOrigin(origins = "http://localhost:3000")
public class PackagetypeController {

    public static final Logger logger = LoggerFactory.getLogger(PackagetypeController.class);

    @Autowired
    private PackagetypeService packagetypeService;


    //Get all Packages

    @RequestMapping(value = "/packagetypes", method = RequestMethod.GET)
    public ResponseEntity<List<Packagetype>> PackagetypeLists() {

        logger.info("get packagees success");
        List<Packagetype> packs = packagetypeService.getAllPackagetypes();
        if (packs.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Packagetype>>(packs, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/CreatePackagetype", method = RequestMethod.POST)
    public ResponseEntity<?> CreatePackagetype(@RequestBody Packagetype packagetype, UriComponentsBuilder uriComponentsBuilder) {


        Packagetype currentPackagetype = packagetypeService.getPackagetypeByName(packagetype.getPackagetype_name());

        if (currentPackagetype != null) {

            logger.error("Unable to create the Packagetype with name {} already exist", packagetype.getPackagetype_name());
            return new ResponseEntity(new CustomErrorType("Unable to create. Package type with following Name already exist: " + packagetype.getPackagetype_name()),
                    HttpStatus.CONFLICT);
        }
        packagetypeService.addPackageType(packagetype);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/api/Packagetype/{packagetype.getPackagetype_name}").buildAndExpand(packagetype.getPackagetype_name()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    // Two update methods for Update Pakage
    // 1. Update package by package ID
    // 2. Update package by package Name

    // 1. Update package by package ID
    @RequestMapping(value = "/updatePackage", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdatePackagetype(@RequestBody Packagetype packagetype) {

        Packagetype currentPackagetypebyName = packagetypeService.getPackagetypeByName(packagetype.getPackagetype_name());


        if (currentPackagetypebyName == null) {

            logger.error((" Unable to update. Packagetype with " + packagetype.getPackagetype_name() + " in the database with Packagetype_id#" + currentPackagetypebyName.getPackagetype_Id()));
            return new ResponseEntity(new CustomErrorType(" Unable to update. Packagetype with " + packagetype.getPackagetype_name() + ". Check the Packagetypelist Packagetype_id#" + currentPackagetypebyName.getPackagetype_Id()), HttpStatus.NOT_FOUND);
        } else {
//        int currentPackagetypebyId = currentPackagetypebyName.getPackagetype_Id();
            currentPackagetypebyName.setCount(packagetype.getCount());
            currentPackagetypebyName.setWeight(packagetype.getWeight());
            packagetypeService.editPackagetype(currentPackagetypebyName);
//        logger.info(new StringBuilder().append(" Packagetype Updated to  ").append(currentPackagetypebyId.getPackagetype_Id()).toString());
            return new ResponseEntity<>(packagetype, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/DeletePackagetype", method = RequestMethod.DELETE)
    public ResponseEntity<?> Deletepackagetype(@RequestBody Packagetype packagetype) {

        Packagetype currentPackagetypebyName = packagetypeService.getPackagetypeByName(packagetype.getPackagetype_name());
        if (currentPackagetypebyName == null) {
            logger.error("Packagetype with name " + packagetype.getPackagetype_name() + " does not exist.  Please check the package name");
            return new ResponseEntity(new CustomErrorType("Packagetype with name " + packagetype.getPackagetype_name() + " does not exist.  Please check the package name"), HttpStatus.NOT_FOUND);
        }
        packagetypeService.deletePackagetype(currentPackagetypebyName);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}







