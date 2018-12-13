package com.samir.wanandroid.ui.me;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.samir.framework.base.BaseFragment;
import com.samir.wanandroid.R;
import com.samir.wanandroid.databinding.MainFragmentBinding;
import com.samir.wanandroid.di.Injectable;
import com.samir.wanandroid.net.RetryCallback;

import javax.inject.Inject;


public class MyFragment extends BaseFragment<MainFragmentBinding> implements Injectable,
        RetryCallback {

    MyViewModel mViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    @Override
    public int loadLayout() {
        return R.layout.my_main;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity(),viewModelFactory).get(MyViewModel.class);
        // TODO: Use the ViewModel
    }


    @Override
    public void initViews(View view) {

    }

    @Override
    public void bindEvents() {

    }


    @Override
    public void retry() {

    }
}
