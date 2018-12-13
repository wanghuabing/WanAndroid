package com.samir.wanandroid.ui.home;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.samir.framework.base.BaseFragment;
import com.samir.wanandroid.R;
import com.samir.wanandroid.databinding.MainFragmentBinding;
import com.samir.wanandroid.di.Injectable;
import com.samir.wanandroid.net.RetryCallback;
import com.samir.wanandroid.ui.home.adapter.ArticleAdapter;

import java.util.Collections;

import javax.inject.Inject;

public class MainFragment extends BaseFragment<MainFragmentBinding> implements Injectable,
        RetryCallback {

    private MainViewModel mViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private ArticleAdapter adapter;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public int loadLayout() {
        return R.layout.main_fragment;
    }

    @Override
    public void initViews(View view) {
        mBinding.refreshLayout.setOnRefreshListener(refreshlayout -> {

        });

        mBinding.refreshLayout.setOnLoadmoreListener(refreshlayout -> {

        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));


        adapter = new ArticleAdapter(getActivity());
        mBinding.rvNews.setAdapter(adapter);


    }

    @Override
    public void bindEvents() {

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity(),viewModelFactory).get(MainViewModel.class);
        // TODO: Use the ViewModel
        loadArticles();
    }


    private void loadArticles() {
        mViewModel.loadArticles().observe(this, listResource -> {
            // we don't need any null checks here for the adapter since LiveData guarantees that
            // it won't call us if fragment is stopped or not started.
            Log.e("MainFragment", "loadArticles: " +listResource.data );
            if (listResource != null && listResource.data != null) {
                adapter.replace(listResource.data);
            } else {
                //noinspection ConstantConditions
                adapter.replace(Collections.emptyList());
            }
        });
    }


    @Override
    public void retry() {

    }
}
