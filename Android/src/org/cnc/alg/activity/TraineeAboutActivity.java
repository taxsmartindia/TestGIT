package org.cnc.alg.activity;


import org.cnc.alg.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author trungmd
 *
 */
public class TraineeAboutActivity extends Activity implements OnClickListener {
          @Override
        protected void onCreate(Bundle savedInstanceState) {
        	// TODO Auto-generated method stub
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.trainee_about);
        	
        	((Button) findViewById(R.id.btn_trainee_programme)).setOnClickListener(this);
    		((Button) findViewById(R.id.btn_trainee_lookfor)).setOnClickListener(this);
    		((Button) findViewById(R.id.btn_trainee_package)).setOnClickListener(this);
        }
          @Override
  		public boolean onKeyDown(int keyCode, KeyEvent event) {
  			if (keyCode == KeyEvent.KEYCODE_BACK) {
  				return true;
  			}else {
  				return super.onKeyDown(keyCode, event);
  			}
  			
  		}
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_trainee_programme:
				Intent intentprogramme = new Intent(this, TraineeProgrammeActivity.class);
				finish();
				startActivity(intentprogramme);
				break;
			case R.id.btn_trainee_lookfor:
				Intent intentLookFor = new Intent(this,
						TraineeLookForActivity.class);
				finish();
				startActivity(intentLookFor);
				break;
			case R.id.btn_trainee_package:
				Intent intentPackage = new Intent(this,
						TraineePackageActivity.class);
				finish();
				startActivity(intentPackage);
				break;
			default:
				break;
			}
		}
}
