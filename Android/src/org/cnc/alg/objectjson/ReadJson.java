package org.cnc.alg.objectjson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadJson {
   
	public JSONObject getJsonFromUrl(String url){
	     InputStream mInputStream = null;
	     JSONObject mJsonObject = null;
	     HttpParams httpParams = new BasicHttpParams();
	     
	     //set time out for connection
	     HttpConnectionParams.setConnectionTimeout(httpParams, 15000);
	     HttpConnectionParams.setSoTimeout(httpParams, 15000);
	     
	     //connection manager
	     HttpClient httpClient = new DefaultHttpClient();
	     HttpGet httpGet = new HttpGet(url);
	     try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			mInputStream = entity.getContent();
			
			// when connect success, get date from URL
			 InputStreamReader inputStreamReader = new InputStreamReader(mInputStream, 
					 "iso-8859-1" );
			
			 BufferedReader  bufferedReader = new BufferedReader(inputStreamReader, 8);
			 
			 StringBuilder sb = new StringBuilder();
			 String line = null;
			 while((line=bufferedReader.readLine())!=null){
				 sb.append(line);
			 }
			 // Close stream
			 
			 mInputStream.close();
			 String result = sb.toString();
			 mJsonObject = new JSONObject(result);
//			 JSONArray jsonArray = new JSONArray(result);
//			 return mJsonObject;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mJsonObject;
		
	}
	
	public JSONArray  getJsonArrayFromUrl(String url){
	 	   InputStream mInputStream = null;
		     JSONArray mJsonArray = null;
		     HttpParams httpParams = new BasicHttpParams();
		     
		     //set time out for connection
		     HttpConnectionParams.setConnectionTimeout(httpParams, 15000);
		     HttpConnectionParams.setSoTimeout(httpParams, 15000);
		     
		     //connection manager
		     HttpClient httpClient = new DefaultHttpClient();
		     HttpGet httpGet = new HttpGet(url);
		     try {
				HttpResponse response = httpClient.execute(httpGet);
				HttpEntity entity = response.getEntity();
				mInputStream = entity.getContent();
				
				// when connect success, get date from URL
				 InputStreamReader inputStreamReader = new InputStreamReader(mInputStream, 
						 "iso-8859-1" );
				
				 BufferedReader  bufferedReader = new BufferedReader(inputStreamReader, 8);
				 
				 StringBuilder sb = new StringBuilder();
				 String line = null;
				 while((line=bufferedReader.readLine())!=null){
					 sb.append(line);
				 }
				 // Close stream
				 
				 mInputStream.close();
				 String result = sb.toString();
				 mJsonArray = new JSONArray(result);
//				 return mJsonObject;
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mJsonArray;
	}
}
