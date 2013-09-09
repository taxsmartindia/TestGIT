package org.cnc.alg.activity;


import org.cnc.alg.R;
import org.cnc.alg.util.Constant;
import org.cnc.alg.util.Rotate3dAnimation;

import com.parse.PushService;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
public class HomeScreenActivity extends Activity implements OnClickListener{
 
			
	RelativeLayout relativeLayout;	
	RelativeLayout customHome;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Boolean customtitle =requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.home);
		relativeLayout = (RelativeLayout) findViewById(R.id.llTest);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		
		
	   ((Button) findViewById(R.id.btnAbout)).setOnClickListener(this);
       ((Button) findViewById(R.id.btnConstact)).setOnClickListener(this);
       ((Button) findViewById(R.id.btnInterns)).setOnClickListener(this);
       ((Button) findViewById(R.id.btnApply)).setOnClickListener(this);
       ((Button) findViewById(R.id.btnTrainee)).setOnClickListener(this);
       ((Button) findViewById(R.id.btnBelfast)).setOnClickListener(this);
       
       if(customtitle){
    	   getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_home);
    	   customHome = (RelativeLayout) findViewById(R.id.customHome);
    	   Button btnAboutApp = (Button) findViewById(R.id.btninfo);
    	   btnAboutApp.setOnClickListener(this);
       }
       
       try {
			if(bundle.getBoolean(Constant.ABOUT_APP)){
				rotate();	
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
       
       //PushService.subscribe(getBaseContext(), "", HomeScreenActivity.class);
   
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAbout:
			Intent intentAbout = new Intent(this, AboutUsActivity.class);
        	finish();
        	startActivity(intentAbout);
			break;
        case R.id.btnConstact:
        	Intent intentContact = new Intent(this, ContactUsActivity.class);
        	finish();
        	startActivity(intentContact);
        	break;
        case R.id.btnApply:
        	Intent intentDownload = new Intent(this, ApplyActivity.class);
        	finish();
        	startActivity(intentDownload);
        	break;
        case R.id.btnInterns:
        	Intent intentSip = new Intent(this, SipActivity.class);
        	finish();
        	startActivity(intentSip);
        	break;
        case R.id.btnTrainee:
        	Intent intentTrainee = new Intent(this, TraineeActivity.class);
        	finish();
        	startActivity(intentTrainee);
        	break;
        case R.id.btnBelfast:
        	Intent intentWelcome = new Intent(this, BelfastActivity.class);
        	finish();
        	startActivity(intentWelcome);
        	break;
        case R.id.btninfo:
        	Intent intent = new Intent(this, AboutAppActivity.class);
        	finish();
        	startActivity(intent);
        	
		default:
			break;
		}
	}
	private void rotate(){
		 Display display = getWindowManager().getDefaultDisplay();
		 float centerX = display.getWidth()/2;
		 float centerY = display.getHeight()/2;
		 Rotate3dAnimation rotation =new Rotate3dAnimation(270,360, centerX, centerY, 310.0f, false);
		 rotation.setDuration(300);
	     rotation.setFillAfter(true);
	     rotation.setInterpolator(new DecelerateInterpolator());
		 relativeLayout.setAnimation(rotation);  
	}


	private void confirmExit(){
		final AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("Do you want to quit the application?");
		alert.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {
						finish();
						System.gc();
						android.os.Process.killProcess(android.os.Process.myPid());
					}
				});

		alert.setNegativeButton("No",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {
						dialog.cancel();
					}
				});
		alert.show();
	}
}
