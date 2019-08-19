package com.example.registerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class user_reg extends AppCompatActivity {
Button b1;
TextView blogin;
    TextInputEditText ed1,ed2,ed3;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String UName = "unameKey";
    public static final String Email = "emailKey";
    public static final String Passwrd = "passwrdKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg);
        blogin=(TextView) findViewById(R.id.btn_login);
        ed1=(TextInputEditText) findViewById(R.id.uname);
        ed2=(TextInputEditText)findViewById(R.id.Email);
        ed3=(TextInputEditText)findViewById(R.id.pass);

       b1=(Button)findViewById(R.id.btn_signup);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u  = ed1.getText().toString();
                String e  = ed2.getText().toString();
                String p  = ed3.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();


                editor.putString(UName, u);
                editor.putString(Email, e);
                editor.putString(Passwrd, p);
                editor.commit();
                Toast.makeText(user_reg.this,"Successfully saved", Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),Home.class);
                startActivity(i);
            }
        });

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),UserLogin.class);
                startActivity(i);
            }
        });

    }
}
