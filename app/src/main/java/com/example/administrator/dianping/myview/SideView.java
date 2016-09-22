package com.example.administrator.dianping.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.administrator.dianping.R;

/**
 * Created by Administrator on 2016/9/22 0022.
 */

public class SideView extends View {
    private static String TAG="SideView";
    public SideView(Context context) {
        super(context);
    }

    public SideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG,"SideView(1,2)");
    }
    private String[] sideString={"热门","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    Paint paint=new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(getResources().getColor(android.R.color.darker_gray));
        paint.setTextSize(28);
        paint.setFakeBoldText(true);
        int height=getHeight();
        int width=getWidth();
        Log.i(TAG,"width "+width+"  height  "+height);
        Log.i(TAG,"sideString length "+sideString.length);
        int each_heigth=(int)(height/sideString.length);
        float sx=(float)0.0;
        float sy=(float)0.0;
        sx=(float)(width/2);
        for (int i=0;i<sideString.length;i++){
            float h1=(float)(i*each_heigth);
            float h2=(float)((i+1)*each_heigth);
            float base_y=(h1+h2)/2;
            canvas.drawText(sideString[i],sx,base_y,paint);
            Log.i(TAG,"sx "+sx+"  base_y  "+base_y);
        }
    }
}
