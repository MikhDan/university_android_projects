package com.example.mad_cw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class car extends AppCompatActivity {
    FrameLayout _frm1, _frm2, _frm3;
    int n = 100;
    String  j="";
    Intent _intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        _frm1 = (FrameLayout) findViewById(R.id.frm1);
        _frm2 = (FrameLayout) findViewById(R.id.frm2);
        _frm3 = (FrameLayout) findViewById(R.id.frm3);



        View.OnClickListener click_frm= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _intent = new Intent();
                if (v == _frm1) n+=10;
                if (v == _frm2) n+=15;
                if (v == _frm3) n+=20;
                j= String.valueOf(n);
                _intent.putExtra("car", j);
                setResult(RESULT_OK,_intent);
                finish();
            }
        };

        _frm1.setOnClickListener(click_frm);
        _frm2.setOnClickListener(click_frm);
        _frm3.setOnClickListener(click_frm);



    }
}