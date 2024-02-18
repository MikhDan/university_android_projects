package com.example.mad_cw2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView _lbl1, _lbl2;
    Button _btn;
    ImageButton _btn1, _btn2;
    AnimationDrawable _animright, _animwrong;
    Random rnd = new Random();
    int n = 0, k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _lbl1 = (TextView) findViewById(R.id.txt1);
        _lbl2 = (TextView) findViewById(R.id.txt2);
        _btn = (Button) findViewById(R.id.btn);
        _btn1 = (ImageButton) findViewById(R.id.btn1);
        _btn2 = (ImageButton) findViewById(R.id.btn2);
        _btn1.setBackgroundResource(R.drawable.smile);
        _btn1.setImageDrawable(null);
        _btn2.setBackgroundResource(R.drawable.smile);
        _btn2.setImageDrawable(null);



        View.OnClickListener click_btn = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                n = rnd.nextInt(80);
                k = rnd.nextInt(80);
                _lbl1.setText(String.valueOf(n));
                _lbl2.setText(String.valueOf(k));
                _btn.setEnabled(false);
                _btn1.setBackgroundResource(R.drawable.smile);
                _btn2.setBackgroundResource(R.drawable.smile);
            }
        };
        _btn.setOnClickListener(click_btn);

        _btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                int b;
                a =Integer.valueOf((String)_lbl1.getText());
                b =Integer.valueOf((String)_lbl2.getText());
                if (a > b) {
                    _btn1.setBackgroundResource(R.drawable.animright);
                    _animright = (AnimationDrawable) _btn1.getBackground();
                    _animright.setOneShot(false);
                    _btn.setEnabled(true);
                    _animright.stop();
                    _animright.start();

                } else {
                    _btn1.setBackgroundResource(R.drawable.animwrong);
                    _animwrong = (AnimationDrawable) _btn1.getBackground();
                    _animwrong.setOneShot(false);
                    _btn.setEnabled(true);
                    _animwrong.stop();
                    _animwrong.start();

                }
            }
        });


        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                int b;
                a =Integer.valueOf((String)_lbl1.getText());
                b =Integer.valueOf((String)_lbl2.getText());
                if (b > a) {
                    _btn2.setBackgroundResource(R.drawable.animright);
                    _animright = (AnimationDrawable) _btn2.getBackground();
                    _animright.setOneShot(false);
                    _btn.setEnabled(true);
                    _animright.stop();
                    _animright.start();

                } else {
                    _btn2.setBackgroundResource(R.drawable.animwrong);
                    _animwrong = (AnimationDrawable) _btn2.getBackground();
                    _animwrong.setOneShot(false);
                    _btn.setEnabled(true);
                    _animwrong.stop();
                    _animwrong.start();

                }
            }
        });




    };





}