package com.samir.wanandroid.ui.home;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.samir.framework.base.BaseFragment;
import com.samir.wanandroid.R;
import com.samir.wanandroid.databinding.RvLoadingBinding;
import com.samir.wanandroid.di.Injectable;
import com.samir.wanandroid.ui.home.adapter.ArticleAdapter;

import java.util.Collections;

import javax.inject.Inject;

public class MainFragment extends BaseFragment<MainViewModel,RvLoadingBinding> implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private ArticleAdapter adapter;

    private int curPage = 0;

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public int loadLayout() {
        return R.layout.rv_loading;
    }

    @Override
    public Class<MainViewModel> loadViewModel() {
        return MainViewModel.class;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.rvList.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new ArticleAdapter(getActivity());
        mBinding.rvList.setAdapter(adapter);
    }


    @Override
    public void bindEvents() {
        mBinding.refreshLayout.setOnRefreshListener(layout -> {
            curPage = 0;
            loadArticles();
        });

        mBinding.refreshLayout.setOnLoadmoreListener(layout -> {
            curPage++;
            loadArticles();
        });


        mBinding.setRetryCallback(() -> {
            loadArticles();
        });
    }


    @Override
    public void loadData() {
        loadArticles();
    }


    private void loadArticles() {
        mViewModel.loadArticlesNew(curPage).observe(this, listResource -> {
            if (curPage == 0) {
                mBinding.refreshLayout.finishRefresh();
            } else {
                mBinding.refreshLayout.finishLoadmore();
            }
            mBinding.setLoadResource(listResource);
            if (listResource.data != null && !listResource.data.isEmpty()) {
                adapter.replace(listResource.data);
            } else {
                adapter.replace(Collections.emptyList());
            }
        });
    }



}
