package com.lettucedream.api.model;




import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "barcode")
public class BarCode {

    @Id
    private Integer barcode_Id;

    private String barcode_number;



    private int bay_id;

    private String LOTNumber;

    // Temporary --- In Future Repleace with ProductCatalog --
    private char[] identification_Code123;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    @Past
    private Date seedDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    @Past
    private Date harvestedDate;

    public BarCode() {
    }

    public String getLOTNumber() {
        return LOTNumber;
    }

    public void setLOTNumber(String LOTNumber) {
        this.LOTNumber = LOTNumber;
    }

    public int getBay_id() {
        return bay_id;
    }

    public void setBay_id(int bay_id) {
        this.bay_id = bay_id;
    }

    public Integer getBarcode_Id() {
        return barcode_Id;
    }

    public void setBarcode_Id(Integer barcode_Id) {
        this.barcode_Id = barcode_Id;
    }

    public String getBarcode_number() {
        return barcode_number;
    }

    public void setBarcode_number(String barcode_number) {
        this.barcode_number = barcode_number;
    }

    public Date getSeedDate() {
        return seedDate;
    }

    public void setSeedDate(Date seedDate) {
        this.seedDate = seedDate;
    }

    public Date getHarvestedDate() {
        return harvestedDate;
    }

    public void setHarvestedDate(Date harvestedDate) {
        this.harvestedDate = harvestedDate;
    }

    public char[] getIdentification_Code123() {
        return identification_Code123;
    }

    public void setIdentification_Code123(char[] identification_Code123) {
        this.identification_Code123 = identification_Code123;
    }
}
