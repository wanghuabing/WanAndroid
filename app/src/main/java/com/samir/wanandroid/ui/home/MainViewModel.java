package com.samir.wanandroid.ui.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.samir.wanandroid.net.entity.Resource;
import com.samir.wanandroid.ui.home.entity.Article;

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


    public LiveData<Resource<List<Article>>> loadArticles() {
        articles = articleRepository.loadArticles();

        return articles;
    }
}
