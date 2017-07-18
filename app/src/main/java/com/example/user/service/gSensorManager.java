package com.example.user.service;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by User on 2017/7/13.
 */

public class gSensorManager extends Activity implements SensorEventListener {
    private TextView xSensor;
    private TextView ySensor;
    private TextView zSensor;
    private double eqGal;
    private SensorManager aSensorManager;
    private Sensor aSensor;
    public float gravity[] = new float[3];
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//
        xSensor = (TextView)findViewById(R.id.xSensor);
        ySensor = (TextView)findViewById(R.id.ySensor);
        zSensor = (TextView)findViewById(R.id.zSensor);

        aSensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        aSensor = aSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        aSensorManager.registerListener(this, aSensor, aSensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
// TODO Auto-generated method stub

    }
    @Override
    public void onSensorChanged(SensorEvent event) {
// TODO Auto-generated method stub
        gravity[0] = event.values[0];
        gravity[1] = event.values[1];
        gravity[2] = event.values[2];

    }
    @Override
    protected void onPause()
    {
// TODO Auto-generated method stub
/* 取消註冊SensorEventListener */
        aSensorManager.unregisterListener(this);
        Toast.makeText(this, "Unregister accelerometerListener", Toast.LENGTH_LONG).show();
        super.onPause();
    }


}
