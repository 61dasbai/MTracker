package com.dasnee.medmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "times_table")
public class TimeTaken {
    @PrimaryKey
    @ColumnInfo(name="dateTime")
    private long date; //unix time

    @ColumnInfo(name="medId")
    private int medId;
}
