package com.samir.wanandroid.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.samir.wanandroid.AppExecutors;
import com.samir.wanandroid.db.dao.UserDao;
import com.samir.wanandroid.db.entity.User;
import com.samir.wanandroid.net.Service.WebService;
import com.samir.wanandroid.net.entity.ApiResponse;
import com.samir.wanandroid.net.entity.Resource;

import javax.inject.Inject;

/**
 * UserRepository
 */
public class UserRepository {
    //
    private final WebService webService;

    private final UserDao userDao;
    //
    private final AppExecutors appExecutors;

    @Inject
    UserRepository(AppExecutors appExecutors, UserDao userDao,WebService webService) {
        this.appExecutors = appExecutors;
        this.userDao = userDao;
        this.webService = webService;
    }

    public LiveData<Resource<User>> loadUser(final String login) {
        return new NetworkBoundResource<User,User>(appExecutors) {
            @Override
            protected void saveCallResult(@NonNull User item) {
                userDao.insert(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable User data) {
                return data == null;
            }

            @NonNull
            @Override
            protected LiveData<User> loadFromDb() {
                return userDao.findByLogin(login);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<User>> createCall() {
                return webService.getUser(login);
            }
        }.asLiveData();
    }
}
