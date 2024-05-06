package com.company.employeedirectory;

public class ResponseExctionBody {
private int stsausCode;
private String message;
private long timpstamps;
//generate default constructor 
public ResponseExctionBody() {
	
}
//generate parmitrized constructor
public ResponseExctionBody(int stsausCode, String message, long timpstamps) {
	super();
	this.stsausCode = stsausCode;
	this.message = message;
	this.timpstamps = timpstamps;
}
//generating setters and getters
public int getStsausCode() {
	return stsausCode;
}
public void setStsausCode(int stsausCode) {
	this.stsausCode = stsausCode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public long getTimpstamps() {
	return timpstamps;
}
public void setTimpstamps(long timpstamps) {
	this.timpstamps = timpstamps;
}
}
