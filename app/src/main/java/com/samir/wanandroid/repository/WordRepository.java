package com.samir.wanandroid.repository;

import android.arch.lifecycle.LiveData;

import com.samir.wanandroid.AppExecutors;
import com.samir.wanandroid.db.dao.WordDao;
import com.samir.wanandroid.entity.Word;
import com.samir.wanandroid.net.WebService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @Description:
 */
@Singleton
public class WordRepository {

    private AppExecutors appExecutors;

    private WordDao mWordDao;

    private WebService webService;

    private LiveData<List<Word>> mAllWords;

    @Inject
    public WordRepository(AppExecutors appExecutors, WordDao mWordDao, WebService webService) {
        this.appExecutors = appExecutors;
        this.mWordDao     = mWordDao;
        this.webService   = webService;
        mAllWords = mWordDao.getAllWords();
    }


    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }


    public void insert (final Word word) {
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mWordDao.insert(word);
            }
        });
    }
}
