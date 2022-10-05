package com.dasnee.medmanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MedDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Med med);

    @Query("DELETE FROM med_table")
    void deleteAll();

    @Query("SELECT * FROM med_table")
    LiveData<List<Med>> getMeds();

}
