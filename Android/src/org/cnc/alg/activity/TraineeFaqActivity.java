package org.cnc.alg.activity;

import org.cnc.alg.R;
import org.cnc.alg.util.Constant;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class TraineeFaqActivity extends Activity {
   
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trainee_faq);
		// Diplay html
		showHtmlContent("file:///android_asset/trainee_faq.html");
    }
    
    /**
     * Show html page in asset folder
     * @param url address of the html page
     */
    @SuppressLint("SetJavaScriptEnabled")
	private void showHtmlContent(String url) {
    	WebView tv = (WebView) findViewById(R.id.text_trainee_faq);
		tv.getSettings().setJavaScriptEnabled(true);
		tv.loadUrl(url);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new  Intent(this, HomeScreenActivity.class);
			finish();
			startActivity(intent);
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}

	}
}
