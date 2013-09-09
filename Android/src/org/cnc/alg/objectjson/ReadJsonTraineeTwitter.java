package org.cnc.alg.objectjson;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadJsonTraineeTwitter extends ReadJson {

	private Twitter mTwitter = null;
	private ArrayList<Twitter> lstTwitters = null;
	
	public ReadJsonTraineeTwitter(){
		
	}
	
	public JSONArray getJsonTwiterFromURL(String url){
		return getJsonArrayFromUrl(url);
	}
	
	public ArrayList<Twitter> getDataFromObject(JSONArray jsonArray) throws JSONException{
		lstTwitters = new ArrayList<Twitter>();
		lstTwitters.clear();
		for(int  i = 0; i< jsonArray.length(); i++){
			JSONObject object = jsonArray.getJSONObject(i);
			mTwitter = null;
			mTwitter = new Twitter();
			mTwitter.setStrText(object.getString("text"));
			
			lstTwitters.add(mTwitter);
		}
		return lstTwitters;
				
	}
}
