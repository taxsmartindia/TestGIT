package org.cnc.alg.activity;

import org.cnc.alg.R;
import org.cnc.alg.util.Constant;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class AboutUsActivity extends Activity implements OnClickListener {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		boolean customTitle = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.about_us);
		if (customTitle) {
			getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.customtitle);
			((TextView) findViewById(R.id.txtTitle)).setText(Constant.ABOUT_US);
			Button btnBack = (Button) findViewById(R.id.btnBack);
			btnBack.setOnClickListener(backOnClickListener);
			Button btnHome = (Button) findViewById(R.id.btnHome);
			btnHome.setVisibility(View.INVISIBLE);
		}

		((Button) findViewById(R.id.btn_aboutus_inbrief)).setOnClickListener(this);
		((Button) findViewById(R.id.btn_aboutus_culturevalues)).setOnClickListener(this);
		((Button) findViewById(R.id.btn_aboutus_video)).setOnClickListener(this);

	}

	private OnClickListener backOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(AboutUsActivity.this, HomeScreenActivity.class);
			finish();
			startActivity(intent);
		}
	};


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_aboutus_inbrief:
			Intent intentInBrief = new Intent(this, InBriefActivity.class);
			finish();
			startActivity(intentInBrief);
			break;
		case R.id.btn_aboutus_culturevalues:
			Intent intentCultureValues = new Intent(this, CultureValuesActivity.class);
			finish();
			startActivity(intentCultureValues);
			break;
		case R.id.btn_aboutus_video:
			// startActivity(new Intent(Intent.ACTION_VIEW,
			// Uri.parse("http://m.youtube.com/watch?v=H6yAiQh-AMc")));
			Intent videoClient = new Intent(Intent.ACTION_VIEW);
			videoClient.setData(Uri.parse("vnd.youtube://" + "H6yAiQh-AMc"));
			startActivityForResult(videoClient, 1234);

			break;

		default:
			break;
		}
	}
	

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(this, HomeScreenActivity.class);
			finish();
			startActivity(intent);
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}

	}

}
