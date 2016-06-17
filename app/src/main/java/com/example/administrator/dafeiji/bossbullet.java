package com.example.administrator.dafeiji;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Administrator on 2016/5/26.
 */
public class bossbullet   {
public int x;
public int y;
public Bitmap bitbgbullet[];
public int index;

        public bossbullet(Resources res){
            this.x=0;
            this.y=0;
            //this.bitbgbullet= BitmapFactory.decodeResource(res, R.drawable.bul09);
            this.bitbgbullet=new Bitmap[]{BitmapFactory.decodeResource(res, R.drawable.bul08),
                    BitmapFactory.decodeResource(res, R.drawable.bul17),
                    BitmapFactory.decodeResource(res, R.drawable.bb02)};
        }
        public void ondraw(Canvas canvas){
            canvas.drawBitmap(bitbgbullet[index],x,y,null);
        }
        public void move(){
        y+=10;
    }
    public Rect isRect(){
        return new Rect(x,y,x+bitbgbullet[index].getWidth(),y+bitbgbullet[index].getHeight());
    }
}
