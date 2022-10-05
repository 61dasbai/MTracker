package com.dasnee.medmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "med_table")
public class Med {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "medId")
    private int id;

    private String medName;
    private String medDose;

    private LocalDate prescriptionDate;
    private LocalDate expirationDate;
    private String prescribingDoctor;

    public Med(String medName){
        this.medName = medName;
    }

    public String getMedName() {
        return this.medName;
    }

    public String getMedDose() {
        return this.medDose;
    }

    public int getId() {
        return this.id;
    }
}
