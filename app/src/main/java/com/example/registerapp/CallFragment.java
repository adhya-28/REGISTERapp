package com.example.registerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class CallFragment extends Fragment {
    Button btnSMS,btnCall;
    public CallFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_call, container, false);

        btnCall=(Button)view.findViewById(R.id.btn_call);
        btnSMS=(Button)view.findViewById(R.id.btn_sms);


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call_intent=new Intent(getActivity(),CallActivity.class);
                startActivity(call_intent);



            }
        });
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sms_intent=new Intent(getActivity(),SmsActivity.class);
                startActivity(sms_intent);

            }
        });

        return  view;
    }

}

