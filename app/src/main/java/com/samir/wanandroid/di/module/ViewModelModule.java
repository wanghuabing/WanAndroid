package com.samir.wanandroid.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.samir.wanandroid.ui.article.ArticleViewModel;
import com.samir.wanandroid.ui.home.MainViewModel;
import com.samir.wanandroid.ui.me.MyViewModel;
import com.samir.wanandroid.ui.project.ProjectViewModel;
import com.samir.wanandroid.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mViewModel);



    @Binds
    @IntoMap
    @ViewModelKey(ArticleViewModel.class)
    abstract ViewModel bindArticleViewModel(ArticleViewModel mViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(ProjectViewModel.class)
    abstract ViewModel bindProjectViewModel(ProjectViewModel mViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel.class)
    abstract ViewModel bindMyViewModel(MyViewModel mViewModel);



    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
