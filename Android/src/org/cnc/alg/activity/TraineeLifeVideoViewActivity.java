package org.cnc.alg.activity;

import org.cnc.alg.R;
import org.cnc.alg.util.Constant;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.MediaController;
import android.widget.VideoView;

public class TraineeLifeVideoViewActivity extends Activity {
     
	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	private VideoView vv;
	private String filePath;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.videoview);
	    vv = (VideoView) findViewById(R.id.vv);
	    Intent intent = getIntent();
	    Bundle bundle = intent.getExtras();
	    filePath = bundle.getString(Constant.TRAINEE_LIFE_VIDEO_PATH);
	    MediaController mediaController = new MediaController(this);
	    mediaController.setEnabled(true);
	    mediaController.show(0);
	    vv.setMediaController(mediaController); 
	    vv.setVideoPath(filePath);
	    vv.requestFocus();
	    vv.showContextMenu();
	    vv.start();  
	    preferences = getSharedPreferences(Constant.ALG, MODE_PRIVATE);
	    editor = preferences.edit();
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode == KeyEvent.KEYCODE_BACK){
			Intent intent = new Intent(TraineeLifeVideoViewActivity.this, TraineeActivity.class);
			editor.putBoolean(Constant.TRAINEE_LIFE, true);
			editor.commit();
			finish();
			startActivity(intent);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
