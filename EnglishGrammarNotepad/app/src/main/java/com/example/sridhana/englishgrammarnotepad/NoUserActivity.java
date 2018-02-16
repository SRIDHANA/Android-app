package com.example.sridhana.englishgrammarnotepad;

/**
 * Created by Sridhana on 3/17/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class NoUserActivity extends AppCompatActivity {

    public final static String REG_MESSAGE = "NOUSER_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_user_layout);

        final Intent nouserRegIntent = new Intent(this,NoUserRegisterActivity.class);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.NOUSER_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.no_user_layout);
        layout.addView(textView);

        final Button button = (Button) findViewById(R.id.registerNoUsr);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = "Registration page";
                nouserRegIntent.putExtra(REG_MESSAGE, message);
                startActivity(nouserRegIntent);
            }
        });

    }
}
