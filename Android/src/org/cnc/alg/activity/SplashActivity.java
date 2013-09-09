package org.cnc.alg.activity;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.cnc.alg.R;
import org.cnc.alg.util.Constant;

import com.urbanairship.analytics.InstrumentedActivity;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushPreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class SplashActivity extends InstrumentedActivity implements Runnable , OnTouchListener {
    
	PushPreferences pushPreferences;
	public static int DELAY = 2000;
  	private ScheduledExecutorService mExecutor;
  	private ImageView mImageView;
	SharedPreferences pref;
	SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		pref = getSharedPreferences(Constant.ALG, MODE_PRIVATE);
		editor = pref.edit();
		mImageView = new ImageView(this);
		mImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.background));
		setContentView(mImageView);
	    mExecutor = Executors.newSingleThreadScheduledExecutor();
	    mExecutor.schedule(this, DELAY, TimeUnit.MILLISECONDS);
	   
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
   
	
	@Override
	public void run() {
		/*// TODO Auto-generated method stub
		pushPreferences=PushManager.shared().getPreferences();
		boolean isEnable = pushPreferences.isPushEnabled();
		if(!isEnable){
			PushManager.enablePush();
			pushPreferences.setSoundEnabled(true);
			pushPreferences.setVibrateEnabled(true);
		}else{
//			PushManager.disablePush();
//			pushPreferences.setSoundEnabled(false);
//			pushPreferences.setVibrateEnabled(false);
		}*/
		Intent intent = new Intent(this, HomeScreenActivity.class);
		finish();
		startActivity(intent);
	}
      
}
