package com.dasnee.medmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "med_table")
public class Med {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "medId")
    private int id;

    @ColumnInfo(name = "medName")
    private String medName;
    @ColumnInfo(name = "medDose")
    private String medDose;

    @Ignore
    Status currStatus;


    /*
    private LocalDate prescriptionDate;
    private LocalDate expirationDate;
    private String prescribingDoctor;
     */


    //private List<LocalDateTime> timesTaken;

    public Med(String medName){
        this.medName = medName;
    }

    public String getMedName() {
        return this.medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedDose() {
        return this.medDose;
    }

    public void setMedDose(String medDose) {
        this.medDose = medDose;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
