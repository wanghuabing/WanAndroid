package com.samir.wanandroid.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.samir.wanandroid.entity.Article;

import java.util.List;

/**
 * @Description:
 */
@Dao
public interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertArticle(Article article);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertArticles(List<Article> articles);

    @Delete
    void deleteArticle(Article user);


    @Query("SELECT * FROM ARTICLE_TABLE")
    LiveData<List<Article>>  loadArticles();

    @Query("SELECT * FROM ARTICLE_TABLE where id = :id")
    LiveData<List<Article>> loadArticleById(int id);


    @Query("DELETE FROM ARTICLE_TABLE where title like :pName ")
    int deleteArticleByName(String pName);


    @Query("DELETE FROM ARTICLE_TABLE")
    void deleteAll();


}
