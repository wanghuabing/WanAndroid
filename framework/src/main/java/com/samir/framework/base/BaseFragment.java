package com.samir.framework.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Description:
 */
public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment{

    protected T mBinding;

    public abstract int  loadLayout();

    public abstract void initViews(View view);

    public abstract void bindEvents();

    public void loadData(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,loadLayout(), container, false);
        return mBinding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        bindEvents();
        loadData();
    }



}
