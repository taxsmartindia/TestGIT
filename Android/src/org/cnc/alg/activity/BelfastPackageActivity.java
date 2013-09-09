package org.cnc.alg.activity;

import org.cnc.alg.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @author CNCSOFTWARE DEVELOPER - 2012
 * 
 */
public class BelfastPackageActivity extends Activity  {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.belfast_package);
		// Diplay html
		showHtmlContent(1, "file:///android_asset/belfast_package.html");
	}

	/**
	 * Show html page in asset folder
	 * 
	 * @param url
	 *            : address of the html page
	 */
	private void showHtmlContent(int part, String url) {
		WebView tv;
		tv = (WebView) findViewById(R.id.text_belfast_about);
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
	
}
