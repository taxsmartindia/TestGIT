package org.cnc.alg.activity;

import org.cnc.alg.R;
import org.cnc.alg.util.Constant;

import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class SipActivity extends TabActivity {
	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	TabHost tabHost;
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		boolean b =  requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		preferences = getSharedPreferences(Constant.ALG, MODE_PRIVATE);
		editor = preferences.edit();
		setContentView(R.layout.sip);
		tabHost = getTabHost();
		setTabs(); 
//		Intent intent = getIntent();
//		Bundle bundle = intent.getExtras();
		if(preferences.getBoolean(Constant.SIP_KEY_DATE, false)){
			tabHost.setCurrentTab(2);
			editor.remove(Constant.SIP_KEY_DATE);
			editor.commit();
		}else if (preferences.getBoolean(Constant.SIP_LIFE, false)) {
			tabHost.setCurrentTab(1);
			editor.remove(Constant.SIP_LIFE);
			editor.commit();
		}
		if(b){
			getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.customtitle);
			((TextView)findViewById(R.id.txtTitle)).setText(Constant.SIP);
			
			Button btnBack = (Button) findViewById(R.id.btnBack);
			btnBack.setOnClickListener(new OnClickListener() {
				
				@Override
			public void onClick(View v) {
					// TODO Auto-generated method stub
				   Intent intent = new  Intent(SipActivity.this, HomeScreenActivity.class);
				   finish();
				   startActivity(intent);
				}
			});
			Button btnHome = (Button) findViewById(R.id.btnHome);
	    	btnHome.setVisibility(View.INVISIBLE);
		}
	}

	 private void setTabs(){
            addTab(Constant.ICON_ABOUT, R.drawable.icontab_about, SipAboutActivity.class);
//            addTab("Life", R.drawable.icontab_life, TabGroupSipLifeActivity.class);
            addTab(Constant.ICON_EXPERIENCE, R.drawable.icontab_exp, SipExperienceActivity.class);
            addTab(Constant.ICON_KEYDATE, R.drawable.icontab_date, SipKeyDateActivity.class);
            addTab(Constant.ICON_TWITTER, R.drawable.icontab_twitter, SipTwitterActivity.class);
            addTab(Constant.ICON_FAQ, R.drawable.icontab_faq, SipFaqActivity.class);
		}
		
		private void addTab(String labelId, int drawableId, Class<?> c)
		{
			
			Intent intent = new Intent(this, c);
			TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);	
			
			View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
			TextView title = (TextView) tabIndicator.findViewById(R.id.title);
			title.setText(labelId);
			ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
			icon.setImageResource(drawableId);
			
			spec.setIndicator(tabIndicator);
			spec.setContent(intent);
			tabHost.addTab(spec);
		}
		
}
