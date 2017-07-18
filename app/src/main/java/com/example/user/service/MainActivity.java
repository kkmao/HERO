package com.example.user.service;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart = (Button)findViewById(R.id.btnStart);
//        btnStart.setOnClickListener(new StartButtonClickListener());





        Intent intent = new Intent(MainActivity.this,MyService.class);
        intent.putExtra("stoptime", "1");
        startService(intent);

    }


//    private class StartButtonClickListener implements View.OnClickListener {
//    public void onClick(View v){
//        Intent intent = new Intent(MainActivity.this,MyService.class);
//        EditText stopCount = (EditText)findViewById(R.id.stopCount);

//        startService(intent);
//    }
//    }
}
//public class SmsReceiver extends BroadcastReceiver {
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        String action = intent.getAction();
//        if(action.equals("android.provider.Telephony.SMS_RECEIVED")){
//            //action for sms received
//
//            // start service here
//            Intent intentS = new Intent(context,MyService.class);
//            intentS.putExtra("stoptime", 1);
//            context.startService(intentS);
//        }
////        else {
////
////        }
//    }

