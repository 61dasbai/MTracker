package com.dasnee.medmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MedViewModel extends AndroidViewModel {

    private MedRepo medRepo;
    private final LiveData<List<Med>> allMeds;

    public MedViewModel(@NonNull Application application) {
        super(application);

        medRepo = new MedRepo(application);
        allMeds = medRepo.getAllMeds();
    }

    LiveData<List<Med>> getAllMeds(){
        return getAllMeds();
    }
}
