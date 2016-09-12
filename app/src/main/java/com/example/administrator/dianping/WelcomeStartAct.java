package com.example.administrator.dianping;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.dianping.utils.SharedUtils;

import java.util.Timer;
import java.util.TimerTask;

import static java.security.AccessController.getContext;

public class WelcomeStartAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_start);
        Timer timer=new Timer();
        timer.schedule(new Task(),500);
    }
    class Task extends TimerTask{
        @Override
        public void run() {
            if (SharedUtils.isFirstEntry(getBaseContext())){
                Intent intent=new Intent(getBaseContext(),GuideAct.class);
                startActivity(intent);
                SharedUtils.setFirstEntry(getBaseContext(),false);
            } else {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);

            }

            finish();
        }
    }
}
