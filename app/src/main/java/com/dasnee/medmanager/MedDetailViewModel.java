package com.dasnee.medmanager;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MedDetailViewModel extends AndroidViewModel {

    private MedRepo medRepo;
    //private final LiveData<Med> med;

    public MedDetailViewModel(@NonNull Application application) {
        super(application);

        medRepo = new MedRepo(application);
        //med = medRepo.getMedById();
    }
}
