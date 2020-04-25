package com.lettucedream.api.service;

import com.lettucedream.api.model.Packagetype;

import java.util.List;

public interface PackagetypeService {


//    List<Packagetypes> getAll();


    public List<Packagetype> getAllPackagetypes();
    public Boolean isPackagetypeExists(Packagetype packagetype);
    public Boolean isPackagetypeNameExists(Packagetype packagetype);

    public Packagetype getPackagetypeByID(int ID);

    public Packagetype getPackagetypeByName(String Name);
    public Packagetype addPackageType(Packagetype packagetype);

    public Packagetype editPackagetype(Packagetype packagetype);

    public void deletePackagetype(Packagetype packagetype);

}
