package com.cyber.object;


public class ApiConfig {
	private int id = 0;
	private DesConfigApi des;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DesConfigApi getDes() {
		return des;
	}
	public void setDes(DesConfigApi des) {
		this.des = des;
	}
	public ApiConfig(int id, DesConfigApi des) {
		super();
		this.id = id;
		this.des = des;
	}
	@Override
	public String toString() {
		return "ApiConfig [id=" + id + ", des=" + des + "]";
	}
	
	
	
}
