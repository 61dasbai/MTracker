package com.dasnee.medmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.time.Instant;

@Entity(tableName = "times_table")
public class TimeTaken {
    @PrimaryKey
    @ColumnInfo(name="dateTime")
    private long date; //unix time

    @ColumnInfo(name="medId")
    private int medId;

    public TimeTaken(long date, int medId){
        this.date = date;
        this.medId = medId;
    }

    public TimeTaken(int medId){
        this.date = Instant.now().getEpochSecond();
        this.medId = medId;
    }

    public long getDate(){
        return date;
    }

    public void setDate(long date){
        this.date = date;
    }

    public int getMedId(){
        return medId;
    }

    public void setMedId(int medId){
        this.medId = medId;
    }

}
