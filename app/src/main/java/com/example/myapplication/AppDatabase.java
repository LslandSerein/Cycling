package com.example.myapplication;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {RunRecordEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RunRecordDao runRecordDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "run_record_database").build();
        }
        return INSTANCE;
    }
}
