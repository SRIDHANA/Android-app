package com.example.sridhana.englishgrammarnotepad;

/**
 * Created by Sridhana on 3/17/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_message_layout);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.WELCOME_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.display_message_layout);
        layout.addView(textView);
    }
}