package org.cnc.alg.util;

import org.json.JSONException;
import org.json.JSONObject;

public class Register {
	private boolean success;
	private String message;
	private String error;
	private int id;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Register(JSONObject jsonObject) throws JSONException {
		this.success = jsonObject.getBoolean("success");
		if(this.success){
			this.id = jsonObject.getInt("id");
		}else{
			this.message = jsonObject.getString("message");
			this.error = jsonObject.getString("error");
		}
	}

   
	
	
}
