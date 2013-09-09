package org.cnc.alg.objectjson;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadJsonTraineeKeyDate extends ReadJson {
  private DateKeyTrainee mDateKeyTrainee = null;
  private ArrayList<DateKeyTrainee> mLstDateKeyTrainees = null;
//  private JSONObject mJsonObject = null;
  
  public ReadJsonTraineeKeyDate(){
	  
  }

//@Override
public JSONObject getJsonKeyDateFromUrl(String url) {
	// TODO Auto-generated method stub
//	return mJsonObject= 
		return	getJsonFromUrl(url);
}
  
public ArrayList<DateKeyTrainee> getDataFromJsonObject(JSONObject jsonObject) throws JSONException{
//	JSONObject jsonObjectData = jsonObject.getJSONObject(name);
    
	JSONArray jsonArray = jsonObject.getJSONArray("posts");
	mLstDateKeyTrainees = new ArrayList<DateKeyTrainee>();
	mLstDateKeyTrainees.clear();
	for(int i = 0; i< jsonArray.length(); i++){
		JSONObject object = jsonArray.getJSONObject(i);
		mDateKeyTrainee = null;
		mDateKeyTrainee = new DateKeyTrainee();
		mDateKeyTrainee.setMtitle(object.getString("title"));
		mDateKeyTrainee.setmDateContent(object.getString("content"));
		//mDateKeyTrainee.setmTag(object.getString("tags"));
		mDateKeyTrainee.setmDate(object.getString("date"));
		
		mLstDateKeyTrainees.add(mDateKeyTrainee);
	}
	return mLstDateKeyTrainees;
	
}
  
}
