package com.example.roomarchcomponent.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomarchcomponent.entity.Word;

import java.util.List;

@Dao
public interface WordDao {

    // query
    @Query("SELECT * FROM word_tb ORDER BY word ASC")
    LiveData<List<Word>> getAphabetWord();

    // insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Word word);

    // delete
    @Query("DELETE from word_tb")
    void deleteAll ();

}
