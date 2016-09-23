package com.example.administrator.dianping.utils;

import com.example.administrator.dianping.R;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
//i want to be special
public class MyUtils {
    //一共有15个
    public static String[] navsSort = {"美食", "电影", "酒店", "KTV", "自助餐", "休闲娱乐", "旅游", "购物", "都市丽人", "母婴", "女装", "美妆", "户外运动", "生活服务", "全部"};
    public static int[] navsSortImages = {R.drawable.fee, R.drawable.fox, R.drawable.mont, R.drawable.more,
            R.drawable.fox, R.drawable.fee, R.drawable.mont, R.drawable.fee,
            R.drawable.mont, R.drawable.more, R.drawable.fee, R.drawable.fox,
            R.drawable.flower, R.drawable.fox, R.drawable.mont};
    public static String[] allCategray = {"全部分类", "今日新单", "美食", "休闲娱乐", "电影", "生活服务", "写真生活", "酒店", "旅游", "都市丽人", "教育培训", "抽奖公益", "购物"};
    public static int[] allCategrayImages = {R.drawable.more, R.drawable.mont, R.drawable.fox, R.drawable.fee,
            R.drawable.fee, R.drawable.mont, R.drawable.more, R.drawable.fee,
            R.drawable.mont, R.drawable.mont, R.drawable.more, R.drawable.fee, R.drawable.mont};
    public static int[] allCategorySum=new int[allCategrayImages.length+5];
}
