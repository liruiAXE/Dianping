package com.example.administrator.dianping;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeStartAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_start);
//        new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message msg) {
//                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
//                return true;
//            }
//        }).sendEmptyMessageDelayed(0,3000);
        Timer timer=new Timer();
        timer.schedule(new Task(),3000);
    }
    class Task extends TimerTask{
        @Override
        public void run() {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            Intent i;
        }
    }
}
