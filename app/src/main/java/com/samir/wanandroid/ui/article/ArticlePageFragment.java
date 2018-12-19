package com.samir.wanandroid.ui.article;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.samir.framework.base.BaseFragment;
import com.samir.wanandroid.R;
import com.samir.wanandroid.databinding.RvLoadingBinding;
import com.samir.wanandroid.di.Injectable;
import com.samir.wanandroid.entity.WxArticleTitle;
import com.samir.wanandroid.net.RetryCallback;
import com.samir.wanandroid.ui.home.adapter.ArticleAdapter;

import java.util.Collections;

/**
 * @author: Samir
 * @date: 2018/12/18 上午11:49
 */
public class ArticlePageFragment extends BaseFragment<ArticleViewModel,RvLoadingBinding>
        implements Injectable , RetryCallback {

    public static final String ARG_ARTICLE_TITLE = "ATITLE";

    private WxArticleTitle wxArticleTitle;
    private ArticleAdapter adapter;

    public static ArticlePageFragment newInstance(WxArticleTitle param) {
        ArticlePageFragment fragment = new ArticlePageFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ARTICLE_TITLE, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int loadLayout() {
        return R.layout.rv_loading;
    }


    @Override
    public Class<ArticleViewModel> loadViewModel() {
        return ArticleViewModel.class;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ArticleAdapter(getActivity());
        mBinding.rvList.setAdapter(adapter);

    }

    @Override
    public void loadData() {
        if (getArguments() != null) {
            wxArticleTitle = getArguments().getParcelable(ARG_ARTICLE_TITLE);
        }
        loadWxArticlesInTitle();
    }

    /**
     * 获取公账号历史文章列表
     */
    public void loadWxArticlesInTitle(){
        if(wxArticleTitle == null)
            return ;
        mViewModel.loadWxArticles(wxArticleTitle.getName(),wxArticleTitle.getId())
                .observe(this, listResource -> {
            mBinding.setLoadResource(listResource);
            if (listResource.data != null && !listResource.data.isEmpty()) {
                adapter.replace(listResource.data);
            } else {
                adapter.replace(Collections.emptyList());
            }
        });
    }


    @Override
    public void bindEvents() {
        mBinding.setRetryCallback(() ->mViewModel.retry());
    }


    @Override
    public void retry() {

    }
}
