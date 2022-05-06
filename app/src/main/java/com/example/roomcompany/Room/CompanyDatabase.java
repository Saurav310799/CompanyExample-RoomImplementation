package com.example.roomcompany.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CompanyModel.class},version = 1)
public abstract class CompanyDatabase extends RoomDatabase {

    public abstract CompanyInterface getInterface();
    public static volatile CompanyDatabase INSTANCE;

    public static CompanyDatabase getInstance(Context context){

        if (INSTANCE == null){
            INSTANCE= Room.databaseBuilder(context,CompanyDatabase.class,"company")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();

        }
        return INSTANCE;
    }
}
