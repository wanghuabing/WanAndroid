package com.samir.wanandroid.ui.article;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.samir.wanandroid.entity.Word;
import com.samir.wanandroid.repository.WordRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * @Description:
 */
public class ArticleViewModel extends ViewModel {
    private WordRepository mWordRepository;

    private LiveData<List<Word>> mAllWords;


    @Inject
    public ArticleViewModel(WordRepository mWordRepository) {
        super();
        this.mWordRepository = mWordRepository;
        mAllWords = mWordRepository.getAllWords();
    }


    public LiveData<List<Word>> getAllWords(){return mAllWords;}


    public void insert(Word word){ mWordRepository.insert(word);}
}
