package com.example.administrator.dafeiji;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Administrator on 2016/5/26.
 */
public class Daoju {
    public int x;
    public int y;
    public int index;
    public Bitmap bitmapdaoju[];
    public int k;
    public Random rd;
    public Daoju(Resources res){
        this.x=0;
        this.y=0;
        this.index=0;
        this.rd=new Random();
        this.bitmapdaoju= new Bitmap[]{
                BitmapFactory.decodeResource(res,R.drawable.item03),
                BitmapFactory.decodeResource(res,R.drawable.item02),
        };
    }
    public void ondraw(Canvas canvas){
        canvas.drawBitmap(bitmapdaoju[index], x, y, null);
    }
    public void move(){
        y+=5;
        k=rd.nextInt(8);
        if (y>=80){
            if(k==0){
                x+=40;
            }else if(k==1){x-=40;}
            else{k=k;}
        }}
    public Rect isRect(){
        return new Rect(x,y,x+bitmapdaoju[index].getWidth(),y+bitmapdaoju[index].getHeight());
    }

}
