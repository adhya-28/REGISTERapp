package com.example.registerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class UserLogin extends AppCompatActivity {
    Button b1, b2;
    TextInputEditText user, pass;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String UName = "unameKey";

    public static final String Passwrd = "passwrdKey";
    SharedPreferences sharedpreferences;
    String uName ;
    String uPassword ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        user = (TextInputEditText) findViewById(R.id.txt_user);
        pass = (TextInputEditText) findViewById(R.id.txt_passwrd);
        b1 = (Button) findViewById(R.id.btnlogin);
        b2 = (Button) findViewById(R.id.btn_sign_in);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String username = user.getText().toString();
                        final String password = pass.getText().toString();
                        if (sharedpreferences.contains("unameKey")) {
                            uName = sharedpreferences.getString("unameKey", "");

                        }

                        if (sharedpreferences.contains("passwrdKey")) {
                            uPassword = sharedpreferences.getString("passwrdKey", "");

                        }

                        // Validate if username, password is filled
                        if (username.trim().length() > 0 && password.trim().length() > 0) {



                            if (username.equals(uName) && password.equals(uPassword)) {

                                Intent log_intent = new Intent(getApplicationContext(), Home.class);
                                startActivity(log_intent);
                            } else {
                                Toast.makeText(UserLogin.this, "Incorrect Password or username", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });




        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), user_reg.class);
                startActivity(i);
            }
        });
    }


}