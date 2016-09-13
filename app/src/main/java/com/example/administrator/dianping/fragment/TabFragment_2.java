package com.example.administrator.dianping.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.dianping.R;

public class TabFragment_2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("tabf1","f2 onCreateView");
        // Inflate the layout for this TabFragment_3
        return inflater.inflate(R.layout.fragment_fragment_2, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("tabf1","f2 onDestroy");
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
}
