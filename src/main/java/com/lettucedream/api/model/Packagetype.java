package com.lettucedream.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "packagetype")
public class Packagetype {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int packagetype_Id;

    @NotNull
    private String packagetype_name;

    // In weight and count attributes on of them should not be null. Check of the at code

    private double weight;

    private int count;

    public int getPackagetype_Id() {
        return packagetype_Id;
    }

    public void setPackagetype_Id(int packagetype_Id) {
        this.packagetype_Id = packagetype_Id;
    }

    public String getPackagetype_name() {
        return packagetype_name;
    }

    public void setPackagetype_name(String packagetype_name) {
        this.packagetype_name = packagetype_name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
//@OneToMany(mappedBy = "pack" ,fetch = FetchType.LAZY)
    //@JsonBackReference
    //private BarCode barcode;

}
