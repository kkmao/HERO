package com.example.user.service;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
//import java.util.logging.Handler;

/**
 * Created by User on 2017/7/11.
 */

public class MyService extends Service implements SensorEventListener {
    private Timer timer = null;
    private int countTime;
    private int stopTime;
    public double eqGal;
    public ArrayList<Double> eqGalData = new ArrayList<Double>();

    private SensorManager aSensorManager;
    private Sensor aSensor;
    public float gravity[] = new float[3];

    public TextView sum;



    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "服務啟動中", Toast.LENGTH_SHORT).show();
        timer = new Timer();
        countTime = 0;
        aSensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        aSensor = aSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        aSensorManager.registerListener(this, aSensor, aSensorManager.SENSOR_DELAY_NORMAL);
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer.schedule(task, 1000, 10000);
        Bundle bundle = intent.getExtras();
        stopTime = Integer.parseInt(bundle.getString("stoptime"));

        Toast.makeText(this, "服務開始", Toast.LENGTH_SHORT).show();
        return START_NOT_STICKY;
    }

    public void onDestory() {
        Toast.makeText(this, "end", Toast.LENGTH_SHORT).show();
        timer.cancel();
        timer.purge();
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            Toast.makeText(MyService.this, (String) msg.obj, Toast.LENGTH_SHORT).show();
        }
    };



    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            countTime += 30;
            if (countTime / 60 == stopTime) {
                stopForeground(true);
                final int notifyID = 1; // 通知的識別號碼
                final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                final Notification notification = new Notification.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.bomb).setContentTitle("kkmao").setContentText("congratulation").build(); // 建立通知
                notificationManager.notify(notifyID,notification); // 發送通知

                PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
                boolean isScreenOn = pm.isScreenOn();
                Log.e("screen on.........", ""+isScreenOn);
                if(isScreenOn==false)
                {
                    PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK |PowerManager.ACQUIRE_CAUSES_WAKEUP |PowerManager.ON_AFTER_RELEASE,"MyLock");
                    wl.acquire(10000);
                    PowerManager.WakeLock wl_cpu = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"MyCpuLock");
                    wl_cpu.acquire(10000);
                }
            } else {
                handler.sendMessage(
                        Message.obtain(handler, 0, "已執行" + countTime / 60 + "minutes" + countTime % 60 + "second")
                );
            }


//            eqGal = Math.abs((Math.sqrt(Math.pow(gravity[0], 2) + Math.pow(gravity[1], 2) + Math.pow(gravity[2], 2)) - 9.81) * 100);
//            Log.d("mytag",""+eqGal);
//            eqGalData.add(eqGal);
//            if (eqGalData.size() == 2) {
//                if (eqGalData.get(1) / eqGalData.get(0) > Math.pow(Math.sqrt(10), 2)) {
//                    handler.sendMessage(
//                        Message.obtain(handler, 0, (int)eqGal)
//                    );
//                }
//                eqGalData.remove(0);
//            } else if (eqGalData.size() < 2) {
//                eqGalData.remove(0);
//
//            }

        }
    };

    @Override
    public void onSensorChanged(SensorEvent event) {
        gravity[0] = event.values[0];
        gravity[1] = event.values[1];
        gravity[2] = event.values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
