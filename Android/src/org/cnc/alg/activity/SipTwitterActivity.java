package org.cnc.alg.activity;

import java.util.ArrayList;

import org.cnc.alg.R;
import org.cnc.alg.adapter.SipTwiterAdapter;
import org.cnc.alg.objectjson.ReadJsonSipTwitter;
import org.cnc.alg.objectjson.TwitterSip;
import org.cnc.alg.util.Constant;
import org.cnc.alg.util.DialogManager;
import org.cnc.alg.util.NetworkStatus;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.Toast;

public class SipTwitterActivity extends Activity {
	private ArrayList<TwitterSip> lstTwitters = new ArrayList<TwitterSip>();
	private ListView lstView;
	private DialogManager dialogManager;
	private NetworkStatus networkStatus;
	private SipTwiterAdapter adapter;
	private JSONArray mJsonArray = new JSONArray();
	private ReadJsonSipTwitter readJsonSipTwitter;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		networkStatus = new NetworkStatus(SipTwitterActivity.this);
		if (!networkStatus.isConnect()) {
			dialogManager = new DialogManager(SipTwitterActivity.this);
			dialogManager.showDlgError(getResources().getString(
					R.string.enable_network));
		} else {

			setContentView(R.layout.sip_twitter);
			lstView = (ListView) findViewById(R.id.lstSipTwitter);
			getdata();

		}

	}

	public void getdata() {

		try {
			new LoadTwitter().execute();
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(SipTwitterActivity.this,
					getResources().getString(R.string.connect_fail),
					Toast.LENGTH_LONG).show();
		}
	}

	class LoadTwitter extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			try{
				// TODO Auto-generated method stub
				progressDialog = new ProgressDialog(SipTwitterActivity.this);
				progressDialog.setTitle("Loading content Twitter!!");
				progressDialog.setMessage("Please wait...");
				progressDialog.setCancelable(true);
				progressDialog.show();
				super.onPreExecute();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			readJsonSipTwitter = new ReadJsonSipTwitter();
			mJsonArray = readJsonSipTwitter
					.getJsonTwiterFromURL(Constant.SIP_URL_TWITTER);
			try {
				lstTwitters = readJsonSipTwitter.getDataFromObject(mJsonArray);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub

			progressDialog.dismiss();
			adapter = new SipTwiterAdapter(SipTwitterActivity.this, lstTwitters);
			lstView.setAdapter(adapter);
			super.onPostExecute(result);
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(this, HomeScreenActivity.class);
			finish();
			startActivity(intent);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	
}
