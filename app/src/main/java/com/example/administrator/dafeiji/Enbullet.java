package com.example.administrator.dafeiji;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Administrator on 2016/5/24.
 */
public class Enbullet {
    public int x;
    public int y;
    public Bitmap bitbgbullet[];
    public int index;

    public Enbullet(Resources res){
        this.x=0;
        this.y=0;
        //this.bitbgbullet= BitmapFactory.decodeResource(res, R.drawable.bul09);
        this.bitbgbullet=new Bitmap[]{BitmapFactory.decodeResource(res, R.drawable.bul09),
                BitmapFactory.decodeResource(res, R.drawable.bul19),
                BitmapFactory.decodeResource(res, R.drawable.bul10)};
    }
    public void ondraw(Canvas canvas){
        canvas.drawBitmap(bitbgbullet[index],x,y,null);
    }
    public void move(){
        y+=8;
    }
    public Rect isRect(){
        return new Rect(x,y,x+bitbgbullet[index].getWidth(),y+bitbgbullet[index].getHeight());
    }
}
