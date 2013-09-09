package org.cnc.alg.activity;

import java.util.ArrayList;

import org.cnc.alg.R;
import org.cnc.alg.adapter.ContactUsAdapter;
import org.cnc.alg.objectjson.Contact;
import org.cnc.alg.util.Constant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ContactUsActivity extends Activity {
    
	private ArrayList<Contact> lstContacts = new ArrayList<Contact>();
	private ListView lstView;
	private Contact mContact = null;
	private ContactUsAdapter adapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		boolean b = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.contact_us);
		lstView = (ListView) findViewById(R.id.lstContact);
		if(b){
			getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.customtitle);
			((TextView)findViewById(R.id.txtTitle)).setText(Constant.CONTACT_US);
			Button btnBack = (Button) findViewById(R.id.btnBack);
			btnBack.setOnClickListener(backOnClickListener);
			Button btnHome = (Button) findViewById(R.id.btnHome);
	    	btnHome.setVisibility(View.INVISIBLE);
		}
		
	
		initdata();
		adapter = new ContactUsAdapter(lstContacts, ContactUsActivity.this);
		lstView.setAdapter(adapter);
		
	}

	private OnClickListener backOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(ContactUsActivity.this, HomeScreenActivity.class);
			finish();
			startActivity(intent);
		}
	};

	public void initdata() {

		mContact = new Contact("Clodagh Collier", "Trainee and Intern Manager", "+353 1 649 2273", "ccollier@algoodbody.com","clodagh");
		lstContacts.add(mContact);

		mContact = new Contact("Alan Roberts", "Partner with responsibility for Trainee & Inter Programmes", "+353 1 649 2108", "aroberts@algoodbody.com","alanroberts");
		lstContacts.add(mContact);
		
		mContact = new Contact("A&L Goodbody Dublin", "IFSC North Wall Quay Dublin 1", "+353 1 649 2000", "www.algoodbody.com","map");
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
