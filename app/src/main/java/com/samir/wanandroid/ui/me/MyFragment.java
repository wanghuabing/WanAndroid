package com.samir.wanandroid.ui.me;

import com.samir.framework.base.BaseFragment;
import com.samir.wanandroid.R;
import com.samir.wanandroid.databinding.MyMainBinding;
import com.samir.wanandroid.di.Injectable;
import com.samir.wanandroid.net.RetryCallback;


public class MyFragment extends BaseFragment<MyViewModel,MyMainBinding> implements Injectable,
        RetryCallback {

    @Override
    public int loadLayout() {
        return R.layout.my_main;
    }

    @Override
    public Class<MyViewModel> loadViewModel() {
        return MyViewModel.class;
    }


    @Override
    public void bindEvents() {

    }


    @Override
    public void retry() {

    }
}
