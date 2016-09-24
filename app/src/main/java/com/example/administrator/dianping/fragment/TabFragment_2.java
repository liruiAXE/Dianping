package com.example.administrator.dianping.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.dianping.R;
import com.example.administrator.dianping.enty.Goods;
import com.example.administrator.dianping.utils.CategoryFetch;
import com.example.administrator.dianping.utils.CityFetch;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TabFragment_2 extends Fragment {
    private static String TAG="tabf2";
    @ViewInject(R.id.goods_list)
    ListView listView;
    List<Goods> goodsList=new ArrayList<>();
    MyAdapter adapter=new MyAdapter();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("tabf1","f2 onCreateView");
        // Inflate the layout for this TabFragment_3
        View view=inflater.inflate(R.layout.fragment_fragment_2, container, false);
        ViewUtils.inject(this,view);
        listView.setAdapter(adapter);
        loadDates();
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("tabf1","f2 onstart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("tabf1","f2 onstop");
    }
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return goodsList.size();
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
            MyHolder holder=new MyHolder();
            if (convertView==null){
                convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.goods_list_item,parent,false);
                ViewUtils.inject(holder,convertView);
                convertView.setTag(holder);
            } else {
                holder=(MyHolder) convertView.getTag();
            }
            Goods goods=goodsList.get(position);
            holder.short_title.setText(goods.getShort_title());
            holder.title.setText(goods.getTitle());
            holder.price.setText(Integer.toString(goods.getPrice()));
            holder.value.setText(Integer.toString(goods.getValue()));
            holder.sum.setText(Integer.toString(goods.getSum()));
            Picasso.with(getContext()).load(goods.getImage_url()).into(holder.pic);
            return convertView;
        }
    }
    class MyHolder{
        @ViewInject(R.id.good_pic)
        ImageView pic;
        @ViewInject(R.id.good_short_title)
        TextView short_title;
        @ViewInject(R.id.good_title)
        TextView title;
        @ViewInject(R.id.good_price)
        TextView price;
        @ViewInject(R.id.good_value)
        TextView value;
        @ViewInject(R.id.good_sum)
        TextView sum;
    }
    private int page=1,size=7;
    private String url= CityFetch.BASE_URL+"goods";
    private void loadDates(){
        Log.i(TAG,"onLoadDates");
        RequestParams params=new RequestParams();
        params.addQueryStringParameter("page",page+"");
        params.addQueryStringParameter("size",size+"");
        new HttpUtils().send(HttpRequest.HttpMethod.GET, url, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String jsonStr=responseInfo.result;
                Log.i(TAG,"onSuccesss");
                Log.i(TAG,"jsonStr : "+jsonStr);
                try {
                    JSONObject object=new JSONObject(jsonStr);
                    Log.i(TAG,"where1");
                    JSONArray dates=object.getJSONArray("dates");
                    Log.i(TAG,"where2");
                    Type type=new TypeToken<List<Goods>>(){}.getType();
                    Log.i(TAG,"where3");
                    List<Goods> li=(new Gson()).fromJson(dates.toString(),type);
                    Log.i(TAG,"where4");
                    goodsList.clear();
                    goodsList.addAll(li);
                    adapter.notifyDataSetChanged();
                } catch(JSONException e){
                    Log.i(TAG,"JSONException e");
                }

            }

            @Override
            public void onFailure(HttpException e, String s) {
                Log.i(TAG,"onFailure!!!");
            }
        });
    }
}
