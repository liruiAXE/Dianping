package com.example.administrator.dianping.acti;

import android.os.AsyncTask;
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
import com.example.administrator.dianping.enty.Category;
import com.example.administrator.dianping.utils.CategoryFetch;
import com.example.administrator.dianping.utils.MyUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class AllCatActivity extends AppCompatActivity {

    @ViewInject(R.id.cat_list)
    ListView cat_list_view;
    CatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cat);
        ViewUtils.inject(this);
        adapter=new CatAdapter();
        cat_list_view.setAdapter(adapter);
        for (int i=0;i<MyUtils.allCategorySum.length;i++){
            MyUtils.allCategorySum[i]=0;
        }
        new CatgetTask().execute(); 
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
            holder.price.setText(" "+MyUtils.allCategorySum[position]);
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
    class CatgetTask extends AsyncTask<Void,Void,List<Category>>{
        @Override
        protected void onPostExecute(List<Category> categories) {
             for (int i=0;i<MyUtils.allCategorySum.length;i++)
                 MyUtils.allCategorySum[i]=0;
             for (Category c:categories){
                 int pos=Integer.parseInt(c.getCategoryId());
                 MyUtils.allCategorySum[pos]=c.getCategoryNum();
             }
            adapter.notifyDataSetChanged();
        }

        @Override
        protected List<Category> doInBackground(Void... params) {
            return CategoryFetch.getCatList();
        }


    }

}
