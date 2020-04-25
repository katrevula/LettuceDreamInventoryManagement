package com.lettucedream.api.service.impl;


import com.lettucedream.api.dao.PackagetypeRepository;
import com.lettucedream.api.model.Packagetype;
import com.lettucedream.api.service.PackagetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackagetypeSerivceImpl implements PackagetypeService {



    public PackagetypeRepository packagetypeRepository;


    @Override
    public List<Packagetype> getAllPackagetypes() {
        return packagetypeRepository.findAll();
    }

    @Override
    public Boolean isPackagetypeExists(Packagetype packagetype) {
        return null;
    }


    @Override
    public Packagetype getPackagetypeByID(int ID) {
        return (Packagetype) packagetypeRepository.findByPackagetypeId(ID);
    }

    @Override
    public Packagetype getPackagetypeByName(String Name) {
        return (Packagetype) packagetypeRepository.findByPackagetypeName(Name);
    }

    @Override
    public Boolean isPackagetypeNameExists(Packagetype packagetype) {
        Packagetype currentPackagetype = getPackagetypeByName(packagetype.getPackagetype_name());

        return currentPackagetype != null;
    }

    @Override
    public Packagetype addPackageType(Packagetype packagetype) {
        Packagetype savedBay = packagetypeRepository.saveAndFlush(packagetype);
        return packagetype;
    }

    @Override
    public Packagetype editPackagetype(Packagetype packagetype) {
        return packagetypeRepository.saveAndFlush(packagetype);
    }


 @Override
    public void  deletePackagetype(Packagetype packagetype) {
        packagetypeRepository.deleteById(packagetype.getPackagetype_Id());

    }
}


