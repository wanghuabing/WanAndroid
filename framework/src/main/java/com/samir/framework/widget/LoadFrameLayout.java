package com.samir.framework.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.samir.framework.R;


/**
 * @Description:
 */
public class LoadFrameLayout extends FrameLayout {
    @LayoutRes
    private int mEmptyViewLayoutResId;
    @LayoutRes
    private int mErrorViewLayoutResId;
    @LayoutRes
    private int mLoadingViewLayoutResId;
    @LayoutRes
    private int mNetWorkViewLayoutResId;


    public LoadFrameLayout(Context context) {
        this(context, null);
    }

    public LoadFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.LoadFrameLayout, defStyleAttr, 0);
        try {
            mEmptyViewLayoutResId = a.getResourceId(
                    R.styleable.LoadFrameLayout_emptyView, -1);
            mErrorViewLayoutResId = a.getResourceId(
                    R.styleable.LoadFrameLayout_errorView, -1);
            mNetWorkViewLayoutResId = a.getResourceId(
                    R.styleable.LoadFrameLayout_netWorkView, -1);
            mLoadingViewLayoutResId = a.getResourceId(
                    R.styleable.LoadFrameLayout_loadingView, -1);
        } finally {
            a.recycle();
        }

        showLoadingView();
    }


    public void showEmptyView() {
        if(getTag() !=null){
            int viewId = (int) getTag();
            if(viewId != mEmptyViewLayoutResId){
                View emptyView = LayoutInflater.from(getContext()).inflate(mEmptyViewLayoutResId,
                        this, false);
                addView(emptyView);
                setTag(mEmptyViewLayoutResId);
            }
        }else{
            View emptyView = LayoutInflater.from(getContext()).inflate(mEmptyViewLayoutResId,
                    this, false);
            addView(emptyView);
            setTag(mEmptyViewLayoutResId);
        }
    }

    public void showErrorView() {
        if(getTag() !=null){
            int viewId = (int) getTag();
            if(viewId != mErrorViewLayoutResId){
                View emptyView = LayoutInflater.from(getContext()).inflate(mErrorViewLayoutResId,
                        this, false);
                addView(emptyView);
                setTag(mErrorViewLayoutResId);
            }
        }else{
            View emptyView = LayoutInflater.from(getContext()).inflate(mErrorViewLayoutResId,
                    this, false);
            addView(emptyView);
            setTag(mErrorViewLayoutResId);
        }
    }

    public void showNetWorkView() {
        if(getTag() !=null){
            int viewId = (int) getTag();
            if(viewId != mNetWorkViewLayoutResId){
                View emptyView = LayoutInflater.from(getContext()).inflate(mNetWorkViewLayoutResId,
                        this, false);
                addView(emptyView);
                setTag(mNetWorkViewLayoutResId);
            }
        }else{
            View emptyView = LayoutInflater.from(getContext()).inflate(mNetWorkViewLayoutResId,
                    this, false);
            addView(emptyView);
            setTag(mNetWorkViewLayoutResId);
        }
    }

    public void showLoadingView() {
        if(getTag() !=null){
            int viewId = (int) getTag();
            if(viewId != mLoadingViewLayoutResId){
                View emptyView = LayoutInflater.from(getContext()).inflate(mLoadingViewLayoutResId,
                        this, false);
                addView(emptyView);
                setTag(mLoadingViewLayoutResId);
            }
        }else{
            View emptyView = LayoutInflater.from(getContext()).inflate(mLoadingViewLayoutResId,
                    this, false);
            addView(emptyView);
            setTag(mLoadingViewLayoutResId);
        }
    }

    public void showContentView() {
        removeAllViews();
        setVisibility(View.GONE);
    }
}
