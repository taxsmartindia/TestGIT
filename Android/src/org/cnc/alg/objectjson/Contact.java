package org.cnc.alg.objectjson;

public class Contact {
  private String strName;
  private String strPosition;
  private String strEmail;
  private String strPhone;
  private String strImage;
public String getStrName() {
	return strName;
}
public void setStrName(String strName) {
	this.strName = strName;
}
public String getStrPosition() {
	return strPosition;
}
public void setStrPosition(String strPosition) {
	this.strPosition = strPosition;
}
public String getStrEmail() {
	return strEmail;
}
public void setStrEmail(String strEmail) {
	this.strEmail = strEmail;
}
public String getStrPhone() {
	return strPhone;
}
public void setStrPhone(String strPhone) {
	this.strPhone = strPhone;
}


public String getStrImage() {
	return strImage;
}
public void setStrImage(String strImage) {
	this.strImage = strImage;
}
public Contact(String strName, String strPosition, 
		String strPhone,String strEmail,String strImage) {
	super();
	this.strName = strName;
	this.strPosition = strPosition;
	this.strEmail = strEmail;
	this.strPhone = strPhone;
	this.strImage = strImage;
}
public Contact() {
	super();
}
  
  
}
