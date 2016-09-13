package com.example.administrator.dianping.fragment;

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
import android.widget.TextView;

import com.example.administrator.dianping.R;
import com.example.administrator.dianping.utils.SharedUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.IOException;
import java.util.List;


public class TabFragment_1 extends Fragment implements LocationListener{
    private static String TAG="tabf1";
    String cityName=null;
    LocationManager locationManager;
    @ViewInject(R.id.cityname)
    TextView cityN;
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
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("tabf1","onStart");
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

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
        try {
            locationManager.removeUpdates(this);
        } catch (SecurityException e){
            e.printStackTrace();
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
}
