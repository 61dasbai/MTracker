package com.dasnee.medmanager;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.sql.Time;
import java.util.List;

@Dao
public interface TimeTakenDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TimeTaken timeTaken);

    @Query("DELETE FROM times_table")
    void deleteAll();

    @Query("SELECT * FROM times_table")
    List<TimeTaken> getTimes();

    @Query("SELECT * FROM times_table " +
            "WHERE dateTime " +
            "BETWEEN :dateTimeMin and :dateTimeMax")
    List<TimeTaken> getTimesBetween(int dateTimeMin, int dateTimeMax);

}
