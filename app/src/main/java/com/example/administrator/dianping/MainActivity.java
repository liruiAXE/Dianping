package com.example.administrator.dianping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.btn)
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
//        button=(Button)findViewById(R.id.btn);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getBaseContext(),"fuck",Toast.LENGTH_LONG).show();
//            }
//        });
    }
    @OnClick(R.id.btn)
    public void click(View view){
        Toast.makeText(getBaseContext(),"fuck",Toast.LENGTH_LONG).show();
    }
}
