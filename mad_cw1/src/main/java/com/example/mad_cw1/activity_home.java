package com.example.mad_cw1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class activity_home extends AppCompatActivity {

TextView _lbl1;

Button _btn1, _btn2, _btn3, _btn4;
Random rnd=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        _lbl1=(TextView) findViewById(R.id.lbl1);
        _btn1=(Button) findViewById(R.id.btn1);
        _btn2=(Button) findViewById(R.id.btn2);
        _btn3=(Button) findViewById(R.id.btn3);
        _btn4=(Button) findViewById(R.id.btn4);

        _btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int r = rnd.nextInt(251);
            int g = rnd.nextInt(15);
            int b = rnd.nextInt(150);
            _btn1.setBackgroundColor(Color.rgb(r,g,b));
            _lbl1.setText("Красный");
            }
        });

        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = rnd.nextInt(14);
                int g = rnd.nextInt(254);
                int b = rnd.nextInt(210);
                _btn2.setBackgroundColor(Color.rgb(r,g,b));
                _lbl1.setText("Синий");
            }
        });

        _btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = rnd.nextInt(73);
                int g = rnd.nextInt(122);
                int b = rnd.nextInt(87);
                _btn3.setBackgroundColor(Color.rgb(r,g,b));
                _lbl1.setText("Желтый");
            }
        });

        _btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = rnd.nextInt(240);
                int g = rnd.nextInt(191);
                int b = rnd.nextInt(8);
                _btn4.setBackgroundColor(Color.rgb(r,g,b));
                _lbl1.setText("Зеленый");
            }
        });
    }
}