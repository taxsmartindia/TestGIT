package org.cnc.alg.activity;

import java.util.ArrayList;
import java.util.List;

import org.cnc.alg.R;
import org.cnc.alg.adapter.SipKeyDateAdapter;
import org.cnc.alg.objectjson.DateKeySip;
import org.cnc.alg.util.DialogManager;
import org.cnc.alg.util.NetworkStatus;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class SipKeyDateActivity extends Activity {
   private ArrayList<DateKeySip> mLstDateKeys = new ArrayList<DateKeySip>();
   private DateKeySip mDateKeySip = null;
   private SipKeyDateAdapter mAdapter;
   private ListView mlstKeyDateView;
   private NetworkStatus networkStatus;
   private DialogManager dialogManager;
   private 	ProgressDialog progressDialog;
   
//	static final String URL = "http://courseeye.com/KeyDatesJSON.json#";
   @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		networkStatus = new NetworkStatus(SipKeyDateActivity.this);
		
		if(!networkStatus.isConnect()){
			dialogManager = new DialogManager(SipKeyDateActivity.this);
			dialogManager.showDlgError(getResources().getString(R.string.enable_network));
		}else {
			setContentView(R.layout.sip_keydate);
			mlstKeyDateView = (ListView) findViewById(R.id.lstSipKeydate);
			
		    progressDialog= new ProgressDialog(SipKeyDateActivity.this);
			progressDialog.setMessage("Loading...");
			progressDialog.setCancelable(false);
			progressDialog.show();
			//Load in background and dismiss in Class GetSipKeyDateParse
			getData();			
			showData();
		}
		
	 }
   
   private void getData() {
	 
	    ParseQuery query = new ParseQuery("SIPKeyDates");		
		mLstDateKeys = new ArrayList<DateKeySip>();
		mLstDateKeys.clear();
		
		query.addAscendingOrder("sorter");
		query.findInBackground(new FindCallback() {
			
			@Override
			public void done(List<ParseObject> scoreList, com.parse.ParseException e) {
				if (e == null) {
					Log.d("SIPKeyDates", "Retrieved " + scoreList.size() + " scores");

					for (ParseObject parseObject : scoreList) {
						mDateKeySip = null;
						mDateKeySip = new DateKeySip();
						mDateKeySip.setMtitle(parseObject.getString("title"));
						mDateKeySip.setmDateContent(parseObject.getString("content"));
						//mDateKeySip.setmTag(object.getString("tags"));
						mDateKeySip.setmDate(parseObject.getString("date"));						
						//add into array list keydate trainee
						mLstDateKeys.add(mDateKeySip);
						

					}	
					showData();
					
					progressDialog.dismiss();

				} else {
					Log.d("SIPKeyDates", "Error: " + e.getMessage());
				}

			}

		});
		
		

	}
	 
	
	 
	 private void showData(){
		    mAdapter = new SipKeyDateAdapter(SipKeyDateActivity.this, mLstDateKeys);
		    mlstKeyDateView.setAdapter(mAdapter);
	 }
	
	
}
