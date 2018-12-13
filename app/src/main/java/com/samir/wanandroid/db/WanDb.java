package com.samir.wanandroid.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.samir.wanandroid.db.dao.ArticleDao;
import com.samir.wanandroid.db.dao.RepoDao;
import com.samir.wanandroid.db.dao.UserDao;
import com.samir.wanandroid.db.dao.WordDao;
import com.samir.wanandroid.db.entity.Contributor;
import com.samir.wanandroid.db.entity.Repo;
import com.samir.wanandroid.db.entity.RepoSearchResult;
import com.samir.wanandroid.db.entity.User;
import com.samir.wanandroid.db.entity.Word;
import com.samir.wanandroid.ui.home.entity.Article;

/**
 * @ClassName:WanDb
 * @author: Samir
 */
@Database(entities = {Article.class,User.class,Word.class, Repo.class, Contributor.class,
        RepoSearchResult.class}, version = 2 ,exportSchema = false)
public abstract class WanDb extends RoomDatabase {

    public abstract ArticleDao articleDao();

    public abstract UserDao userDao();

    public abstract RepoDao repoDao();

    public abstract WordDao wordDao();

}

