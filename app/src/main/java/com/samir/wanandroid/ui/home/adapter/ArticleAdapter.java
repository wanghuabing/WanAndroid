package com.samir.wanandroid.ui.home.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.samir.framework.base.BaseAdapter;
import com.samir.wanandroid.R;
import com.samir.wanandroid.binding.DefaultBindingComponent;
import com.samir.wanandroid.databinding.ArticleListItemBinding;
import com.samir.wanandroid.entity.Article;

/**
 * @Description:
 */
public class ArticleAdapter extends BaseAdapter<Article,ArticleListItemBinding> {

    private final Context context;

    public ArticleAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected ArticleListItemBinding createBinding(ViewGroup parent, int viewType) {
        DefaultBindingComponent defaultBindingComponent = new DefaultBindingComponent(context);
        ArticleListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.article_list_item,
                        parent, false,defaultBindingComponent);

        binding.getRoot().setOnClickListener(v -> {

        });
        return binding;
    }

    @Override
    protected void bind(ArticleListItemBinding binding, Article item) {
        binding.setArticle(item);
    }

    @Override
    protected boolean areItemsTheSame(Article oldItem, Article newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    protected boolean areContentsTheSame(Article oldItem, Article newItem) {
        return oldItem.getId() == newItem.getId()
                && oldItem.getTitle().equals(newItem.getTitle());
    }


}
