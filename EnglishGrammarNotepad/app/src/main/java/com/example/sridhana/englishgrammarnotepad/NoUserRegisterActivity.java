package com.example.sridhana.englishgrammarnotepad;

/**
 * Created by Sridhana on 3/17/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoUserRegisterActivity extends AppCompatActivity {

    public final static String REG_MESSAGE  = "REG_KEY";

    private SQLiteDBHandler db = new SQLiteDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_user_registration_layout);

        final Intent loginAppIntent = new Intent(this,MainActivity.class);

        final Button button = (Button) findViewById(R.id.registerButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText myNewUser =
                        (EditText) findViewById(R.id.userNameEditText);

                final EditText myNewPass =
                        (EditText) findViewById(R.id.passwordEditText);

                final EditText myNewEmail =
                        (EditText) findViewById(R.id.emailIdEditText);

                final EditText myNewPhone =
                        (EditText) findViewById(R.id.phoneEditText);

                final EditText myNewAddr =
                        (EditText) findViewById(R.id.addressEditText);

                final String newUser  = myNewUser.getText().toString();
                final String newPass  = myNewPass.getText().toString();
                final String newEmail = myNewEmail.getText().toString();
                final String newPhone = myNewPhone.getText().toString();
                final String newAddr  = myNewAddr.getText().toString();

                // Inserting user details
                Log.d("Insert: ", "Inserting new user ..");
                db.addAccDetails(new AccDetails(newUser, newPass,newEmail,newPhone,newAddr));


                String message = "User Registration Successful";
                loginAppIntent.putExtra(REG_MESSAGE, message);
                startActivity(loginAppIntent);


            }
        });

    }
}
