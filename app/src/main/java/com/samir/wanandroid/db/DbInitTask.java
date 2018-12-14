package com.samir.wanandroid.db;

import android.os.AsyncTask;

import com.samir.wanandroid.db.dao.WordDao;
import com.samir.wanandroid.entity.Word;

import javax.inject.Inject;

/**
 * @Description:
 */
public class DbInitTask extends AsyncTask<Void, Void, Void>{

    private WordDao mDao;

    @Inject
    public DbInitTask(WordDao mDao) {
        this.mDao = mDao;
    }

    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteAll();
        Word word = new Word("Hello");
        mDao.insert(word);
        word = new Word("World");
        mDao.insert(word);
        return null;
    }
}
