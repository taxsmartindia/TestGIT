package org.cnc.alg.objectjson;

public class DateKeySip {
 
	private String mDate;
	private String mDateContent;
	private String mtitle;
	private String mTag;
	
	
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getmTag() {
		return mTag;
	}
	public void setmTag(String mTag) {
		this.mTag = mTag;
	}
	public String getDate() {
		return mDate;
	}
	public void setmDate(String date) {
		this.mDate = date;
	}
	public String getDateContent() {
		return mDateContent;
	}
	public void setmDateContent(String dateContent) {
		this.mDateContent = dateContent;
	}
	public DateKeySip(String date, String dateContent) {
		super();
		this.mDate = date;
		this.mDateContent = dateContent;
	}
	public DateKeySip() {
		super();
	}
	
}
