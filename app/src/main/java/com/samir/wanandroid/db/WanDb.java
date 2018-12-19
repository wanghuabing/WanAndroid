package com.samir.wanandroid.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.samir.wanandroid.db.dao.ArticleDao;
import com.samir.wanandroid.db.dao.WxArticleTitleDao;
import com.samir.wanandroid.db.dao.UserDao;
import com.samir.wanandroid.entity.Article;
import com.samir.wanandroid.entity.WxArticleTitle;
import com.samir.wanandroid.entity.User;

/**
 * @ClassName:WanDb
 * @author: Samir
 */
@Database(entities = {Article.class, User.class, WxArticleTitle.class}, version = 2, exportSchema = false)
public abstract class WanDb extends RoomDatabase {

    public abstract ArticleDao articleDao();

    public abstract UserDao userDao();

    public abstract WxArticleTitleDao titleDao();


//    public abstract WordDao wordDao();

}

