package com.example.administrator.dafeiji;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by Administrator on 2016/5/25.
 */
public class Bomb {
    public int x;
    public int y;
    public int index;//控制图片显示的索引
    public Bitmap[] bimmapBombs;
    public Bomb(Resources res){
        this.x=0;
        this.y=0;
        this.index=0;
        this.bimmapBombs=new Bitmap[]{BitmapFactory.decodeResource(res,R.drawable.bomb_enemy_0),
                BitmapFactory.decodeResource(res,R.drawable.bomb_enemy_1),BitmapFactory.decodeResource(res,R.drawable.bomb_enemy_2),
                BitmapFactory.decodeResource(res,R.drawable.bomb_enemy_3),BitmapFactory.decodeResource(res,R.drawable.bomb_enemy_4),
                BitmapFactory.decodeResource(res,R.drawable.bomb_enemy_5),BitmapFactory.decodeResource(res,R.drawable.bomb_enemy_6)};
    }

    public void ondraw(Canvas canvas){
        index++;
        if (index<=6) {
            canvas.drawBitmap(bimmapBombs[index], x, y, null);
        }
    }
}
