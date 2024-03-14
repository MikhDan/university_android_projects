package com.example.mad_starik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button _btnUp, _btnDown, _btnLeft, _btnRight, _btnStart, _btnStop;
    TextView _lbl1;
    ImageView _imgStarik, _imgRybka, _img;
    ConstraintLayout _holst;
    ConstraintLayout.LayoutParams _layparam;
    Random rnd = new Random();
    int x, y, _width, _height;
    float dX, dY, xStarik, yStarik, xFish, yFish;
    Timer _timer1;
    TimerTask _task1;
    boolean b_fish1, b_fish2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _lbl1 = (TextView) findViewById(R.id.lbl1);
        _imgStarik = (ImageView) findViewById(R.id.imgStarik);
        _imgRybka = (ImageView) findViewById(R.id.imgRybka);
        _btnUp = (Button) findViewById(R.id.btnUp);
        _btnDown = (Button) findViewById(R.id.btnDown);
        _btnLeft = (Button) findViewById(R.id.btnLeft);
        _btnRight = (Button) findViewById(R.id.btnRight);
        _btnStart = (Button) findViewById(R.id.btnStart);
        _btnStop = (Button) findViewById(R.id.btnStop);
        _holst = (ConstraintLayout) findViewById(R.id.holst);

        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        _width = display.getWidth();
        _height = display.getHeight();
        _imgStarik.getLayoutParams().width = _width / 5;

        _imgStarik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Старый дед", Toast.LENGTH_SHORT).show();
            }
        });

        _imgStarik.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        _btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _imgStarik.setY(_imgStarik.getY() + 10);
                xFish=_img.getX();
                yFish=_img.getY();
                boolean b_fish1 = (_imgStarik.getX() - 200) < xFish && _imgStarik.getX() + 220 > xFish;
                boolean b_fish2 = (_imgStarik.getY()-200) < yFish && _imgStarik.getY() + 220 > yFish;
                if (b_fish1 && b_fish2)
                    Toast.makeText(MainActivity.this, "Поймал!", Toast.LENGTH_SHORT).show();
            }
        });
        _btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _imgStarik.setY(_imgStarik.getY() - 10);
                xFish=_img.getX();
                yFish=_img.getY();
                boolean b_fish1 = (_imgStarik.getX() - 200) < xFish && _imgStarik.getX() + 220 > xFish;
                boolean b_fish2 = (_imgStarik.getY()-200) < yFish && _imgStarik.getY() + 220 > yFish;
                if (b_fish1 && b_fish2)
                    Toast.makeText(MainActivity.this, "Поймал!", Toast.LENGTH_SHORT).show();
            }
        });
        _btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _imgStarik.setX(_imgStarik.getX() - 10);
                xFish=_img.getX();
                yFish=_img.getY();
                boolean b_fish1 = (_imgStarik.getX() - 200) < xFish && _imgStarik.getX() + 220 > xFish;
                boolean b_fish2 = (_imgStarik.getY()-200) < yFish && _imgStarik.getY() + 220 > yFish;
                if (b_fish1 && b_fish2)
                    Toast.makeText(MainActivity.this, "Поймал!", Toast.LENGTH_SHORT).show();
            }
        });
        _btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _imgStarik.setX(_imgStarik.getX() + 10);
                xFish=_img.getX();
                yFish=_img.getY();
                boolean b_fish1 = (_imgStarik.getX() - 200) < xFish && _imgStarik.getX() + 220 > xFish;
                boolean b_fish2 = (_imgStarik.getY()-200) < yFish && _imgStarik.getY() + 220 > yFish;
                if (b_fish1 && b_fish2)
                    Toast.makeText(MainActivity.this, "Поймал!", Toast.LENGTH_SHORT).show();
            }
        });

        _btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_timer1 != null) _timer1.cancel();
                _timer1 = new Timer();
                _task1 = new Task1();
                _timer1.schedule(_task1, 0, 1500);
            }
        });
        _btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a =50;
                float b = 650;
                _timer1.cancel();
                _timer1=null;
                _imgStarik.setX(a);
                _imgStarik.setY(b);
            }
        });



        _imgRybka.setTag("fish");

        for (int i = 0; i < 5; i++) {
            x = rnd.nextInt((_width - 300) - 100) + 100;
            y = rnd.nextInt((_height - 800) - 200) + 200;
            _img = new ImageView(this);
            _img.setTag("i=" + i);
            _layparam = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT);
            _layparam.width = _width / 10;
            _layparam.setMargins(x, y, 0, 0);
            _img.setImageResource(R.drawable.fish);
            _img.setLayoutParams(_layparam);
            _img.setX(x);
            _img.setY(y);
            _holst.addView(_img);
            image_move(_img);
            image_move(_imgRybka);
        }
    }

    class Task1 extends TimerTask{
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    xStarik = rnd.nextInt((_width - 100) - 100) + 100;
                    yStarik = rnd.nextInt((_height - 800) - 200) + 200;
                    _imgStarik.setX(xStarik);
                    _imgStarik.setY(yStarik);
                    xFish=_img.getX();
                    yFish=_img.getY();
                    boolean b_fish1 = (xStarik - 200) < xFish && xStarik + 220 > xFish;
                    boolean b_fish2 = (yStarik-200) < yFish && yStarik + 220 > yFish;
                    if (b_fish1 && b_fish2)
                        Toast.makeText(MainActivity.this, "Поймал!", Toast.LENGTH_SHORT).show();

                }

            });

        }
    }

    @SuppressLint("ClickableAccessibility")
    public void image_move(ImageView img) {
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX=v.getX()-event.getRawX();
                        dY=v.getY()-event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        v.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        xFish = v.getX();
                        yFish = v.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        _lbl1.setText(String.valueOf(img.getTag()));
                        boolean b_fish1 = (_imgStarik.getX() - 100) < xFish && _imgStarik.getX() + 120 > xFish;
                        boolean b_fish2 = (_imgStarik.getY()) < yFish && _imgStarik.getY() + 120 > yFish;
                        if (b_fish1 && b_fish2)
                            Toast.makeText(MainActivity.this, "Поймал!", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;

            }
        });

    }
}

