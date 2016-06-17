package com.example.administrator.dafeiji;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

/**
 * Created by Administrator on 2016/5/27.
 */
public class gameover {
    public int x;
    public int y;
    public Bitmap bitbg;

    //定义方法
    public gameover(Resources res) {

        this.bitbg = BitmapFactory.decodeResource(res, R.drawable.gameover);
        this.y = MainActivity.hei/2-bitbg.getHeight()/2;
        this.x = MainActivity.wid/2-bitbg.getWidth()/2;
    }


    public void ondraw(Canvas canvas) {//绘制方法
        canvas.drawBitmap(bitbg, x, y, null);

    }
}
