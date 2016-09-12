package com.example.administrator.dianping;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.dianping.fragment.TabFragment_1;
import com.example.administrator.dianping.fragment.TabFragment_2;
import com.example.administrator.dianping.fragment.TabFragment_3;
import com.example.administrator.dianping.fragment.TabFragment_4;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.db.converter.BooleanColumnConverter;
import com.lidroid.xutils.view.annotation.ViewInject;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    Fragment f1,f2,f3,f4;
    @ViewInject(R.id.index)
    RadioButton mainRadiuBtn;
    @ViewInject(R.id.label)
    RadioButton labelRadioBtn;
    @ViewInject(R.id.history)
    RadioButton histRadioBtn;
    @ViewInject(R.id.aboutme)
    RadioButton aboutMRadioBtn;
    @ViewInject(R.id.tab_group)
    RadioGroup group;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        f1=new TabFragment_1();
        f2=new TabFragment_2();
        f3=new TabFragment_3();
        f4=new TabFragment_4();
        fragmentManager=getSupportFragmentManager();
        mainRadiuBtn.setChecked(true);
        initFragment(f1,false);

        group.setOnCheckedChangeListener(this);


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.index:
                initFragment(f1,true);
                break;
            case R.id.label:
                initFragment(f2,true);
                break;
            case R.id.history:
                initFragment(f3,true);
                break;
            case R.id.aboutme:
                initFragment(f4,true);
                break;
            default:
                return;
        }
    }
    private void initFragment(Fragment fragment, Boolean isAddtoStack){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content,fragment,fragment.getClass().getName());
        if (isAddtoStack)
          transaction.addToBackStack(null);
        transaction.commit();
    }
    private void upDateTabs(){
        if (fragmentManager.findFragmentByTag(TabFragment_1.class.getName())!=null){
            mainRadiuBtn.setChecked(true);
        }
        if (fragmentManager.findFragmentByTag(TabFragment_2.class.getName())!=null){
            labelRadioBtn.setChecked(true);
        }
        if (fragmentManager.findFragmentByTag(TabFragment_3.class.getName())!=null){
            histRadioBtn.setChecked(true);
        }
        if (fragmentManager.findFragmentByTag(TabFragment_4.class.getName())!=null){
            aboutMRadioBtn.setChecked(true);
        }
    }
}
