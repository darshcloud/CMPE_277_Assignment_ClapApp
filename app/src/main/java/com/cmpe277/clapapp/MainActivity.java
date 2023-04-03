package com.cmpe277.clapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mProximitySensor;
    private MediaPlayer mMediaPlayer;
    private TextView clapText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clapText = findViewById(R.id.clapText);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mProximitySensor =  mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.clap_sound);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float distance = sensorEvent.values[0];
        if(distance <= 5){
            mMediaPlayer.start();
            clapText.setText("Clapping has Started!!!");
        }else{
            clapText.setText("Clapping has Stopped!!!");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}