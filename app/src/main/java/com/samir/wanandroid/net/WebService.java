package com.samir.wanandroid.net;

import android.arch.lifecycle.LiveData;

import com.samir.wanandroid.entity.Article;
import com.samir.wanandroid.entity.WxArticleTitle;
import com.samir.wanandroid.entity.ProjectType;
import com.samir.wanandroid.entity.common.ApiResponse;
import com.samir.wanandroid.entity.common.DataHeader;
import com.samir.wanandroid.entity.common.ListDataHeader;
import com.samir.wanandroid.entity.ArticleTree;
import com.samir.wanandroid.entity.AdData;
import com.samir.wanandroid.entity.User;
import com.samir.wanandroid.entity.HotKeyWord;
import com.samir.wanandroid.entity.Website;
import com.samir.wanandroid.entity.WxArticleList;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
/**
 * WebService
 */
public interface WebService {

    String HOST = "http://www.wanandroid.com/";

    @GET("users/{login}")
    LiveData<ApiResponse<User>> getUser(@Path("login") String login);

    /**
     * 获取首页文章列表
     *
     * @param page 页数 pageNum = page + 1
     * @return 文章列表数据
     */
    @GET("article/list/{page}/json")
    LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> loadArticles(@Path("page") int page);




    /**
     * 获取公众号列表
     * @return 微信公账号列表
     */
    @GET("wxarticle/chapters/json ")
    LiveData<ApiResponse<DataHeader<List<WxArticleTitle>>>> loadWxArticleTitles();



    /**
     * 获取公众号历史文章列表
     *
     * @param titleId 页数
     * @return 文章列表数据
     */
    @GET("wxarticle/list/{id}/1/json ")
    LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> loadWxArticles(@Path("id")  int titleId);


    /**
     * 搜索
     * http://www.wanandroid.com/article/query/0/json
     * @param page page
     * @param k POST search key
     * @return 搜索数据
     */
    @POST("article/query/{page}/json")
    @FormUrlEncoded
    LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> getSearchList(@Path("page") int page, @Field("k") String k);

    /**
     * 热搜
     * http://www.wanandroid.com//hotkey/json
     *
     * @return 热门搜索数据
     */
    @GET("hotkey/json")
    @Headers("Cache-Control: public, max-age=36000")
    LiveData<DataHeader<List<HotKeyWord>>> getTopSearchData();

    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     *
     * @return 常用网站数据
     */
    @GET("friend/json")
    LiveData<DataHeader<List<Website>>> getUsefulSites();

    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return 广告栏数据
     */
    @GET("banner/json")
    LiveData<DataHeader<List<AdData>>> getBannerData();

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     *
     * @return 知识体系数据
     */
    @GET("tree/json")
    LiveData<DataHeader<List<ArticleTree>>> getKnowledgeHierarchyData();

    /**
     * 知识体系下的文章
     * http://www.wanandroid.com/article/list/0?cid=60
     *
     * @param page page num
     * @param cid second page id
     * @return 知识体系feed文章数据
     */
    @GET("article/list/{page}/json")
    LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> getKnowledgeHierarchyDetailData(@Path("page") int page, @Query("cid") int cid);

    /**
     * 导航
     * http://www.wanandroid.com/navi/json
     *
     * @return 导航数据
     */
    @GET("navi/json")
    LiveData<DataHeader<List<WxArticleList>>> getNavigationListData();

    /**
     * 项目分类
     * http://www.wanandroid.com/project/tree/json
     *
     * @return 项目分类数据
     */
    @GET("project/tree/json")
    LiveData<DataHeader<List<ProjectType>>> getProjectClassifyData();

    /**
     * 项目类别数据
     * http://www.wanandroid.com/project/list/1/json?cid=294
     *
     * @param page page num
     * @param cid second page id
     * @return 项目类别数据
     */
    @GET("project/list/{page}/json")
    LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> getProjectListData(
            @Path("page") int page, @Query("cid") int cid);

    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return 登陆数据
     */
    @POST("user/login")
    @FormUrlEncoded
    LiveData<DataHeader<User>> getLoginData(@Field("username") String username, @Field("password") String password);

    /**
     * 注册
     * http://www.wanandroid.com/user/register
     *
     * @param username user name
     * @param password password
     * @param repassword re password
     * @return 注册数据
     */
    @POST("user/register")
    @FormUrlEncoded
    LiveData<DataHeader<User>> getRegisterData(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    /**
     * 收藏站内文章
     * http://www.wanandroid.com/lg/collect/1165/json
     *
     * @param id article id
     * @return 收藏站内文章数据
     */
    @POST("lg/collect/{id}/json")
    LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> addCollectArticle(@Path("id") int id);

    /**
     * 收藏站外文章
     * http://www.wanandroid.com/lg/collect/add/json
     *
     * @param title title
     * @param author author
     * @param link link
     * @return 收藏站外文章数据
     */
    @POST("lg/collect/add/json")
    @FormUrlEncoded
    LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> addCollectOutsideArticle(
               @Field("title") String  title, @Field("author") String author,
               @Field("link") String link);


    /**
     * 获取收藏列表
     * http://www.wanandroid.com/lg/collect/list/0/json
     *
     * @param page page number
     * @return 收藏列表数据
     */
    @GET("lg/collect/list/{page}/json")
    LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> getCollectList(@Path("page") int page);

    /**
     * 取消站内文章
     * http://www.wanandroid.com/lg/uncollect_originId/2333/json
     *
     * @param id article id
     * @param originId origin id
     * @return 取消站内文章数据
     */
    @POST("lg/uncollect/{id}/json")
    @FormUrlEncoded
    LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> cancelCollectPageArticle(@Path("id") int id,
                                                                       @Field("originId") int originId);

    /**
     * 取消收藏页面站内文章
     * http://www.wanandroid.com/lg/uncollect_originId/2333/json
     *
     * @param id article id
     * @param originId origin id
     * @return 取消收藏页面站内文章数据
     */
    @POST("lg/uncollect_originId/{id}/json")
    @FormUrlEncoded
    LiveData<ApiResponse<DataHeader<ListDataHeader<Article>>>> cancelCollectArticle(@Path("id") int id, @Field("originId") int originId);

}
