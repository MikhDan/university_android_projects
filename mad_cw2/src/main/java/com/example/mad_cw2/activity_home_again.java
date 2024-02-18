package com.example.mad_cw2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class activity_home_again extends AppCompatActivity {
TextView _lbl1, _lbl2;
Button _btn1, _btn2, _btn3;
Random rnd = new Random();
int n = 0, k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_again);
        _lbl1 = (TextView) findViewById(R.id.lbl1);
        _lbl2 = (TextView) findViewById(R.id.lbl2);
        _btn1 = (Button) findViewById(R.id.btn1);
        _btn2 = (Button) findViewById(R.id.btn2);
        _btn3 = (Button) findViewById(R.id.btn3);

        View.OnClickListener click_btn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = rnd.nextInt(80);
                k = rnd.nextInt(80) ;
                _lbl1.setText(String.valueOf(n));
                _lbl2.setText(String.valueOf(k));
                _btn1.setEnabled(false);
                _btn2.setBackgroundColor(Color.parseColor("#A5E8E8"));
                _btn3.setBackgroundColor(Color.parseColor("#A5E8E8"));
                _btn2.setEnabled(true);
                _btn3.setEnabled(true);
            }
        };
        _btn1.setOnClickListener(click_btn);


        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                int b;
                a =Integer.valueOf((String)_lbl1.getText());
                b =Integer.valueOf((String)_lbl2.getText());
                if (a > b) {
                    _btn2.setBackgroundColor(Color.GREEN);
                    _btn1.setEnabled(true);
                    _btn3.setEnabled(false);
                    _btn2.setEnabled(false);

                } else {
                    _btn2.setBackgroundColor(Color.RED);
                    _btn1.setEnabled(true);
                    _btn3.setEnabled(false);
                    _btn2.setEnabled(false);
                }
            }
        });


        _btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                int b;
                a =Integer.valueOf((String)_lbl1.getText());
                b =Integer.valueOf((String)_lbl2.getText());
                if (b > a) {
                    _btn3.setBackgroundColor(Color.GREEN);
                    _btn1.setEnabled(true);
                    _btn3.setEnabled(false);
                    _btn2.setEnabled(false);

                } else {
                    _btn3.setBackgroundColor(Color.RED);
                    _btn1.setEnabled(true);
                    _btn2.setEnabled(false);
                    _btn3.setEnabled(false);
                }
            }
        });

    }
}