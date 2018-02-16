package com.example.sridhana.englishgrammarnotepad;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String WELCOME_MESSAGE = "WELCOME_KEY";
    public final static String NOUSER_MESSAGE  = "NOUSER_KEY";

    private SQLiteDBHandler db = new SQLiteDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Intent welcomeIntent   = new Intent(this,DisplayMessageActivity.class);
        final Intent nouserIntent    = new Intent(this,NoUserActivity.class);
        final Intent nouserRegIntent = new Intent(this,NoUserRegisterActivity.class);


        final Button button = (Button) findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(nouserRegIntent);

            }
        });


        final Button button1 = (Button) findViewById(R.id.signIn);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final EditText myNewUser1 =
                        (EditText) findViewById(R.id.userNameEditText);

                final EditText myNewPass1 =
                        (EditText) findViewById(R.id.passwordEditText);

                final String newUser = myNewUser1.getText().toString();
                final String newPass = myNewPass1.getText().toString();

                // Reading all AccDetails
                Log.d("Reading: ", "Loading all AccDetails.");
                List<AccDetails> AccsDetails = db.getAllAccDetails();

                if(AccsDetails.isEmpty())
                {
                    System.out.println("No users in the list");
                }
                else
                {
                    for (AccDetails AccDetails : AccsDetails) {

                        if(AccDetails.getName().equals(newUser) && AccDetails.getAddress().equals(newPass))
                        {
                            String log = "Id: " + AccDetails.getId() + " ,Name: " + AccDetails.getName() + " ,Address: " + AccDetails.getAddress();
                            Log.d("AccDetails: : ", log);

                            String message = "Welcome "+newUser+"!";
                            welcomeIntent.putExtra(WELCOME_MESSAGE, message);
                            startActivity(welcomeIntent);

                        }
                        else
                        {
                            String message = "No such user as "+newUser+" .Click below to register";
                            nouserIntent.putExtra(NOUSER_MESSAGE, message);
                            startActivity(nouserIntent);

                            String log = "Id: " + newUser;
                            Log.d("No User: : ", log);

                        }

                    }

                }

            }
        });

        Intent intent = getIntent();
        String message = intent.getStringExtra(NoUserRegisterActivity.REG_MESSAGE);
        TextView textView =(TextView) findViewById(R.id.registerSuccessMsg);
        textView.setTextSize(20);
        textView.setText(message);

    }
}

