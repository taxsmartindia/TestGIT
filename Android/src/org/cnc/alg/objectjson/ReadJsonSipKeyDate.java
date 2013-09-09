package org.cnc.alg.objectjson;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadJsonSipKeyDate extends ReadJson {
  private DateKeySip mDateKeySip = null;
  private ArrayList<DateKeySip> mLstDateKeySips = null;
//  private JSONObject mJsonObject = null;
  
  public ReadJsonSipKeyDate(){
	  
  }

//@Override
public JSONObject getJsonKeyDateFromUrl(String url) {
	// TODO Auto-generated method stub
//	return mJsonObject= 
		return	getJsonFromUrl(url);
}
  
public ArrayList<DateKeySip> getDataFromJsonObject(JSONObject jsonObject) throws JSONException{
//	JSONObject jsonObjectData = jsonObject.getJSONObject(name);
    
	JSONArray jsonArray = jsonObject.getJSONArray("posts");
	mLstDateKeySips = new ArrayList<DateKeySip>();
	mLstDateKeySips.clear();
	for(int i = 0; i< jsonArray.length(); i++){
		JSONObject object = jsonArray.getJSONObject(i);
		mDateKeySip = null;
		mDateKeySip = new DateKeySip();
		mDateKeySip.setMtitle(object.getString("title"));
		mDateKeySip.setmDateContent(object.getString("content"));
		//mDateKeySip.setmTag(object.getString("tags"));
		mDateKeySip.setmDate(object.getString("date"));
		
//		add into array list keydate trainee
		mLstDateKeySips.add(mDateKeySip);
	}
	return mLstDateKeySips;
	
}
  
}
