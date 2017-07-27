package com.example.yuta.thefirstapp;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import  android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private Button buttonPushMe;
    private ImageView imageAndroid;

    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;

     Boolean aBoolean=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPushMe = (Button) findViewById(R.id.btn_pushme);
        buttonPushMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aBoolean==true) {
                    aBoolean=false;
                    buttonPushMe.setText("ボタンが押されました");
                    imageAndroid.setImageResource(R.drawable.droid2);
                }else if (aBoolean==false){
                    aBoolean=true;
                    imageAndroid.setImageResource(R.drawable.droid1);
                }
            }
        });
        imageAndroid = (ImageView) findViewById(R.id.iv_android);

        seekBarRed = (SeekBar) findViewById(R.id.sd_red);
        seekBarRed.setOnSeekBarChangeListener(this);

        seekBarGreen = (SeekBar) findViewById(R.id.sd_green);
        seekBarGreen.setOnSeekBarChangeListener(this);

        seekBarBlue = (SeekBar) findViewById(R.id.sd_blue);
        seekBarBlue.setOnSeekBarChangeListener(this);

    }
    @Override
    public  void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){

        int red = seekBarRed.getProgress();
        int green = seekBarGreen.getProgress();
        int bule = seekBarBlue.getProgress();

        imageAndroid.setColorFilter(Color.rgb(red,green,bule));

    }
    @Override
    public  void onStartTrackingTouch(SeekBar seekBar){

    }
    @Override
    public  void onStopTrackingTouch(SeekBar seekBar){

    }
}
