package com.samir.wanandroid.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.samir.wanandroid.db.dao.ArticleDao;
import com.samir.wanandroid.db.dao.UserDao;
import com.samir.wanandroid.db.dao.WordDao;
import com.samir.wanandroid.entity.Word;
import com.samir.wanandroid.entity.Article;
import com.samir.wanandroid.entity.User;

/**
 * @ClassName:WanDb
 * @author: Samir
 */
@Database(entities = {Article.class,User.class,Word.class, }, version = 2 ,exportSchema = false)
public abstract class WanDb extends RoomDatabase {

    public abstract ArticleDao articleDao();

    public abstract UserDao userDao();

    public abstract WordDao wordDao();

}

