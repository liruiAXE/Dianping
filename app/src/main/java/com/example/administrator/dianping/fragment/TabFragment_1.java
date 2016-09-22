package com.example.administrator.dianping.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.net.sip.SipException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.dianping.R;
import com.example.administrator.dianping.acti.AllCatActivity;
import com.example.administrator.dianping.acti.ChooseCityActivity;
import com.example.administrator.dianping.utils.MyUtils;
import com.example.administrator.dianping.utils.SharedUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.io.IOException;
import java.util.List;

//是因为害怕太。。。了吗？
public class TabFragment_1 extends Fragment implements LocationListener{
    private static String TAG="tabf1";
    String cityName=null;
    Boolean isAutoGetCityName=true;
    LocationManager locationManager;
    @ViewInject(R.id.cityname)
    TextView cityN;

    @ViewInject(R.id.home_nav_sort)
    GridView gridView;
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what==0){
                cityN.setText(cityName);
                SharedUtils.setCityLocation(getContext(),cityName);
            }
            return true;
        }
    });
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this TabFragment_3
        Log.i("tabf1","onCreateView");
        View view=inflater.inflate(R.layout.fragment_fragment_1, container, false);
        ViewUtils.inject(this,view);
        Location location=null;


//        cityN.setText(SharedUtils.getCityLocation(getContext()));
//        try {
//            location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//        } catch (SecurityException e){
//            e.printStackTrace();
//        }
//        Geocoder geo=new Geocoder(getContext());
//        List<Address> addr=null;
//        try{
//            addr=geo.getFromLocation(location.getLatitude(),location.getLongitude(),1);
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        if (addr.size()>0){
//            cityN.setText(addr.get(0).getLocality());
//        }
        gridView.setAdapter(new NaVAdapter());
        return view;
    }

    class NaVAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return MyUtils.navsSort.length;
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
        public View getView(int position, View convertView, final ViewGroup parent) {
            VHolder holder;
            if (convertView==null){
                holder=new VHolder();
                convertView=LayoutInflater.from(getContext()).inflate(R.layout.home_nav,parent,false);
                ViewUtils.inject(holder,convertView);
                convertView.setTag(holder);
            } else {
                holder=(VHolder) convertView.getTag();
            }
            holder.icon.setImageResource(MyUtils.navsSortImages[position]);
            holder.text.setText(MyUtils.navsSort[position]);
            if (position==MyUtils.navsSort.length-1){
                holder.icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View view=LayoutInflater.from(getContext()).inflate(R.layout.home_nav,parent,false);
                        ImageView i=(ImageView)view.findViewById(R.id.myicon);
                        i.setImageResource(R.drawable.flower);
                        Toast t=new Toast(getContext());
                        t.setView(view);
                        t.setDuration(Toast.LENGTH_LONG);
                        t.show();
                        Intent intent=new Intent(getContext(), AllCatActivity.class);
                        startActivity(intent);
                    }
                });
            }
            return convertView;
        }
    }
    class VHolder{
        @ViewInject(R.id.myicon)
        ImageView icon;
        @ViewInject(R.id.name)
        TextView text;
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.i("tabf1","onStart");
        Log.i(TAG,"SSSonStart");
        if (isAutoGetCityName)
        {
            locationManager=(LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            boolean isOpen=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            if (!isOpen){
                Intent intent=new Intent();
                intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
            }
            try{
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                        8000,1,this);
            } catch (SecurityException e){
                e.printStackTrace();
            }
        }


    }

    @Override
    public void onStop() {
        super.onStop();
        if (isAutoGetCityName){
            Log.i(TAG,"onStop");
            try {
                locationManager.removeUpdates(this);
            } catch (SecurityException e){
                e.printStackTrace();
            }
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("tabf1","f1 onDestroy");
    }

    @Override
    public void onLocationChanged(Location location) {
        soloveLocation(location);
    }
    private void soloveLocation(Location location){
        Geocoder geocoder=new Geocoder(getActivity());
        double lait=location.getLatitude();
        double lgit=location.getLongitude();
        List<Address> list=null;
        try{
           list=geocoder.getFromLocation(lait,lgit,1);
        } catch (IOException e){
            e.printStackTrace();
        }
        if (list.size()>0){
            cityName=list.get(0).getLocality();
        } else {
            cityName="无法获取";
        }
        handler.sendEmptyMessage(0);
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @OnClick(R.id.choose_city)
    public void cliclkk(View view){
        Intent i=new Intent();
        i.setClass(getContext(),ChooseCityActivity.class);
        startActivityForResult(i,51);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i(TAG,"SSSonActivityResult");
        Log.i(TAG,"resquestCOde + "+requestCode+"   Rusult "+resultCode);
        if (requestCode==51 && resultCode== Activity.RESULT_OK){
            String cityName=data.getStringExtra("CITY_NAME");
            cityN.setText(cityName);
            Log.i(TAG,"onActivityResult");
            isAutoGetCityName=false;
        }
    }

}
