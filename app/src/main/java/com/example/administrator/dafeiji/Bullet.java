package com.example.administrator.dafeiji;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Administrator on 2016/5/24.
 */
public class Bullet {
    public int x;
    public int y;
    public int index;
    public Bitmap bitbgbullet[];

    public Bullet(Resources res){
        this.x=0;
        this.y=0;
        this.bitbgbullet= new Bitmap[]{
         BitmapFactory.decodeResource(res,R.drawable.bul01),
        BitmapFactory.decodeResource(res,R.drawable.bul21)};
    }
    public void ondraw(Canvas canvas){
        canvas.drawBitmap(bitbgbullet[index],x,y,null);
    }
    public void move(){
        y-=15;
    }
    public  Rect isRect(){
        return new Rect(x,y,x+bitbgbullet[index].getWidth(),y+bitbgbullet[index].getHeight());
    }
}
