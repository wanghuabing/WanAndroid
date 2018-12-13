/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.samir.wanandroid.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.samir.wanandroid.db.WanDb;
import com.samir.wanandroid.db.dao.ArticleDao;
import com.samir.wanandroid.db.dao.RepoDao;
import com.samir.wanandroid.db.dao.UserDao;
import com.samir.wanandroid.db.dao.WordDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Singleton
    @Provides
    WanDb provideDb(Application app) {
        return Room.databaseBuilder(app, WanDb.class,"wanDb.db")
//                .addCallback(callback)
                .build();
    }


    @Singleton @Provides
    ArticleDao provideArticleDao(WanDb db) {
        return db.articleDao();
    }

    @Singleton @Provides
    WordDao provideWordDao(WanDb db) {
        return db.wordDao();
    }


    @Singleton @Provides
    UserDao provideUserDao(WanDb db) {
        return db.userDao();
    }

    @Singleton @Provides
    RepoDao provideRepoDao(WanDb db) {
        return db.repoDao();
    }
}
