package com.example.administrator.dafeiji;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Administrator on 2016/5/26.
 */
public class Boss {
	public int x;
	public int y;
	public Bitmap[] bitmyboss;
	public int k;
	public int c;
	public Paint xt;
	public Random rd;
	public int index;

	// 定义方法
	public Boss(Resources res) {
		this.rd = new Random();
		this.bitmyboss= new Bitmap[]{BitmapFactory.decodeResource(res,R.drawable.boss),
				BitmapFactory.decodeResource(res,R.drawable.bosss)};
		this.y = 0-bitmyboss[index].getHeight();
		this.x = 120;
		this.index = 0;
		


		this.c=bitmyboss[index].getWidth();
	}

	protected void ondraw(Canvas canvas) {// 绘制方法
		
		canvas.drawBitmap(bitmyboss[index], x, y, null);
		xt = new Paint();
		xt.setColor(Color.RED);
		xt.setStyle(Paint.Style.STROKE);
		canvas.drawRect(new Rect(x, y - 5, x + bitmyboss[index].getWidth(), y), xt);
		xt.setStyle(Paint.Style.FILL);
		canvas.drawRect(new Rect(x, y - 5, x + c, y), xt);
		System.out.println(this.c);
	}

	public void move() {
		y += 5;
		k = rd.nextInt(8);
		if (y >= 80) {
			y -= 5;
			if (k == 0) {
				x += 10;
			} else if (k == 1) {
				x -= 10;
			} else {
				k = k;
			}
		}
	}

	public Rect isRect() {
		return new Rect(x, y, x + bitmyboss[index].getWidth(), y
				+ bitmyboss[index].getHeight());
	}

}
