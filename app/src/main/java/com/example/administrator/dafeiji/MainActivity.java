package com.example.administrator.dafeiji;

import android.app.ActionBar;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;


public class MainActivity extends Activity {
    static public int wid;
    static public int hei;
    MediaPlayer mp;

   static public String strfenshu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mp=MediaPlayer.create(this,R.raw.techno);
        mp.start();
        /*WindowManager wm=getWindowManager();
        Display dp=wm.getDefaultDisplay();
        wid=dp.getWidth();
        hei=dp.getHeight();过时方法*/
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        wid=dm.widthPixels;
        hei=dm.heightPixels;
        strfenshu=getString(R.string.fenshu);
        setContentView(new Gamestart(this));

    }


}
