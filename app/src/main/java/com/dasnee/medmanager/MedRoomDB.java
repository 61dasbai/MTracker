package com.dasnee.medmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Med.class}, version = 1, exportSchema = false)
public abstract class MedRoomDB extends RoomDatabase {

    public abstract MedDao medDao();

    private static volatile MedRoomDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MedRoomDB getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (MedRoomDB.class){
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MedRoomDB.class, "med_database").
                            addCallback(sRoomDatabaseCallback).build();
                }
            }
        } return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate (SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
}
