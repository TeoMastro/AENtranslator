package com.example.djkaandictionary;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {


    @Insert
    public void addWord(Dictionary dictionary);

    @Query("select * from dictionary")
    public List<Dictionary> getDict();

    @Insert
    public void insertMultipleWords(List<Dictionary> dict);

    @Delete
    public void deleteDict(List<Dictionary> dictionary);

    @Query("SELECT * FROM dictionary WHERE word LIKE :word || '%' ")
    public abstract List<Dictionary> searchWord(String word);
}
