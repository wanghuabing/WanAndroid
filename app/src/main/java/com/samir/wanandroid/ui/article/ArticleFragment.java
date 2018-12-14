package com.samir.wanandroid.ui.article;


import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.samir.framework.base.BaseFragment;
import com.samir.wanandroid.R;
import com.samir.wanandroid.databinding.MainFragmentBinding;
import com.samir.wanandroid.entity.Word;
import com.samir.wanandroid.di.Injectable;
import com.samir.wanandroid.net.RetryCallback;
import com.samir.wanandroid.ui.word.NewWordActivity;
import com.samir.wanandroid.ui.word.adapter.WordListAdapter;

import javax.inject.Inject;


public class ArticleFragment  extends BaseFragment<MainFragmentBinding> implements Injectable,
        RetryCallback {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private ArticleViewModel mArticleViewModel;


    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private WordListAdapter adapter;


    @Override
    public int loadLayout() {
        return R.layout.article_main;
    }

    @Override
    public void initViews(View view) {

    }

    @Override
    public void bindEvents() {

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mArticleViewModel = ViewModelProviders.of(this,viewModelFactory).get(ArticleViewModel.class);
        // TODO: Use the ViewModel

        mArticleViewModel.getAllWords().observe(this, words -> {
            // Update the cached copy of the words in the adapter.
            adapter.setWords(words);
        });


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        adapter = new WordListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        view.findViewById(R.id.fab).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NewWordActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
            mArticleViewModel.insert(word);
        } else {
            Toast.makeText(
                    getActivity(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void retry() {

    }
}
