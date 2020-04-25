package com.lettucedream.api.service;

import com.lettucedream.api.model.Bay;

import java.util.List;

public interface BayService  {

    List<Bay> getAllbays();

    boolean isBayExist(Bay bay);

    boolean isLetter(Bay bay);

    Bay addBay(Bay bay);

    Bay getByID(int id);

    Bay editBay(Bay bay);

    Bay getByName(char name);

    void updateBay(Bay bay);

    void deleteBay(int id);



}
