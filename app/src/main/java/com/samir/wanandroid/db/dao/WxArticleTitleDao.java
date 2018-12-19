package com.samir.wanandroid.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.samir.wanandroid.entity.WxArticleTitle;

import java.util.List;

/**
 * @author: samir
 * @date: 2018/12/18 下午5:03
 */
@Dao
public interface WxArticleTitleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTitle(WxArticleTitle title);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTitles(List<WxArticleTitle> titles);

    @Delete
    void deleteArticle(WxArticleTitle word);


    @Query("SELECT * FROM WX_ARTICLE_TITLES_TABLE")
    LiveData<List<WxArticleTitle>> loadTitles();


    @Query("DELETE FROM WX_ARTICLE_TITLES_TABLE")
    void deleteAll();
}
