package com.example.roomarchcomponent.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomarchcomponent.entity.Word;

@Database(entities = {Word.class}
, version = 1
)
abstract public class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao ();

    private static WordRoomDatabase INSTANCE;
    static WordRoomDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "name_db.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();

        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{

        private final WordDao mDao;

        private PopulateDbAsync(WordRoomDatabase mDao) {
            this.mDao = mDao.wordDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // delete semua data dalam tabel ketika apps di install
            mDao.deleteAll();

            Word word = new Word("Misalnya Insert Data Manual");

            mDao.insert(word);
            word = new Word("data di isi lagi");
            mDao.insert(word);


            return null;
        }
    }

}
