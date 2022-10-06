package com.dasnee.medmanager;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.ArrayList;
import java.util.List;

public class MedRepo {

    private MedDao medDao;
    private LiveData<List<Med>> allMeds;

    MedRepo(Application application){
        MedRoomDB db = MedRoomDB.getDatabase(application);
        medDao = db.medDao();
        allMeds = medDao.getMeds();
    }

    LiveData<List<Med>> getAllMeds() {
        return allMeds;
    }

    void insert(Med med) {
        MedRoomDB.databaseWriteExecutor.execute(() -> {
            medDao.insert(med);
        });
    }
}
