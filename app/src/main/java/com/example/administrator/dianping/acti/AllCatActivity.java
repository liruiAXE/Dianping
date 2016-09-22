package com.example.administrator.dianping.acti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.dianping.R;
import com.example.administrator.dianping.utils.MyUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import org.w3c.dom.Text;

import java.util.HashMap;

public class AllCatActivity extends AppCompatActivity {

    @ViewInject(R.id.cat_list)
    ListView cat_list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cat);
        ViewUtils.inject(this);
        cat_list_view.setAdapter(new CatAdapter());
    }
    class CatAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return MyUtils.allCategray.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder=null;
            if (convertView==null){
                convertView= LayoutInflater.from(getBaseContext()).inflate(R.layout.cat_list_item,parent,false);
                holder=new Holder();
                ViewUtils.inject(holder,convertView);
                convertView.setTag(holder);
            } else {
                holder=(Holder)convertView.getTag();
            }
            holder.icon.setImageResource(MyUtils.allCategrayImages[position]);
            holder.name.setText(MyUtils.allCategray[position]);
            holder.price.setText("25000");
            return convertView;
        }
    }
    class Holder{
        @ViewInject(R.id.cat_icon)
        ImageView icon;
        @ViewInject(R.id.cat_name)
        TextView name;
        @ViewInject(R.id.cat_price)
        TextView price;
    }
}
