package com.example.administrator.dafeiji;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Administrator on 2016/5/23.
 * 我军飞机class
 */
public class Plane extends Activity {
    public int x;
    public int y;
    public Bitmap bitmyPlane;
    public int count;//分数
    public Paint paint;
    public Paint xt;
    public int c;

    //定义方法
    public Plane(Resources res){
        this.bitmyPlane=BitmapFactory.decodeResource(res,R.drawable.player01);
        this.y=MainActivity.hei-bitmyPlane.getHeight();
        this.x=MainActivity.wid/2-bitmyPlane.getWidth()/2;
        this.paint=new Paint();
        this.c=bitmyPlane.getWidth();
        paint.setColor(Color.WHITE);
        paint.setTextSize(35);
    }
    protected void ondraw(Canvas canvas) {//绘制方法
        xt=new Paint();
        xt.setColor(Color.RED);
         canvas.drawBitmap(bitmyPlane, x, y, null);
        
         canvas.drawText(MainActivity.strfenshu + ":" + count, 0, 50, paint); //绘画分数
        xt.setStyle(Paint.Style.STROKE);
        canvas.drawRect(new Rect(x,y+bitmyPlane.getHeight(),x+bitmyPlane.getWidth(), y+bitmyPlane.getHeight()+5), xt);
        xt.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(x,y+bitmyPlane.getHeight(),x+c, y+bitmyPlane.getHeight()+5), xt);
    }
    public Rect isRect(){
        return new Rect(x,y,x+bitmyPlane.getWidth(),y+bitmyPlane.getHeight());
    }
}
