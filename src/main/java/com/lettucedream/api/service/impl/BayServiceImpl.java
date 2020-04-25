package com.lettucedream.api.service.impl;

import com.lettucedream.api.dao.BayRepository;
import com.lettucedream.api.model.Bay;
import com.lettucedream.api.service.BayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BayServiceImpl implements BayService {


    @Autowired
    private BayRepository bayRepository;

    @Override
    public List<Bay> getAllbays() {

//        System.out.printf("In Get alll Bays");
//        List<Bay> list = new ArrayList<Bay>();
//        list.add(bayRepository.findByBayId("1"));

//        return list ;

        return bayRepository.findAll();

    }


    public boolean isBayExist(Bay bay) {
        return bay.equals(getAllbays());
    }

    @Override
    public boolean isLetter(Bay bay) {
        return false;
    }

    @Override
    public Bay addBay(Bay bay) {
        Bay savedBay = bayRepository.saveAndFlush(bay);
        return bay;
    }

    @Override
    public Bay getByID(int id) {
        return bayRepository.findByBayId(id);
    }

    @Override
    public void updateBay(Bay bay) {
        if (!isBayExist(bay))
            bayRepository.saveAndFlush(bay);
    }

    @Override
    public void deleteBay(int id) {
        bayRepository.deleteById(id);

    }

    @Override
    public Bay editBay(Bay bay) {
        return bayRepository.saveAndFlush(bay);
    }

    @Override
    public Bay getByName(char name) {
        return bayRepository.findByName(name);
    }


}