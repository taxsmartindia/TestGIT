package org.cnc.alg.activity;

import org.cnc.alg.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SipExperienceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sip_life);
		
		Button btn_video = (Button) findViewById(R.id.btn_intern_exp_video);
		btn_video.setOnClickListener(onVideoButtonListener);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(this, HomeScreenActivity.class);
			finish();
			startActivity(intent);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * Overrides the default implementation for KeyEvent.KEYCODE_BACK so that
	 * all systems call onBackPressed().
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// TabGroupActivity parentActivity = (TabGroupActivity)getParent();
			// parentActivity.onBackPressed();
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	
	
	
	private OnClickListener onVideoButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://f0ellAhK6Z8")));
		}
	};

}
