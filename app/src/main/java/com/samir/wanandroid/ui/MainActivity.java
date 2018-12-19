package com.samir.wanandroid.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samir.framework.adapter.FragmentPagerAdapter;
import com.samir.framework.base.BaseActivity;
import com.samir.wanandroid.R;
import com.samir.wanandroid.ui.article.ArticleFragment;
import com.samir.wanandroid.ui.home.MainFragment;
import com.samir.wanandroid.ui.me.MyFragment;
import com.samir.wanandroid.ui.project.ProjectFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener
        ,HasSupportFragmentInjector,View.OnClickListener{
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    /*底部按钮布局容器*/
    LinearLayout llBottom;
    /*标题工具栏*/
    Toolbar      mToolbar;
    /*标题栏 页面Title*/
    TextView     tvTitle;
    /* 页面 ViewPager 容器 */
    ViewPager    mViewPager;


    @Override
    public int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mToolbar =  findViewById(R.id.toolbar);
        llBottom = findViewById(R.id.llBottom);
        tvTitle    = findViewById(R.id.tvTitle);
        mViewPager = findViewById(R.id.mViewPager);

        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        changeFragmentState(0);

        initViewPage();
    }



    private void initViewPage(){
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(MainFragment.newInstance());
        fragmentList.add(new ArticleFragment());
        fragmentList.add(new ProjectFragment());
        fragmentList.add(new MyFragment());
        FragmentPagerAdapter mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager(),
                fragmentList);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(this);

    }


    @Override
    public void bindEvents() {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_home:
                changeFragmentState(0);
                break;
            case R.id.tv_article:
                changeFragmentState(1);
                break;
            case R.id.tv_project:
                changeFragmentState(2);
                break;
            case R.id.tv_my:
                changeFragmentState(3);
                break;
        }

    }


    /*
    * 切换底部按钮选中状态
    * */
    private void changeFragmentState(int pageIndex) {
        //change Fragment
        mViewPager.setCurrentItem(pageIndex);

        int childCount = llBottom.getChildCount();
        if(pageIndex <0 || pageIndex >childCount){
            return;
        }
        for(int childIndex =0; childIndex < childCount;childIndex++){
            View child = llBottom.getChildAt(childIndex);
            child.setSelected(false);
        }
        llBottom.getChildAt(pageIndex).setSelected(true);

        //设置标题栏
        setTitleBar(pageIndex);
    }


    /*
    * 设置对应页面标题栏Title
    * */
    private void setTitleBar(int pageIndex){
        switch (pageIndex){
            case 0:
                tvTitle.setText(R.string.tabbar_home);
                break;
            case 1:
                tvTitle.setText(R.string.tabbar_teach);
                break;
            case 2:
                tvTitle.setText(R.string.tabbar_manage);
                break;
            case 3:
                tvTitle.setText(R.string.tabbar_me);
                break;
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        changeFragmentState(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
