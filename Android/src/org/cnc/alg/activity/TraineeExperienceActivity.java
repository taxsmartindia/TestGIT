package org.cnc.alg.activity;

import org.cnc.alg.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;

public class TraineeExperienceActivity extends Activity {
	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trainee_experience);
		Button btn_video = (Button) findViewById(R.id.btn_trainee_exp_video);
		Button btn_video2 = (Button) findViewById(R.id.btn_trainee_exp_video2);
		btn_video.setOnClickListener(onVideoButtonListener);
		btn_video2.setOnClickListener(onVideoButtonListener);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new  Intent(this, HomeScreenActivity.class);
			finish();
			startActivity(intent);
			return true;
		}else {
			return super.onKeyDown(keyCode, event);
		}
		
	}
	
	private OnClickListener onVideoButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_trainee_exp_video:				
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://PTs3VWWXyEE")));
				break;
			case R.id.btn_trainee_exp_video2:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://II_E6LL8IXU")));
				break;
			default:
				break;
			}
			
		}
	};

}
