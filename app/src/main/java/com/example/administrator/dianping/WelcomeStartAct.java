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
        Timer timer=new Timer();
        timer.schedule(new Task(),3000);
    }
    class Task extends TimerTask{
        @Override
        public void run() {
            Intent intent=new Intent(getApplicationContext(),GuideAct.class);
            startActivity(intent);
        }
    }
}
