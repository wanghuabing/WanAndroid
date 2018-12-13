package com.samir.wanandroid.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * @Description:
 */
public class DbCreateCallBack extends RoomDatabase.Callback {
    DbInitTask mInitTask;

    @Inject
    DbCreateCallBack(DbInitTask mInitTask){
        this.mInitTask = mInitTask;
    }

    @Override
    public void onOpen(@NonNull SupportSQLiteDatabase db) {
        super.onOpen(db);
        mInitTask.execute();
    }

}
