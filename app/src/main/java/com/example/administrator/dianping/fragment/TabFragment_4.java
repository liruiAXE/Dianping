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


public class TabFragment_4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragemt_4, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("tabf1","f4 onDestroy");
    }

}
