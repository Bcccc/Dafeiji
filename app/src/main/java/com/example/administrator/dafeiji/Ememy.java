package com.example.administrator.dafeiji;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Administrator on 2016/5/24.
 */
public class Ememy {
    public int x;
    public int y;
    public Bitmap bitmyEmemy[];
    public int index;
    //定义方法
    public Ememy(Resources res){
        //this.bitmyEmemy= BitmapFactory.decodeResource(res, R.drawable.enemy05);
        this.y=0;
        this.x=0;
        this.index=0;
       this.bitmyEmemy=new Bitmap[]{BitmapFactory.decodeResource(res, R.drawable.enemy05),
                BitmapFactory.decodeResource(res, R.drawable.enemy03),
                BitmapFactory.decodeResource(res, R.drawable.enemy02)};
    }
    protected void ondraw(Canvas canvas) {//绘制方法
        canvas.drawBitmap(bitmyEmemy[index],x,y,null);
    }
    public void move(){
        y+=5;
    }
    public  Rect isRect(){
        return new Rect(x,y,x+bitmyEmemy[index].getWidth(),y+bitmyEmemy[index].getHeight());
    }
}
