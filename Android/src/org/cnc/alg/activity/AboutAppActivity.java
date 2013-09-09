package org.cnc.alg.activity;

import org.cnc.alg.R;
import org.cnc.alg.util.Constant;
import org.cnc.alg.util.Rotate3dAnimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class AboutAppActivity extends Activity {
	ScrollView scrollView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		boolean b = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.about_app);
		scrollView = (ScrollView) findViewById(R.id.about_app_scroll);
		if (b) {
			getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
					R.layout.customtitle);
			TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
			Button btnBack = (Button) findViewById(R.id.btnBack);
			Button btnHome = (Button) findViewById(R.id.btnHome);
			txtTitle.setText(Constant.ABOUT_APP_TITLE);
			btnHome.setVisibility(View.INVISIBLE);
			btnBack.setOnClickListener(onClickListener);
		}
		rotate();
		// Diplay html
		showHtmlContent("file:///android_asset/about_app.html", R.id.text_aboutApp1);
		showHtmlContent("file:///android_asset/about_app2.html", R.id.text_aboutApp2);
	}

	/**
	 * Show html page in asset folder
	 * 
	 * @param url
	 *            address of the html page
	 */
	private void showHtmlContent(String url, int id) {
		WebView tv = (WebView) findViewById(id);
		
		tv.loadUrl(url);
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(AboutAppActivity.this,
					HomeScreenActivity.class);
			intent.putExtra(Constant.ABOUT_APP, true);
			finish();
			startActivity(intent);
			//

		}
	};

	private void rotate() {
		Display display = getWindowManager().getDefaultDisplay();
		float centerX = display.getWidth() / 2;
		float centerY = display.getHeight() / 2;
		Rotate3dAnimation rotation = new Rotate3dAnimation(90, 0, centerX,
				centerY, 310.0f, false);
		rotation.setDuration(300);
		rotation.setFillAfter(true);
		rotation.setInterpolator(new DecelerateInterpolator());
		// scrollView.setAnimation(rotation);
	}

}
