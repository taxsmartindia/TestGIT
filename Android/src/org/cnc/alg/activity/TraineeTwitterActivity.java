package org.cnc.alg.activity;

import java.util.ArrayList;

import org.cnc.alg.R;
import org.cnc.alg.adapter.TraineeTwiterAdapter;
import org.cnc.alg.objectjson.ReadJsonTraineeTwitter;
import org.cnc.alg.objectjson.Twitter;
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

public class TraineeTwitterActivity extends Activity {
	private ArrayList<Twitter> lstTwitters = new ArrayList<Twitter>();
	private ListView lstView;
	private DialogManager dialogManager;
	private NetworkStatus networkStatus;
	private TraineeTwiterAdapter adapter;
	private JSONArray mJsonArray = new JSONArray();
	private ReadJsonTraineeTwitter readJsonTraineeTwitter;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		networkStatus = new NetworkStatus(TraineeTwitterActivity.this);
		if (!networkStatus.isConnect()) {
			dialogManager = new DialogManager(TraineeTwitterActivity.this);
			dialogManager.showDlgError(getResources().getString(R.string.enable_network));
		} else {

			setContentView(R.layout.trainee_twitter);
			lstView = (ListView) findViewById(R.id.lstTraineeTwitter);
			getdata();

		}

	}

	public void getdata() {
		try {
			new LoadTwitter().execute();
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(TraineeTwitterActivity.this, "Please check connect!", Toast.LENGTH_LONG).show();
		}

	}

	class LoadTwitter extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			progressDialog = new ProgressDialog(TraineeTwitterActivity.this);
			progressDialog.setTitle("Loading content Twitter!!");
			progressDialog.setMessage("Please wait...");
			progressDialog.setCancelable(true);
			progressDialog.show();
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			readJsonTraineeTwitter = new ReadJsonTraineeTwitter();
			mJsonArray = readJsonTraineeTwitter.getJsonTwiterFromURL(Constant.TRAINEE_URL_TWITTER);
			try {
				lstTwitters = readJsonTraineeTwitter.getDataFromObject(mJsonArray);
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
			adapter = new TraineeTwiterAdapter(TraineeTwitterActivity.this, lstTwitters);
			lstView.setAdapter(adapter);

			super.onPostExecute(result);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(this, TraineeActivity.class);
			finish();
			startActivity(intent);
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}

	}
}
