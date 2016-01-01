package com.common;

import javax.enterprise.inject.New;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTemplate {
	private int code;
	private String msg;
	private Object data;
	private JSONObject template=new JSONObject();
	public JsonTemplate(int code, JSONObject data) {
		this.code=code;
		this.msg=StatusCode.status.get(code);
		this.data=data;
	}
	
	public JsonTemplate(int code, JSONArray data) {
		this.code=code;
		this.msg=StatusCode.status.get(code);
		this.data=data;
	}
	
	public JsonTemplate(int code) {
		this.code=code;
		this.msg=StatusCode.status.get(code);
		this.data=null;
	}

	public JSONObject getTemplate() {
		try {
			template.put("ret", new JSONObject().put("code", code).put("msg", (msg==null)?"":msg));
			template.put("data", (data==null)?"":data);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return template;
	}
	
	
}
