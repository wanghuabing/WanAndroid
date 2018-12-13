package com.samir.wanandroid.ui.project;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.samir.framework.base.BaseFragment;
import com.samir.wanandroid.R;
import com.samir.wanandroid.databinding.MainFragmentBinding;
import com.samir.wanandroid.di.Injectable;
import com.samir.wanandroid.net.RetryCallback;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment  extends BaseFragment<MainFragmentBinding> implements Injectable,
        RetryCallback {

    ProjectViewModel mViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    @Override
    public int loadLayout() {
        return R.layout.project_main;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity(),viewModelFactory).get(ProjectViewModel.class);
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
