package org.cnc.alg.activity;

import org.cnc.alg.R;
import org.cnc.alg.R.layout;
import org.cnc.alg.R.menu;
import org.cnc.alg.util.Constant;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class TraineeProgrammeActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		boolean customTitle = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.trainee_programme);
		if (customTitle) {
			getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
					R.layout.customtitle);
			((TextView) findViewById(R.id.txtTitle)).setText(Constant.TRAINEE_PROGRAMME);
			((TextView) findViewById(R.id.txtTitle)).setSelected(true);
			((TextView) findViewById(R.id.txtTitle)).setWidth(240);
			Button btnBack = (Button) findViewById(R.id.btnBack);
			btnBack.setOnClickListener(backOnClickListener);
			Button btnHome = (Button) findViewById(R.id.btnHome);
			btnHome.setVisibility(View.INVISIBLE);
			
			
		}
		
		// Diplay html
		showHtmlContent("file:///android_asset/programme.html");
	}

	/**
	 * Show html page in asset folder
	 * 
	 * @param url
	 *            address of the html page
	 */
	private void showHtmlContent(String url) {
		WebView tv = (WebView) findViewById(R.id.text_traineeprogramme);

		tv.loadUrl(url);
	}
	
	private OnClickListener backOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(TraineeProgrammeActivity.this,
					TraineeActivity.class);
			finish();
			startActivity(intent);
		}
	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(TraineeProgrammeActivity.this,
					TraineeActivity.class);
			finish();
			startActivity(intent);
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}

	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.trainee_programme, menu);
//		return true;
//	}
}
