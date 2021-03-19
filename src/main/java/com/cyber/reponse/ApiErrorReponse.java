package com.cyber.reponse;

import com.google.gson.Gson;

public class ApiErrorReponse {
	private int errorCode =0;
	private String des = "";
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public ApiErrorReponse(int errorCode, String des) {
		super();
		this.errorCode = errorCode;
		this.des = des;
	}
	
	public String toJsonString() {
		return new Gson().toJson(this);
	}
}
