package org.cnc.alg.activity;

import org.cnc.alg.R;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.push.CustomPushNotificationBuilder;
import com.urbanairship.push.PushManager;

public class AlgApplication extends Application{
	
	@Override
	    public void onCreate() {
	        
	        super.onCreate();
	        
	    	// Add your initialization code here, for Parse.com
			Parse.initialize(this, "ChPAJNLd0al9JYXFbmOPZWTIwPB585gYN2H7aIIr", "bnFOYcGII95tQrVc6I9mU2bBuiA5kj1QvM3wrQ3x");

	        //For urbund ariship
	        AirshipConfigOptions options = AirshipConfigOptions.loadDefaultOptions(this);

	        // Optionally, customize your config at runtime:
	        //
	        // options.inProduction = false;
	        // options.developmentAppKey = "Your Development App Key";
	        // options.developmentAppSecret "Your Development App Secret";

	        UAirship.takeOff(this, options);
	        Logger.logLevel = Log.VERBOSE;
	        
	        //use CustomPushNotificationBuilder to specify a custom layout
	        CustomPushNotificationBuilder nb = new CustomPushNotificationBuilder();

	        nb.statusBarIconDrawableId = R.drawable.logo;//custom status bar icon

	        nb.layout = R.layout.notification;
	        nb.layoutIconDrawableId = R.drawable.logo_about;//custom layout icon
	        nb.layoutIconId = R.id.icon;
	        nb.layoutSubjectId = R.id.subject;
	        nb.layoutMessageId = R.id.message;

	        // customize the sound played when a push is received
	        //nb.soundUri = Uri.parse("android.resource://"+this.getPackageName()+"/" +R.raw.cat);

	        PushManager.shared().setNotificationBuilder(nb);
	        PushManager.shared().setIntentReceiver(IntentReceiver.class);
	}
}
