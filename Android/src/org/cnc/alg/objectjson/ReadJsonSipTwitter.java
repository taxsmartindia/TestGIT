package org.cnc.alg.objectjson;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class ReadJsonSipTwitter extends ReadJson {

	private TwitterSip mTwitter = null;
	private ArrayList<TwitterSip> lstTwitters = null;
	
	public ReadJsonSipTwitter(){
		
	}
	
	public JSONArray getJsonTwiterFromURL(String url){
		return getJsonArrayFromUrl(url);
	}
	
	public ArrayList<TwitterSip> getDataFromObject(JSONArray jsonArray) throws JSONException{
		lstTwitters = new ArrayList<TwitterSip>();
		lstTwitters.clear();
		try {
			// JSONArray jsonArray = jsonObject.getJSONArray();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				mTwitter = null;
				mTwitter = new TwitterSip();
				mTwitter.setStrText(object.getString("text"));

				lstTwitters.add(mTwitter);
			}
		} catch (Exception e) {
			Log.d("Twitter",e.toString());
		}
		return lstTwitters;
				
	}
}
