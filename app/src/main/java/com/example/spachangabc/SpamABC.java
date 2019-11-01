package com.example.spachangabc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.os.IBinder;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.util.Random;

public class SpamABC extends Service implements SensorEventListener {
    private SensorManager mSensorManager ;
    private Sensor mAccelerometer ;
    private float mAccel ;
    private float mAccelCurrent ;
    private float mAccelLaest ;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE );
        mAccelerometer = mSensorManager .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this,mAccelerometer,SensorManager.SENSOR_DELAY_UI);
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
    float x = event.values[0];
    float y = event.values[1];
    float z = event.values[2];
    mAccelLaest = mAccelCurrent ;
    mAccelCurrent = (float) Math.sqrt((double)( x*x + y*y + z*z ));
    float delta  = mAccelCurrent - mAccelLaest ;
    mAccel = mAccel * 0.9f + delta ;

    if( mAccel > 11 ){

      Random ran = new Random();
       int colorA = Color.argb(255,ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
       MainActivity.square.setBackgroundColor(colorA);
    }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
