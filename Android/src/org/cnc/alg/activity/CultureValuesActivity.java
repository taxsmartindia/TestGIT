package org.cnc.alg.activity;

import org.cnc.alg.R;
import org.cnc.alg.util.Constant;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class CultureValuesActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// getActionBar().setDisplayHomeAsUpEnabled(true);
		boolean customTitle = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_culture_values);
		if (customTitle) {
			getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
					R.layout.customtitle);
			((TextView) findViewById(R.id.txtTitle)).setText(Constant.CULTURE_VALUES);
			Button btnBack = (Button) findViewById(R.id.btnBack);
			btnBack.setOnClickListener(backOnClickListener);
			Button btnHome = (Button) findViewById(R.id.btnHome);
			btnHome.setVisibility(View.INVISIBLE);
		}
		// Diplay html
		showHtmlContent("file:///android_asset/culturevalues.html");
	}

	/**
	 * Show html page in asset folder
	 * 
	 * @param url
	 *            address of the html page
	 */
	private void showHtmlContent(String url) {
		WebView tv = (WebView) findViewById(R.id.text_culturevalues);
		WebSettings settings = tv.getSettings();
		settings.setTextSize(WebSettings.TextSize.NORMAL);
		tv.loadUrl(url);
	}

	private OnClickListener backOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(CultureValuesActivity.this,
					AboutUsActivity.class);
			finish();
			startActivity(intent);
		}
	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(this,
					AboutUsActivity.class);
			finish();
			startActivity(intent);
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}

	}


}
