package com.example.roomarchcomponent.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.roomarchcomponent.entity.Word;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAphabetWord();
    }

    public LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }

    // method insert
    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao mASynctaskDao;
        insertAsyncTask(WordDao dao){
            mASynctaskDao = dao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mASynctaskDao.insert(words[0]);
            return null;
        }
    }
}
