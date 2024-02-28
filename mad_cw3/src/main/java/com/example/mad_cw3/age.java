package com.example.mad_cw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class age extends AppCompatActivity {

    RadioButton _rb1, _rb2, _rb3;
    int n = 10;
    String j="";
    Intent _intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        _rb1 = (RadioButton) findViewById(R.id.rb1);
        _rb2 = (RadioButton) findViewById(R.id.rb2);
        _rb3 = (RadioButton) findViewById(R.id.rb3);

        View.OnClickListener click_radio= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _intent = new Intent();
                if (v == _rb1) n+=5;
                if (v == _rb2) n+=15;
                if (v == _rb3) n+=10;
                j= String.valueOf(n);
                _intent.putExtra("age", j);
                setResult(RESULT_OK,_intent);
                finish();
            }
        };

        _rb1.setOnClickListener(click_radio);
        _rb2.setOnClickListener(click_radio);
        _rb3.setOnClickListener(click_radio);

    }
}