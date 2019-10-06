package com.example.roomarchcomponent.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomarchcomponent.database.WordRepository;
import com.example.roomarchcomponent.entity.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application){
        super(application);
        wordRepository = new WordRepository(application);
        mAllWords = wordRepository.getmAllWords();
    }

    public LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }

    public void insert (Word word){
        wordRepository.insert(word);
    }
}
