package com.samir.wanandroid.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.samir.wanandroid.entity.Word;

import java.util.List;

/**
 * @Description:
 */
@Dao
public interface  WordDao {

    @Insert
    void insert(Word word);

    @Delete
    void delete(Word word);


    @Query("DELETE FROM WORD_TABLE")
    void deleteAll();

    @Query("SELECT * FROM WORD_TABLE ORDER BY WORD ASC")
    LiveData<List<Word>> getAllWords();
}
