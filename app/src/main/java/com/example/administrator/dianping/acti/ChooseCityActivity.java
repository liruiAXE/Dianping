package com.example.administrator.dianping.acti;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.dianping.R;
import com.example.administrator.dianping.enty.City;
import com.example.administrator.dianping.utils.CityFetch;
import com.example.administrator.dianping.utils.SharedUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.SyncHttpHandler;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChooseCityActivity extends AppCompatActivity {
    private static String TAG="ChooseCity";
    @ViewInject(R.id.list_choose)
    private ListView chooseList;
    private List<City> choose_cityList=new ArrayList<>();
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);
        ViewUtils.inject(this);
        listAdapter=new ListAdapter(choose_cityList);
        chooseList.setAdapter(listAdapter);
        chooseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=choose_cityList.get(position).getCity_name();
                Intent intent=new Intent();
                intent.putExtra("CITY_NAME",name);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
        if (SharedUtils.isCityListAva(getBaseContext())){
            String jsonStr= SharedUtils.getCityListJsonStr(getBaseContext());
            List<City> list=new Gson().fromJson(jsonStr,new TypeToken<List<City>>(){}.getType());
            choose_cityList.clear();
            choose_cityList.addAll(list);
            listAdapter.notifyDataSetChanged();
            Log.i(TAG,"ShareUtils in ...");
        } else {
            new CityGetTask().execute();
        }

    }

    class CityGetTask extends AsyncTask<Void,Void,List<City>>{
        @Override
        protected List<City> doInBackground(Void... params) {
            List<City> list= CityFetch.getCityList(CityFetch.CITY_URL);
            return list;
        }

        @Override
        protected void onPostExecute(List<City> cityList) {
            Log.i(TAG,cityList.toString());
            choose_cityList.clear();
            sortkeyMap.clear();
            choose_cityList.addAll(cityList);
            listAdapter.notifyDataSetChanged();
            String jsonStr=new Gson().toJson(choose_cityList);
            SharedUtils.upDateCitylist(getBaseContext(),jsonStr);

        }
    }


    class ViewHolder{
        TextView sort_key;
        TextView city_name;
        public ViewHolder(){}

        public TextView getSort_key() {
            return sort_key;
        }

        public void setSort_key(TextView sort_key) {
            this.sort_key = sort_key;
        }

        public TextView getCity_name() {
            return city_name;
        }

        public void setCity_name(TextView city_name) {
            this.city_name = city_name;
        }
    }
    private HashMap<String,String> sortkeyMap=new HashMap<>();
    class ListAdapter extends BaseAdapter{
        List<City> cities;
        public ListAdapter(List<City> cityList){
            cities=cityList;
            Log.i(TAG,"ListAdapter");
            Log.i(TAG,"list : "+cities.size());
            if (cities.size()>0)
            {
                String name=cities.get(0).getClass().getName();
                Log.i(TAG,"name : "+name);
            }

            for (int i=0;i<cities.size();i++){
                Log.i(TAG,"city : "+cities.get(i).toString());
            }
        }
        @Override
        public int getCount() {
            return cities.size();
        }

        @Override
        public Object getItem(int position) {
            return cities.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder=null;
            if (convertView==null){
                Log.i(TAG,"convertview == null");
                convertView=getLayoutInflater().from(getBaseContext()).inflate(R.layout.choose_list_item,parent,false);
                viewHolder=new ViewHolder();
                TextView sortkey=(TextView)convertView.findViewById(R.id.sort_key_textview);
                TextView cityname=(TextView)convertView.findViewById(R.id.city_name_textview);
                viewHolder.setCity_name(cityname);
                viewHolder.setSort_key(sortkey);
                convertView.setTag(viewHolder);
            } else {
                viewHolder=(ViewHolder)convertView.getTag();
            }
            City city=cities.get(position);
            viewHolder.getCity_name().setText(city.getCity_name());
            viewHolder.getSort_key().setText(city.getCity_sortkey());

            if (sortkeyMap.get(city.getCity_sortkey())==null) {
                Log.i(TAG,"sum");
                sortkeyMap.put(city.getCity_sortkey(),city.getCity_name());
                viewHolder.getSort_key().setVisibility(View.VISIBLE);
                Log.i(TAG,city.getCity_sortkey());
            } else {
                if (!sortkeyMap.get(city.getCity_sortkey()).equals(city.getCity_name()))
                viewHolder.getSort_key().setVisibility(View.GONE);
                  Log.i(TAG,"BKB");
            }
            return convertView;
        }
    }
}
