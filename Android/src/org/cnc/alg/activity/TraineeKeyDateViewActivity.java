package org.cnc.alg.activity;

import org.cnc.alg.R;
import org.cnc.alg.util.Constant;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class TraineeKeyDateViewActivity extends Activity {
       
	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		boolean b = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.trainee_keydate_view);
		if(b){
			getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.customtitle);
			TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
			Button btnTrainee = (Button) findViewById(R.id.btnBack);
			Button btnHome = (Button) findViewById(R.id.btnHome);
			btnHome.setVisibility(View.INVISIBLE);
			txtTitle.setText("");
//			btnTrainee.setText(Constant.TRAINEE);
			btnTrainee.setOnClickListener(onClickListener);
		}
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		TextView txtcontentDate = (TextView) findViewById(R.id.txtTraineeKeydateView1);
		TextView txtcontent = (TextView) findViewById(R.id.txtTraineeKeyDateView2);
		txtcontentDate.setText(bundle.getString("content_date"));
		txtcontent.setText(bundle.getString("content"));
		preferences = getSharedPreferences(Constant.ALG, MODE_PRIVATE);
		editor = preferences.edit();
	}
	private OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(TraineeKeyDateViewActivity.this, TraineeActivity.class);
			editor.putBoolean(Constant.TRAINEE_KEY_DATE, true);
			editor.commit();
			finish();
			startActivity(intent);
		}
	};
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			return true;
		}else {
			return super.onKeyDown(keyCode, event);
		}
		
	}
}
