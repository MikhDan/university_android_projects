package com.example.mad_cw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class crash extends AppCompatActivity {
    CheckBox _chcr, _chfi;
    Button _btnb;
    int n = 15, k, l;
    String s1 ="", s2="";
    Intent _intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
        _chcr = (CheckBox) findViewById(R.id.chcr);
        _chfi = (CheckBox) findViewById(R.id.chfi);
        _btnb = (Button) findViewById(R.id.btnback);


        View.OnClickListener clickcheck = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               _intent = new Intent();
               if (_chcr.isChecked()) {k=n+20; l=0; s1= String.valueOf(k); s2= String.valueOf(l);}
               if (_chfi.isChecked()) {k=0; l=n+10; s1= String.valueOf(k); s2= String.valueOf(l);}
               if (_chcr.isChecked() && _chfi.isChecked()) {k=n+20; l=n+10; s1= String.valueOf(k); s2= String.valueOf(l);}


            }
        };

        _chcr.setOnClickListener(clickcheck);
        _chfi.setOnClickListener(clickcheck);
//
      _btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _intent.putExtra("crash", s1);
                _intent.putExtra("fine", s2);
                setResult(RESULT_OK,_intent);
                finish();
            }
      });

   }


}