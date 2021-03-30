package com.example.djkaandictionary;

import androidx.room.Database;
import androidx.room.RoomDatabase;
//dhlwnw poies klaseis einai oi pinakes ths vashs moy
@Database(entities = {Dictionary.class},version = 1)
public abstract class DictionaryManagerDatabase extends RoomDatabase{
    public abstract MyDao myDao();
}
