package com.cyber.object;

public class DesConfigApi {
	private String url = "";
	private String method = "";
	private String contenttype = "";
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getContenttype() {
		return contenttype;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public DesConfigApi(String url, String method, String contenttype) {
		super();
		this.url = url;
		this.method = method;
		this.contenttype = contenttype;
	}
	@Override
	public String toString() {
		return "DesConfigApi [url=" + url + ", method=" + method + ", contenttype=" + contenttype + "]";
	}
	
	
}
