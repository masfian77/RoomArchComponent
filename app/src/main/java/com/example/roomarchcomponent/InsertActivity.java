package com.example.roomarchcomponent;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    EditText edtInsert;
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnInsert = (Button) findViewById(R.id.btn_insert);
        edtInsert = (EditText) findViewById(R.id.edt_insert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(edtInsert.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = edtInsert.getText().toString();
                    replyIntent.putExtra("WORD", word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }

}
