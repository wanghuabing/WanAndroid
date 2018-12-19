package com.samir.wanandroid.ui.article;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.samir.framework.base.BaseFragment;
import com.samir.wanandroid.R;
import com.samir.wanandroid.databinding.ArticleMainBinding;
import com.samir.wanandroid.di.Injectable;
import com.samir.wanandroid.net.RetryCallback;
import com.samir.wanandroid.ui.article.adapter.ArticlePageAdapter;


public class ArticleFragment  extends BaseFragment<ArticleViewModel,ArticleMainBinding>
        implements Injectable, RetryCallback {
    private ArticlePageAdapter adapter;
    @Override
    public int loadLayout() {
        return R.layout.article_main;
    }

    @Override
    public Class<ArticleViewModel> loadViewModel() {
        return ArticleViewModel.class;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.tabs.setupWithViewPager(mBinding.pager);
        mBinding.tabs.setTabMode (TabLayout.MODE_SCROLLABLE);
    }



    @Override
    public void loadData() {
        mViewModel.loadArticleTitles().observe(this, listResource -> {
            adapter = new ArticlePageAdapter(getFragmentManager(),listResource.data);
            mBinding.pager.setAdapter(adapter);
        });
    }

    @Override
    public void retry() {

    }
}
