package com.verizon.hackathon.firefox.vo;

public class UserHistory {
	public String id;
	public String hostname;
	public String textSearched;
	public String dateVisitied;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getTextSearched() {
		return textSearched;
	}
	public void setTextSearched(String textSearched) {
		this.textSearched = textSearched;
	}
	public String getDateVisitied() {
		return dateVisitied;
	}
	public void setDateVisitied(String dateVisitied) {
		this.dateVisitied = dateVisitied;
	}
	@Override
	public String toString(){
		return "Id="+id+",Hostname="+hostname+",Text="+textSearched+",date="+dateVisitied;
	}
}
