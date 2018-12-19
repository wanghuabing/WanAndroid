package com.samir.wanandroid.ui.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.samir.wanandroid.entity.common.Resource;
import com.samir.wanandroid.entity.Article;
import com.samir.wanandroid.repository.ArticleRepository;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private  LiveData<Resource<List<Article>>> articles;

    private final  ArticleRepository articleRepository;
    @Inject
    public MainViewModel(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public LiveData<Resource<List<Article>>> loadArticles(int page) {
        articles = articleRepository.loadArticles(page);

        return articles;
    }

    public LiveData<Resource<List<Article>>> loadArticlesNew(int page) {
        articles = articleRepository.loadArticlesNew(page);

        return articles;
    }
}
