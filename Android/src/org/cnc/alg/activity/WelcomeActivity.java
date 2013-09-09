package org.cnc.alg.activity;

import org.cnc.alg.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		boolean customTitle = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		if (customTitle) {
			getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.customtitle);
			((TextView) findViewById(R.id.txtTitle)).setText(getResources().getString(R.string.welcome));
			Button btnBack = (Button) findViewById(R.id.btnBack);
			btnBack.setOnClickListener(backClickListener);
			Button btnHome = (Button) findViewById(R.id.btnHome);
			btnHome.setVisibility(View.INVISIBLE);
		}
	}

	private OnClickListener backClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(WelcomeActivity.this, HomeScreenActivity.class);
			finish();
			startActivity(intent);
		}
	};

}
