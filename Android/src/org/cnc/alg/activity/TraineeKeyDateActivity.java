package org.cnc.alg.activity;

import java.util.ArrayList;
import java.util.List;

import org.cnc.alg.R;
import org.cnc.alg.adapter.TraineeKeyDateAdapter;
import org.cnc.alg.objectjson.DateKeyTrainee;
import org.cnc.alg.util.DialogManager;
import org.cnc.alg.util.NetworkStatus;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class TraineeKeyDateActivity extends Activity {
	private ArrayList<DateKeyTrainee> mLstDateKeys = new ArrayList<DateKeyTrainee>();
	private DateKeyTrainee mDateKeyTrainee = null;
	private TraineeKeyDateAdapter mAdapter;
	private ListView mlstKeyDateView;
	private NetworkStatus networkStatus;
	private DialogManager dialogManager;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		networkStatus = new NetworkStatus(TraineeKeyDateActivity.this);

		if (!networkStatus.isConnect()) {
			dialogManager = new DialogManager(TraineeKeyDateActivity.this);
			dialogManager.showDlgError(getResources().getString(R.string.enable_network));
		} else {
			setContentView(R.layout.trainee_keydate);
			mlstKeyDateView = (ListView) findViewById(R.id.lstTraineeKeydate);
			progressDialog = new ProgressDialog(TraineeKeyDateActivity.this);
			progressDialog.setMessage("Loading...");
			progressDialog.setCancelable(false);
			progressDialog.show();
			// Load in background and dismiss in Class GetSipKeyDateParse
			getData();
			showData();
		}

	}

	private void getData() {

		ParseQuery query = new ParseQuery("TraineeKeyDates");
		mLstDateKeys = new ArrayList<DateKeyTrainee>();
		mLstDateKeys.clear();

		query.addAscendingOrder("sorter");
		query.findInBackground(new FindCallback() {

			@Override
			public void done(List<ParseObject> scoreList, com.parse.ParseException e) {
				if (e == null) {
					for (ParseObject parseObject : scoreList) {
						mDateKeyTrainee = null;
						mDateKeyTrainee = new DateKeyTrainee();
						mDateKeyTrainee.setMtitle(parseObject.getString("title"));
						mDateKeyTrainee.setmDateContent(parseObject.getString("content"));
						// mDateKeySip.setmTag(object.getString("tags"));
						mDateKeyTrainee.setmDate(parseObject.getString("date"));
						// add into array list keydate trainee
						mLstDateKeys.add(mDateKeyTrainee);

					}
					showData();

					progressDialog.dismiss();

				} else {
					Log.d("SIPKeyDates", "Error: " + e.getMessage());
				}

			}

		});

	}

	private void showData() {
		mAdapter = new TraineeKeyDateAdapter(TraineeKeyDateActivity.this, mLstDateKeys);
		mlstKeyDateView.setAdapter(mAdapter);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new  Intent(this, HomeScreenActivity.class);
			finish();
			startActivity(intent);
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}

	}

	
}
