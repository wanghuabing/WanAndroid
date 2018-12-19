package com.samir.wanandroid.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.samir.framework.utils.RateLimiter;
import com.samir.wanandroid.AppExecutors;
import com.samir.wanandroid.db.WanDb;
import com.samir.wanandroid.entity.Article;
import com.samir.wanandroid.entity.WxArticleTitle;
import com.samir.wanandroid.entity.common.ApiResponse;
import com.samir.wanandroid.entity.common.DataHeader;
import com.samir.wanandroid.entity.common.ListDataHeader;
import com.samir.wanandroid.entity.common.Resource;
import com.samir.wanandroid.net.WebService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

/**
 * @Description:
 */
@Singleton
public class ArticleRepository {

    private final WanDb db;

    //
    private final WebService webService;

    //
    private final AppExecutors appExecutors;


    private RateLimiter<String> repoListRateLimit = new RateLimiter<>(10, TimeUnit.MINUTES);

    @Inject
    public ArticleRepository(WanDb db,  WebService webService,
                             AppExecutors appExecutors) {
        this.db = db;
        this.webService = webService;
        this.appExecutors = appExecutors;
    }

    /**
     * 加载首页文章
     */
    public LiveData<Resource<List<Article>>> loadArticlesNew(int page) {
        MediatorLiveData<Resource<List<Article>>> finalResult = new MediatorLiveData<>();
        finalResult.setValue(Resource.loading(null));
        LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> netWorkData = webService.loadArticles(page);
        finalResult.addSource(netWorkData, response -> {
            if (response.isSuccessful()) {
                if(response.body !=null){
                    List<Article> articles = response.body.getData().getDatas();
                    if(articles != null && !articles.isEmpty()){
                        finalResult.setValue(Resource.success(articles));
                    }
                }
            } else {
                finalResult.setValue(Resource.error(response.errorMessage,null));
            }
        });
        return finalResult;
    }

    /**
     * 加载首页文章
     */
    public LiveData<Resource<List<Article>>> loadArticles(int page) {

        return new NetworkBoundResource<List<Article>, DataHeader<ListDataHeader<Article>>>(appExecutors) {

            @Override
            protected void saveCallResult(@NonNull DataHeader<ListDataHeader<Article>> item) {
                if(item.getData() !=null){
                    List<Article> articles = item.getData().getDatas();
                    if(articles != null && !articles.isEmpty()){
                        db.beginTransaction();
                        try {
                            db.articleDao().insertArticles(articles);
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
                return data == null || data.isEmpty()
                        || repoListRateLimit.shouldFetch("articlelist");
            }

            @NonNull
            @Override
            protected LiveData<List<Article>> loadFromDb() {

                return db.articleDao().loadArticles();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> createCall() {
                return webService.loadArticles(page);
            }
        }.asLiveData();
    }



    /**
     * 获取公众号列表
     */
    public LiveData<Resource<List<WxArticleTitle>>> loadTitles() {

        return new NetworkBoundResource<List<WxArticleTitle>, DataHeader<List<WxArticleTitle>>>(appExecutors) {

            @Override
            protected void saveCallResult(@NonNull DataHeader<List<WxArticleTitle>> item) {
                if(item.getData() !=null){
                    List<WxArticleTitle> titles = item.getData();
                    if(titles != null && !titles.isEmpty()){
                        db.beginTransaction();
                        try {
                            db.titleDao().insertTitles(titles);
                            db.setTransactionSuccessful();
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            db.endTransaction();
                        }
                    }
                }

            }

            @Override
            protected boolean shouldFetch(@Nullable List<WxArticleTitle> data) {
                return data == null || data.isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<List<WxArticleTitle>> loadFromDb() {

                return db.titleDao().loadTitles();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<DataHeader<List<WxArticleTitle>>>> createCall() {
                return webService.loadWxArticleTitles();
            }
        }.asLiveData();
    }



    /**
     * 获取公众号历史文章列表
     */
    public LiveData<Resource<List<Article>>> loadWxArticles(String author,int titleId) {

        return new NetworkBoundResource<List<Article>, DataHeader<ListDataHeader<Article>>>(appExecutors) {

            @Override
            protected void saveCallResult(@NonNull DataHeader<ListDataHeader<Article>> item) {
                if(item.getData() !=null){
                    List<Article> articles = item.getData().getDatas();
                    if(articles != null && !articles.isEmpty()){
                        db.beginTransaction();
                        try {
                            db.articleDao().insertArticles(articles);
                            db.setTransactionSuccessful();
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            db.endTransaction();
                        }
                    }
                }

            }

            @Override
            protected boolean shouldFetch(@Nullable List<Article> data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<List<Article>> loadFromDb() {

                return db.articleDao().loadArticles(author);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> createCall() {
                return webService.loadWxArticles(titleId);
            }
        }.asLiveData();
    }
}
