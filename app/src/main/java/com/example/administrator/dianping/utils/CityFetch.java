package com.example.administrator.dianping.utils;

import android.util.Log;

import com.example.administrator.dianping.enty.City;
import com.example.administrator.dianping.enty.ResponseObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by Administrator on 2016/9/19 0019.
 */

public class CityFetch {
    public static String TAG="CityFetch";
    private static String SERVICE_ADDR="192.168.191.1";
    public static String BASE_URL=CITY_URL="http://"+SERVICE_ADDR+":8189/api/";
    public static String CITY_URL="http://"+SERVICE_ADDR+":8189/api/city";
//    public static String CITY_URL="http://http://stackoverflow.com";
    private static Gson gson=(new GsonBuilder()).setPrettyPrinting().create();
    public static List<City> getCityList(String urlSpec){
        String jsonStr=getUrlString(getUrlBytes(urlSpec));
        Log.i(TAG,"getCityList()");
        try {
            JSONObject jsonObject=new JSONObject(jsonStr);
            Log.i(TAG,"jsonObjecty "+jsonObject.toString());
            JSONArray dates=jsonObject.getJSONArray("dates");

            Type type=new TypeToken<List<City>>(){}.getType();
            Log.i(TAG,"WWWWWW : "+dates.toString());
            List<City> list=(List<City>)gson.fromJson(dates.toString(),type);
            return  list;
        } catch (JSONException e){
            Log.i(TAG,"JSONException xxxxx");
        }
        return null;
    }

    public static String getUrlString(byte[] bytes){
        String tStr=new String(bytes);
        Log.i(TAG,tStr);
        return tStr;
    }
    public static byte[] getUrlBytes(String urlSpec){
        URL url=null;
        Log.i(TAG,"getUrlBytes()start");
        HttpURLConnection connection=null;
        try {
             url= new URL(urlSpec);
        } catch (MalformedURLException e){
            Log.i(TAG,"Malformed Ex");
        }
        Log.i(TAG,url.toString());
        try{
            connection=(HttpURLConnection) url.openConnection();
            Log.i(TAG,"where??");
            InputStream in= connection.getInputStream();
            if (connection.getResponseCode()!=HttpURLConnection.HTTP_OK){
                Log.i(TAG,"Open connection failed!");
            }
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            int byteRead=0;
            byte[] buff=new byte[1024];

            while ((byteRead=in.read(buff))>0){
                out.write(buff,0,byteRead);
            }
            out.close();
            Log.i(TAG,"out.close()");
            Log.i(TAG,"byteLength "+out.toByteArray().length);
            return out.toByteArray();
        } catch(IOException e){
            Log.i(TAG,"IOException");
        } finally {
            connection.disconnect();
        }
        return null;
    }

}
