package org.cnc.alg.objectjson;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.net.ParseException;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * @author CNCSOFTWARE DEVELOPER - 2012 Get data SipKeyDate from Parse.com using
 *         Parse.com API
 */
public class GetSipKeyDateParseAPI {
	private DateKeySip mDateKeySip = null;
	private ArrayList<DateKeySip> mLstDateKeySips = null;

	
	
	
	public ArrayList<DateKeySip> query(final ProgressDialog progressDialog) {
		ParseQuery query = new ParseQuery("SIPKeyDates");		
		mLstDateKeySips = new ArrayList<DateKeySip>();
		mLstDateKeySips.clear();

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
						mLstDateKeySips.add(mDateKeySip);
						

					}	
					
					progressDialog.dismiss();

				} else {
					Log.d("SIPKeyDates", "Error: " + e.getMessage());
				}

			}

		});
		
		return mLstDateKeySips;

	}
}
