package br.com.graaccjus.mail.entity;

import java.util.ArrayList;

public class GraaccEmailEntity {
	
	private ArrayList<String> listEmail;
	private String subjectEmail;
	private String bodyEmail;
	
//	public void setListEmail(ArrayList<String> listEmail) {
//		this.listEmail = listEmail;
//	}
	public ArrayList<String> getListEmail() {
		return listEmail;
	}
	public String getsubjectEmail() {
		return subjectEmail;
	}
	public void setsubjectEmail(String subjectEmail) {
		this.subjectEmail = subjectEmail;
	}
	public String getbodyEmail() {
		return bodyEmail;
	}
	public void setCorpoEmail(String bodyEmail) {
		this.bodyEmail = bodyEmail;
	}
}
