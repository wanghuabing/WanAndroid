package com.samir.wanandroid.ui.project;


import android.support.v4.app.Fragment;

import com.samir.framework.base.BaseFragment;
import com.samir.wanandroid.R;
import com.samir.wanandroid.databinding.ProjectMainBinding;
import com.samir.wanandroid.di.Injectable;
import com.samir.wanandroid.net.RetryCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment  extends BaseFragment<ProjectViewModel,ProjectMainBinding> implements Injectable,
        RetryCallback {

    @Override
    public int loadLayout() {
        return R.layout.project_main;
    }

    @Override
    public Class<ProjectViewModel> loadViewModel() {
        return ProjectViewModel.class;
    }




    @Override
    public void bindEvents() {

    }


    @Override
    public void retry() {

    }
}
