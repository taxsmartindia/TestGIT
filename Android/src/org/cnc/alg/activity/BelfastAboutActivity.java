package org.cnc.alg.activity;

import org.cnc.alg.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * @author CNCSOFTWARE DEVELOPER - 2012
 * 
 */
public class BelfastAboutActivity extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.belfast_about);
		// Diplay html
		showHtmlContent(1, "file:///android_asset/belfast_about.html");
		showHtmlContent(2, "file:///android_asset/belfast_about_part2.html");

		((Button) findViewById(R.id.btn_aboutus_video1)).setOnClickListener(this);
		((Button) findViewById(R.id.btn_aboutus_video2)).setOnClickListener(this);

	}

	/**
	 * Show html page in asset folder
	 * 
	 * @param url
	 *            : address of the html page
	 */
	private void showHtmlContent(int part, String url) {
		WebView tv;
		if (part == 1) {
			tv = (WebView) findViewById(R.id.text_belfast_about);
		} else {
			tv = (WebView) findViewById(R.id.text_belfast_about_2);
		}

		WebSettings webSettings = tv.getSettings();
		webSettings.setJavaScriptEnabled(true);
		tv.loadUrl(url);
		tv.setWebViewClient(new WebViewClient() {

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {

				super.onPageStarted(view, url, favicon);
			}

			@Override
			public void onPageFinished(WebView view, String url) {

				super.onPageFinished(view, url);
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);

				return super.shouldOverrideUrlLoading(view, url);
			}

		});

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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_aboutus_video1:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://_flXRrRDguQ")));
			break;
		case R.id.btn_aboutus_video2:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://KnU-teQgo4k")));
			break;

		default:
			break;
		}
	}
}
