package com.samir.wanandroid.ui.article.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.samir.wanandroid.entity.WxArticleTitle;
import com.samir.wanandroid.ui.article.ArticlePageFragment;

import java.util.List;

/**
 * @Description:
 */
public class ArticlePageAdapter extends FragmentStatePagerAdapter {

    private final  List<WxArticleTitle> wxArticleTitles;

    public ArticlePageAdapter(FragmentManager fm,List<WxArticleTitle> wxArticleTitles) {
        super(fm);
        this.wxArticleTitles = wxArticleTitles;
    }

    @Override
    public Fragment getItem(int position) {
        WxArticleTitle title = wxArticleTitles.get(position);
        return ArticlePageFragment.newInstance(title);
    }

    @Override
    public int getCount() {
        return wxArticleTitles == null?0:wxArticleTitles.size();
    }



    @Override
    public CharSequence getPageTitle(int position) {

        return wxArticleTitles.get(position).getName();
    }

}