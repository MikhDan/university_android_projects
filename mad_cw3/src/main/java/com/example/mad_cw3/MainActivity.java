package com.example.mad_cw3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText _txtcountres;
    Button _btncar, _btnage, _btncrash, _btncount;
    static private int code =0;
    static String s=" ", a="", b="", c="", d="", e="", a1="", b1="", c1="", d1="";
    int m;
    Intent _intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btncar = (Button) findViewById(R.id.btncar);
        _btnage = (Button) findViewById(R.id.btnage);
        _btncrash = (Button) findViewById(R.id.btncrash);
        _btncount = (Button) findViewById(R.id.btncount);
        _txtcountres = (EditText) findViewById(R.id.countresult);



        _btncar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code=0;
                _intent= new Intent(getApplication(), car.class);

                startActivityForResult(_intent, code);

            }
        });

        _btnage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code=1;
                _intent= new Intent(getApplication(), age.class);
                startActivityForResult(_intent, code);
            }
        });

        _btncrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code=2;
                _intent= new Intent(getApplication(), crash.class);
                startActivityForResult(_intent, code);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0)
            if(resultCode==RESULT_OK)
            {

                a= data.getStringExtra("car");
                a1="Наценка за машину: " +a;

            }
            else a1= "error 1111111";


        if(requestCode==1)
            if(resultCode==RESULT_OK)
            {

                b=data.getStringExtra("age");
                b1="Наценка за возраст: " +b;
            }
            else b1= "error 2222222";


        if(requestCode==2)
            if(resultCode==RESULT_OK)
            {

                c=data.getStringExtra("crash");
                c1="Наценка за аварии: " +c;
                d=data.getStringExtra("fine");
                d1="Наценка за штрафы: " +d;
            }
            else c1= "error 3333333";



        _btncount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=a1+ "\n"+b1+ "\n"+c1+ "\n"+ d1 + "\n";
                m = Integer.parseInt(a)+Integer.parseInt(b)+Integer.parseInt(c)+Integer.parseInt(d);
                e = "Итог: "+ String.valueOf(m);
                _txtcountres.setText(s+e);
            }
        });


    }
}