package com.example.administrator.dafeiji;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

/**
 * Created by Administrator on 2016/5/23.
 */public class bg {
    public int x;
    public int y;
    public Bitmap[] bitbg;
    public int index;
    //定义方法
    public bg(Resources res){
        this.x=0;
        this.y=0;
        this.index=0;
        this.bitbg= new Bitmap[]{BitmapFactory.decodeResource(res,R.drawable.bg01),
                BitmapFactory.decodeResource(res,R.drawable.bg05)};
    }
    public void ondraw(Canvas canvas) {//绘制方法
        //缩放功能
        float sfwid=(float)MainActivity.wid/bitbg[index].getWidth();
        float sfhei=(float)MainActivity.hei/bitbg[index].getHeight();
        Matrix mx=new Matrix();
        mx.postScale(sfwid,sfhei);
        this.bitbg[index]=bitbg[index].createBitmap(bitbg[index], 0, 0, bitbg[index].getWidth(), bitbg[index].getHeight(), mx,true);
        canvas.drawBitmap(bitbg[index], x, y, null);
        canvas.drawBitmap(bitbg[index],x,y-bitbg[index].getHeight(),null);
    }
    public  void move(){
        y++;
        if(y>=bitbg[index].getHeight()){
            y=0;
        }

    }
}

