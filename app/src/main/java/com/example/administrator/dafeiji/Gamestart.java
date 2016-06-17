package com.example.administrator.dafeiji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/5/23.
 */
public class Gamestart extends View {
	// 对象实例化
	int q=0;
	Plane plane = null;// 飞机对象
	bg bg = null;// 背景图片
	Bullet bullet = null;// 子弹对象
	Ememy enemy = null;
	bossbullet bob = null;
	Bomb bomb = null;// 爆炸对象
	Boss boss = null;// boss对象
	Daoju daoju = null;
	List<Bullet> listbullets = new ArrayList<Bullet>();// 弹夹游戏
	List<Ememy> listenemy = new ArrayList<Ememy>();
	List<bossbullet> listbossb = new ArrayList<bossbullet>();
	Enbullet enbullet = null;
	List<Enbullet> listenbullets = new ArrayList<Enbullet>();
	List<Daoju> listdaoju = new ArrayList<Daoju>();
	SoundPool sp = null;
	int pool;
	public int zd;
	// 标识控制子弹频率
	int count = 0;
	Random rd;
	gameover go = null;

	// Timer timer=null;//事件对象
	public Gamestart(Context context) {
		super(context);
		plane = new Plane(getResources());
		bg = new bg(getResources());
		rd = new Random();
		boss = new Boss(getResources());
		bob = new bossbullet(getResources());
		// mp=MediaPlayer.create(Gamestart.this,R.raw.techno);
		sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 100);
		pool = sp.load(context, R.raw.boom, 1);

		/*
		 * timer=new Timer();//发射子弹 timer.schedule(new TimerTask() { public void
		 * run() { } }, 0, 500);
		 */

	}

	protected void onDraw(Canvas canvas) {// 绘制方法
		super.onDraw(canvas);
		count++;
		IsbulletEnemy();// 调用碰撞方法
		isplaneDaoju();
		daji();
		kouxue();
		bg.ondraw(canvas);
		bg.move();
		if (boss != null) {
			boss.ondraw(canvas);
			boss.move();
			if (boss.x >= MainActivity.wid - boss.bitmyboss[boss.index].getWidth()) {
				boss.x = MainActivity.wid - boss.bitmyboss[boss.index].getWidth();
			}

		}
		if (plane == null || boss == null) {
			go = new gameover(getResources());
			go.ondraw(canvas);
		}
		if (boss != null) {
			if (count % 10 == 0) {
				bob.index = rd.nextInt(3);
				bob.x = boss.x + 60;
				bob.y = boss.y + boss.bitmyboss[boss.index].getHeight() + 5;
				listbossb.add(bob);
			}
		}
		if (plane != null) {
			plane.ondraw(canvas);
		}
		adds();
		for (int i = 0; i < listenemy.size(); i++) {// 敌机多量化
			listenemy.get(i).ondraw(canvas);
			if (count % 40 == 0) {
				enbullet = new Enbullet(getResources());
				enbullet.index = listenemy.get(i).index;
				enbullet.x = listenemy.get(i).x + 15;
				enbullet.y = listenemy.get(i).y;
				listenbullets.add(enbullet);
			}
		}
		for (int i = 0; i < listenemy.size(); i++) {// 敌机多量化移动
			listenemy.get(i).move();
		}
		for (int i = 0; i < listenbullets.size(); i++) {
			listenbullets.get(i).ondraw(canvas);
		}
		// bullet.ondraw(canvas);
		for (int i = 0; i < listbullets.size(); i++) {// 子弹多量化
			listbullets.get(i).ondraw(canvas);
		}
		for (int i = 0; i < listbullets.size(); i++) {// 子弹移动轨迹添加
			listbullets.get(i).move();
		}
		for (int i = 0; i < listenbullets.size(); i++) {// 敌机子弹移动轨迹添加
			listenbullets.get(i).move();
		}
		for (int i = 0; i < listbossb.size(); i++) {// BOSS子弹移动
			listbossb.get(i).move();
		}
		for (int i = 0; i < listbossb.size(); i++) {// BOSS子弹多量化
			listbossb.get(i).ondraw(canvas);
		}
		// bullet.move();
		// 更新数据

		if (bomb != null) {
			bomb.ondraw(canvas);
		}// 绘画爆炸方法

		for (int i = 0; i < listdaoju.size(); i++) {// 道具
			listdaoju.get(i).ondraw(canvas);
			listdaoju.get(i).move();
		}

		ReList();
		this.invalidate();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {// 触摸事件
		if (plane != null) {
			int x = (int) event.getX();
			int y = (int) event.getY();// 获得触摸位置

			if (x > plane.x - 88
					&& x < plane.x + plane.bitmyPlane.getWidth() + 50
					&& y > plane.y - 50
					&& y < plane.y + plane.bitmyPlane.getHeight() + 50) {
				plane.x = (int) event.getX();
				plane.y = (int) event.getY();
			}
			if (plane.x >= MainActivity.wid - plane.bitmyPlane.getWidth()) {
				plane.x = MainActivity.wid - plane.bitmyPlane.getWidth();
			}
			if (plane.y > MainActivity.hei - plane.bitmyPlane.getHeight()) {
				plane.y = MainActivity.hei - plane.bitmyPlane.getHeight();
			}
			return true;
		}
		return false;
	}

	public void adds() {
		// 添加我军子弹
		if (plane != null) {
			if (count % 10 == 0) {
				bullet = new Bullet(getResources());
				bullet.index = zd;
				bullet.x = plane.x + 20;
				bullet.y = plane.y - 8;
				listbullets.add(bullet);
			}
			if (count % 30 == 0) {
				enemy = new Ememy(getResources());
				enemy.index = rd.nextInt(3);
				int num = MainActivity.wid
						- enemy.bitmyEmemy[enemy.index].getWidth();
				enemy.x = rd.nextInt(num);
				listenemy.add(enemy);
			}
			if (count == 120) {
				count = 0;

			}
		}

	}

	public void IsbulletEnemy() {// 碰撞方法
		if (plane != null) {
			for (int i = 0; i < listbullets.size(); i++) {
				Rect rec = listbullets.get(i).isRect();
				for (int j = 0; j < listenemy.size(); j++) {
					if (rec.intersect(listenemy.get(j).isRect())) {
						// 资源id，左声道，右声道，优先级，循环
						sp.play(pool, 1, 1, 1, 0, 1);
						bomb = new Bomb(getResources());
						bomb.x = listbullets.get(i).x;
						bomb.y = listbullets.get(i).y;
						plane.count += 100;
						if (rd.nextInt(8) == 2) {
							daoju = new Daoju(getResources());
							daoju.x = listenemy.get(j).x;
							daoju.y = listenemy.get(j).y;
							daoju.index = rd.nextInt(2);
							listdaoju.add(daoju);
						}
						// 移除敌机和子弹
						listenemy.remove(listenemy.get(j));
						listbullets.remove(listbullets.get(i));
					}
				}
			}
		}
	}

	public void isplaneDaoju() {
		if (plane != null) {
			Rect replane = plane.isRect();
			for (int i = 0; i < listdaoju.size(); i++) {// 道具
				if (replane.intersect(listdaoju.get(i).isRect())) {
					if (listdaoju.get(i).index == 0) {
						listdaoju.remove(listdaoju.get(i));
						zd = 1;
					} else if (listdaoju.get(i).index == 1) {
						listdaoju.remove(listdaoju.get(i));
						zd = 0;
					}
				}
			}
		}
	}

	public void daji() {
		if(q==2){boss=null;
			listenemy.clear();listenbullets.clear();listbossb.clear();}
		if (boss != null) {

			for (int i = 0; i < listbullets.size(); i++) {
				Rect rec = listbullets.get(i).isRect();
				if (rec.intersect(boss.isRect())) {
					boss.c -= 1;
					bomb = new Bomb(getResources());
					bomb.x = boss.x+100;
					bomb.y = boss.y+100;
					listbullets.remove(listbullets.get(i));

					if (boss.c <= 0) {
						boss.c = 0;
						boss.index=1;
						boss.y=0-boss.bitmyboss[boss.index].getHeight();
						bg.index=1;
						q++;

					}

				}

			}
		}
	}

	public void kouxue() {
		if (plane != null) {
			Rect rec = plane.isRect();
			for (int i = 0; i < listenemy.size(); i++) {
				for (int j = 0; j < listenbullets.size(); j++) {
					if (rec.intersect(enemy.isRect())) {

						plane.c -= 1;
						listenemy.remove(listenemy.get(i));
					}

					if (rec.intersect(listenbullets.get(j).isRect())) {

						plane.c -= 1;
						listenbullets.remove(listenbullets.get(j));

					}
				}
			}

			for (int i = 0; i < listbossb.size(); i++) {
				if (rec.intersect(bob.isRect())) {
					plane.c -= 5;
					listbossb.remove(listbossb.get(i));
				}
			}

			if (plane.c <= 0) {
				bomb = new Bomb(getResources());
				bomb.x = plane.x;
				bomb.y = plane.y;
				plane.c = 0;
				bomb = null;
				plane = null;
				
			}
		}

	}

	public void ReList()// 优化集合方法
	{
		for (int i = 0; i < listbullets.size(); i++) {
			if (listbullets.get(i).y <= 50) {
				listbullets.remove(listbullets.get(i));
			}
		}
		for (int i = 0; i < listenemy.size(); i++) {
			if (listenemy.get(i).y > bg.bitbg[bg.index].getHeight()) {
				listenemy.remove(listenemy.get(i));
			}
		}
		for (int i = 0; i < listenbullets.size(); i++) {
			if (listenbullets.get(i).y > bg.bitbg[bg.index].getHeight()) {
				listenbullets.remove(listenbullets.get(i));
			}
		}
		for (int i = 0; i < listbossb.size(); i++) {
			if (listbossb.get(i).y > bg.bitbg[bg.index].getHeight()) {
				listbossb.remove(listbossb.get(i));
			}
		}

	}

}
