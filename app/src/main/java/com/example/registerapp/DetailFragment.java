package com.example.registerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class DetailFragment extends Fragment {
    TextInputEditText ed1,ed2;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String UName = "unameKey";
    public static final String Email = "emailKey";
    public static final String Passwrd = "passwrdlKey";
    SharedPreferences sharedpreferences;
    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_details, container, false);

        ed1=(TextInputEditText)view.findViewById(R.id.username);
        ed2=(TextInputEditText)view.findViewById(R.id.email);
       // ed3=(TextInputEditText)view.findViewById(R.id.passs);
        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String n  = sharedpreferences.getString(UName,"");
        String ph  = sharedpreferences.getString(Email,"");
       // String e  = sharedpreferences.getString(Passwrd,"");
        ed1.setText(n);
        ed2.setText(ph);
     //   ed3.setText(e);

return view;
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_details, container, false);
    }
}



