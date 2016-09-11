package com.example.administrator.dianping;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;

public class GuideAct extends AppCompatActivity {
    @ViewInject(R.id.pager)
    ViewPager viewPager;
    @ViewInject(R.id.welcome_guide_btn)
    Button enter_btn;
    List<View> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ViewUtils.inject(this);
        initViewPager();
        viewPager.setAdapter(new MyPagerViewAdapter());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==2){
                    enter_btn.setVisibility(View.VISIBLE);
                } else {
                    enter_btn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    class MyPagerViewAdapter extends PagerAdapter{


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
    private void initViewPager(){
        list=new ArrayList<>();
        ImageView imageView1=new ImageView(this);
        imageView1.setImageResource(R.drawable.g1);
        imageView1.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView imageView2=new ImageView(this);
        imageView2.setImageResource(R.drawable.g2);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView imageView3=new ImageView(this);
        imageView3.setImageResource(R.drawable.g3);
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);

        list.add(imageView1);
        list.add(imageView2);
        list.add(imageView3);
    }
    @OnClick(R.id.welcome_guide_btn)
    public void click(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
