package com.example.roomarchcomponent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomarchcomponent.R;
import com.example.roomarchcomponent.entity.Word;

import java.util.Collections;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private final LayoutInflater mInflater;
    private List<Word> mWords = Collections.emptyList();

    public WordAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = mInflater.inflate(R.layout.item_adapter, parent, false);

        return new WordViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.WordViewHolder holder, int position) {
        Word current = mWords.get(position);
        holder.tvWord.setText(current.getWord());
    }

    public void extsetWords (List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder{
        private TextView tvWord;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);

            tvWord = itemView.findViewById(R.id.tv_word);
        }

    }
}
