package com.lettucedream.api.controller;

import com.lettucedream.api.model.Bay;
import com.lettucedream.api.service.BayService;
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
public class BayController {

    public static final Logger logger = LoggerFactory.getLogger(BayController.class);
    @Autowired
    private BayService bayService;


    //Get all users
    @RequestMapping(value = "/bays", method = RequestMethod.GET)
    public ResponseEntity<List<Bay>> listAllBays() {
        List<Bay> bays = bayService.getAllbays();
        if (bays.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Bay>>(bays, HttpStatus.OK);
        }
    }

    // pass JSON bay name in Upper Case letters

    // Getting error when we post bay with empty string

    @RequestMapping(value = "/addbays", method = RequestMethod.POST)
    public ResponseEntity<?> addBay(@RequestBody Bay bay, UriComponentsBuilder ubuilder) {
        Bay currentBay = bayService.getByName(bay.getBay_Name());
      //  logger.info(String.format("Bay name %s", bay.getBay_Name()));
        if (currentBay != null) {
            logger.error("Unable to create. Bay with name {} already exist", bay.getBay_Name());
            return new ResponseEntity(new CustomErrorType("Unable to create. Bay with following Name already exist: " + bay.getBay_Name()),
                    HttpStatus.CONFLICT);
        }
        bayService.addBay(bay);
    //    logger.info("Printing bay value" + bay.getBay_Name());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ubuilder.path("/api/addbays/").buildAndExpand(bay.getBay_id()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }




// pass JSON bay name in Upper Case letters


    @RequestMapping(value = "/UpdateBays/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateBay(@PathVariable("id") int id, @RequestBody Bay bay) {

        Bay currentBayByName = bayService.getByName(bay.getBay_Name());

        Bay currentBayById = bayService.getByID(id);
        if (currentBayById == null) {
            logger.error("Unable to update. Bay with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Bay with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

//        else if (currentBayByName != null) {
//
//            logger.error((" Unable to update. Bay with " + bay.getBay_Name() + " in the database with bay_id#" + currentBayByName.getBay_id()));
//            return new ResponseEntity(new CustomErrorType(" Unable to update. Bay with " + bay.getBay_Name() + ". Check the baylist bay_id#" + currentBayByName.getBay_id()), HttpStatus.NOT_FOUND);
//        }

        currentBayById.setBay_Name(bay.getBay_Name());
        bayService.editBay(currentBayById);
        logger.info(new StringBuilder().append(" Bay Updated to  ").append(currentBayById.getBay_id()).toString());
        return new ResponseEntity<>(currentBayById, HttpStatus.OK);
    }

    // Delete Method : pass JSON bay name in Upper Case letters
    @RequestMapping(value = "/Deletebay", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBay(@RequestBody Bay bay, UriComponentsBuilder ubuilder) {
        Bay currentBay = bayService.getByName(bay.getBay_Name());
        logger.info(String.format("Bay name %s", bay.getBay_Name()));
        if (currentBay == null) {
            logger.error("Unable to Delete. Bay with the following name {} does not exist", bay.getBay_Name());
            return new ResponseEntity(new CustomErrorType("Unable to delete.  The Bay with following name does not exist: " + bay.getBay_Name()),
                    HttpStatus.CONFLICT);
        }
        bayService.deleteBay(currentBay.getBay_id());
        logger.info("Printing bay value" + bay.getBay_Name());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ubuilder.path("/api/Deletebay/").buildAndExpand(bay.getBay_id()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

}
