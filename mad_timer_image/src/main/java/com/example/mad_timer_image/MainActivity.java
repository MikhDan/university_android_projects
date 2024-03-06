package com.example.mad_timer_image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.telephony.BarringInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Period;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView _lbl1;
    Button _btnStart, _btnStop;
    ConstraintLayout _holst;

    ImageView _img;

    int sek=0;
    Timer _timer1, _timer2;
    TimerTask _task1, _task2;
    Random rnd = new Random();

    int[] arrImage = {R.drawable.blue, R.drawable.green, R.drawable.red, R.drawable.purp};

    float y, dy=10;

    ConstraintLayout.LayoutParams _lp;
    LayoutInflater _inf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btnStart = (Button) findViewById(R.id.btnStart);
        _btnStop = (Button) findViewById(R.id.btnStop);
        _lbl1 = (TextView) findViewById(R.id.lbl1);
        _holst = (ConstraintLayout) findViewById(R.id.holst);

        _btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    if (_timer1 != null) _timer1.cancel();
                    _timer1 = new Timer();
//                  _task1 = new Task1();
                TimerTask _taskp = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                _inf = LayoutInflater.from(MainActivity.this);
                                _img = (ImageView) _inf.inflate(R.layout.kartinka, null);
                                _img.setImageResource(R.drawable.purp);
                                int a = _holst.getWidth();
                                int b = _holst.getHeight();
                                _lp = new ConstraintLayout.LayoutParams(
                                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                                );
                                _lp.width= a/10;
                                _img.setLayoutParams(_lp);
                                _img.setX(rnd.nextInt(a- _lp.width));
                                _img.setY(rnd.nextInt(b - 200) + 25);
                                _holst.addView(_img);
//                                dy=10;
                                _img.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        _holst.removeView(v);
                                    }
                                });
                            }

                        });

                    }
                };
                    _timer1.schedule(_taskp, 0, 500);
                TimerTask _taskr = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                _inf = LayoutInflater.from(MainActivity.this);
                                _img = (ImageView) _inf.inflate(R.layout.kartinka, null);
                                _img.setImageResource(R.drawable.red);
                                int a = _holst.getWidth();
                                int b = _holst.getHeight();
                                _lp = new ConstraintLayout.LayoutParams(
                                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                                );
                                _lp.width= a/10;
                                _img.setLayoutParams(_lp);
                                _img.setX(rnd.nextInt(a- _lp.width));
                                _img.setY(rnd.nextInt(b - 200) + 25);
                                _holst.addView(_img);
//                                dy=1;
                                _img.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        _holst.removeView(v);
                                    }
                                });
                            }

                        });

                    }
                };
                _timer1.schedule(_taskr, 0, 250);

                TimerTask _taskb = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                _inf = LayoutInflater.from(MainActivity.this);
                                _img = (ImageView) _inf.inflate(R.layout.kartinka, null);
                                _img.setImageResource(R.drawable.blue);
                                int a = _holst.getWidth();
                                int b = _holst.getHeight();
                                _lp = new ConstraintLayout.LayoutParams(
                                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                                );
                                _lp.width= a/10;
                                _img.setLayoutParams(_lp);
                                _img.setX(rnd.nextInt(a- _lp.width));
                                _img.setY(rnd.nextInt(b - 200) + 25);
                                _holst.addView(_img);
//                                dy=50;
                                _img.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        _holst.removeView(v);
                                    }
                                });
                            }

                        });

                    }
                };
                _timer1.schedule(_taskb, 0, 1500);

                TimerTask _taskg = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                _inf = LayoutInflater.from(MainActivity.this);
                                _img = (ImageView) _inf.inflate(R.layout.kartinka, null);
                                _img.setImageResource(R.drawable.green);
                                int a = _holst.getWidth();
                                int b = _holst.getHeight();
                                _lp = new ConstraintLayout.LayoutParams(
                                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                                );
                                _lp.width= a/10;
                                _img.setLayoutParams(_lp);
                                _img.setX(rnd.nextInt(a- _lp.width));
                                _img.setY(rnd.nextInt(b - 200) + 25);
                                _holst.addView(_img);
//                               dy=100;
                                _img.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        _holst.removeView(v);
                                    }
                                });
                            }

                        });

                    }
                };
                _timer1.schedule(_taskg, 0, 3000);


                    if (_timer2 != null) _timer2.cancel();
                    _timer2 = new Timer();
                    _task2 = new Task2();

                    _timer2.schedule(_task2, 0, 100);
            }


        });

        _btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sek=0;
                _timer1.cancel();
                _timer1=null;
                _timer2.cancel();
                _timer2=null;
                _lbl1.setText(String.valueOf(sek));
                _holst.removeAllViews();
            }
        });


    }

//    class Task1 extends TimerTask{
//        @Override
//        public void run() {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    _inf = LayoutInflater.from(MainActivity.this);
//                    _img = (ImageView) _inf.inflate(R.layout.kartinka, null);
////                    _img.setImageResource(arrImage[rnd.nextInt(4)]);
//                    resId=arrImage[rnd.nextInt(4)];
//                    _img.setImageResource(resId);
//                    int a = _holst.getWidth();
//                    int b = _holst.getHeight();
//                    _lp = new ConstraintLayout.LayoutParams(
//                            ConstraintLayout.LayoutParams.WRAP_CONTENT,
//                            ConstraintLayout.LayoutParams.WRAP_CONTENT
//                    );
//                    _lp.width= a/10;
//                    _img.setLayoutParams(_lp);
//                    _img.setX(rnd.nextInt(a- _lp.width));
//                    _img.setY(rnd.nextInt(b - 200) + 25);
//                    _holst.addView(_img);
//                    _img.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            _holst.removeView(v);
//                        }
//                    });
//                }
//
//            });
//
//        }
//    }

    class Task2 extends TimerTask{
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    _lbl1.setText(String.valueOf(_holst.getChildCount()));
                    for (int i =0; i<_holst.getChildCount(); i++) {
                        y=_holst.getChildAt(i).getY();
                        dy=rnd.nextFloat()*50;
                        y+=dy;
                        _holst.getChildAt(i).setY(y);
                        if(y>_holst.getHeight()-50)
                          _holst.removeViewAt(i);
                    }

                }
            });
        }
    }


}