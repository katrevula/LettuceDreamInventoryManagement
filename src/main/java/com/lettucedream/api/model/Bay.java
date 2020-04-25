package com.lettucedream.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bay")
@SequenceGenerator(name = "seq", initialValue = 1)
public class Bay {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private int bay_id;

    @NotNull
    private char bay_Name;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "bay_id")
//    private BarCode barCode;



//    public BarCode getBarCode() {
//        return barCode;
//    }
//
//    public void setBarCode(BarCode barCode) {
//        this.barCode = barCode;
//    }

    public int getBay_id() {
        return bay_id;
    }

    public void setBay_id(int bay_id) {
        this.bay_id = bay_id;
    }


    public char getBay_Name() {
        return bay_Name;
    }

    public void setBay_Name(char bayName) {
        this.bay_Name = bayName;
    }


}
