package com.samir.framework.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

/**
 * @Description:
 */
public abstract class BaseFragment<V extends ViewModel,T extends ViewDataBinding> extends Fragment{

    @Inject
    protected ViewModelProvider.Factory viewModelFactory;

    protected V mViewModel;

    protected T mBinding;

    // 获取布局视图
    public abstract int  loadLayout();

    //ViewModel
    public Class<V>  loadViewModel(){ return null; }

    //事件绑定
    public  void bindEvents() {}

    //数据加载
    public void loadData(){}




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,loadLayout(), container, false);
        return mBinding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindEvents();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Class<V>  mClass = loadViewModel();
        if(mClass != null ){
            mViewModel = ViewModelProviders.of(getActivity(),viewModelFactory).get(loadViewModel());
        }
        loadData();
    }

}
