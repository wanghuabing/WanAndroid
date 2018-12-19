package com.samir.wanandroid.ui.article;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.samir.wanandroid.entity.Article;
import com.samir.wanandroid.entity.WxArticleTitle;
import com.samir.wanandroid.entity.common.Resource;
import com.samir.wanandroid.repository.ArticleRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * @Description:
 */
public class ArticleViewModel extends ViewModel {


    private final ArticleRepository articleRepository;

    @Inject
    public ArticleViewModel(ArticleRepository mWordRepository) {
        super();
        this.articleRepository = mWordRepository;


    }


    public LiveData<Resource<List<WxArticleTitle>>> loadArticleTitles() {

        return  articleRepository.loadTitles();
    }



    public LiveData<Resource<List<Article>>> loadWxArticles(String author,int titleId) {

        return  articleRepository.loadWxArticles(author,titleId);
    }

    public void retry() {

    }
}
