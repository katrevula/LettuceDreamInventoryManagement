package com.lettucedream.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "productcatalog", uniqueConstraints = { @UniqueConstraint(columnNames = {"productcatalog_Name"}), @UniqueConstraint(columnNames = {"identification_Code"})})

public class ProductCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productcatalog_Id;
    @NotNull
    private String productcatalog_Name;
    @NotNull
    private char identification_Code;
    @NotNull

    private int daysOfExpiration;

    public int getProductcatalog_Id() {
        return productcatalog_Id;
    }

    public void setProductcatalog_Id(int productcatalog_Id) {
        this.productcatalog_Id = productcatalog_Id;
    }

    public String getProductcatalog_Name() {
        return productcatalog_Name;
    }

    public void setProductcatalog_Name(String productcatalog_Name) {
        this.productcatalog_Name = productcatalog_Name;
    }

    public char getIdentification_Code() {
        return identification_Code;
    }

    public void setIdentification_Code(char identification_Code) {
        this.identification_Code = identification_Code;
    }

    public int getDaysOfExpiration() {
        return daysOfExpiration;
    }

    public void setDaysOfExpiration(int daysOfExpiration) {
        this.daysOfExpiration = daysOfExpiration;
    }
//
//    @OneToMany(mappedBy = "prodt" ,fetch = FetchType.LAZY)
//    @JsonBackReference
//    private BarCode barcode;

}
