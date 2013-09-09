package org.cnc.alg.activity;

import java.util.ArrayList;

import org.cnc.alg.R;
import org.cnc.alg.adapter.ContactUsAdapter;
import org.cnc.alg.objectjson.Contact;
import org.cnc.alg.util.Constant;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author CNCSOFTWARE DEVELOPER - 2012
 * 
 */
public class BelfastKeyContactActivity extends Activity  {
	private ArrayList<Contact> lstContacts = new ArrayList<Contact>();
	private ListView lstView;
	private Contact mContact = null;
	private ContactUsAdapter adapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.belfast_keycontact);
			
		lstView = (ListView) findViewById(R.id.lstContact);	
		initdata();
		adapter = new ContactUsAdapter(lstContacts, BelfastKeyContactActivity.this);
		lstView.setAdapter(adapter);

	}
	
	public void initdata() {

		mContact = new Contact("Gareth Walls", "Parter", "+44 (0) 28 9031 4466", "gwalls@algoodbody.com","gareth");
		lstContacts.add(mContact);

		
		mContact = new Contact("A&L Goodbody Belfast", "6th Floor,42/46 Fountain Street, Belfast BT1 5EF", "+44 (0) 28 9031 4466 ", "www.algoodbody.com","belfast_map");
		lstContacts.add(mContact);

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
