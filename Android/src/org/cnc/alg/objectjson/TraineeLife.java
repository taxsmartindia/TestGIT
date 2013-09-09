package org.cnc.alg.objectjson;

import android.graphics.Bitmap;

public class TraineeLife {
  Bitmap bmThunbai;
  String txtName;
  
  public TraineeLife(){
	  super();
  }
public TraineeLife(Bitmap bmThunbai, String txtName) {
	super();
	this.bmThunbai = bmThunbai;
	this.txtName = txtName;
}
public Bitmap getBmThunbai() {
	return bmThunbai;
}
public void setBmThunbai(Bitmap bmThunbai) {
	this.bmThunbai = bmThunbai;
}
public String getTxtName() {
	return txtName;
}
public void setTxtName(String txtName) {
	this.txtName = txtName;
}
  
}
