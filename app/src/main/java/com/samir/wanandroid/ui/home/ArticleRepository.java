package com.samir.wanandroid.ui.home;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.samir.wanandroid.AppExecutors;
import com.samir.wanandroid.db.WanDb;
import com.samir.wanandroid.db.dao.ArticleDao;
import com.samir.wanandroid.net.Service.WebService;
import com.samir.wanandroid.net.entity.ApiResponse;
import com.samir.wanandroid.net.entity.BaseListData;
import com.samir.wanandroid.net.entity.BaseResult;
import com.samir.wanandroid.net.entity.Resource;
import com.samir.wanandroid.repository.NetworkBoundResource;
import com.samir.wanandroid.ui.home.entity.Article;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

/**
 * @Description:
 */
@Singleton
public class ArticleRepository {

    private final WanDb db;

    private final ArticleDao articleDao;
    //
    private final WebService webService;

    //
    private final AppExecutors appExecutors;

    @Inject
    public ArticleRepository(WanDb db, ArticleDao articleDao,
                             WebService webService,
                             AppExecutors appExecutors) {
        this.db = db;
        this.articleDao = articleDao;
        this.webService = webService;
        this.appExecutors = appExecutors;
    }

    public LiveData<Resource<List<Article>>> loadArticles() {

        return new NetworkBoundResource<List<Article>, BaseResult<BaseListData<Article>>>(appExecutors) {

            @Override
            protected void saveCallResult(@NonNull BaseResult<BaseListData<Article>> item) {
                if(item.getData() !=null){
                    List<Article> articles = item.getData().getDatas();
                    if(articles != null && !articles.isEmpty()){
                        db.beginTransaction();
                        try {
                            articleDao.insertArticles(articles);
                            db.setTransactionSuccessful();
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            db.endTransaction();
                        }
                    }
                    Timber.d("rece saved articles to db");
                }

            }

            @Override
            protected boolean shouldFetch(@Nullable List<Article> data) {
                Timber.d("rece contributor list from db: %s", data);
                return data == null || data.isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<List<Article>> loadFromDb() {

                return articleDao.loadArticles();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<BaseResult<BaseListData<Article>>>> createCall() {
                return webService.loadArticles(20);
            }
        }.asLiveData();
    }
}
