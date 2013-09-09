package org.cnc.alg.adapter;

import java.util.ArrayList;

import org.cnc.alg.R;
import org.cnc.alg.objectjson.TwitterSip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SipTwiterAdapter  extends BaseAdapter{
   
	private ArrayList<TwitterSip> lstTwitters ;
	private LayoutInflater inflater;
	public SipTwiterAdapter(Context context, ArrayList<TwitterSip> lstTwitters ){
		this.inflater = LayoutInflater.from(context);
		this.lstTwitters = lstTwitters;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lstTwitters.size();
	}

	@Override
	public TwitterSip getItem(int position) {
		// TODO Auto-generated method stub
		return lstTwitters.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHeper heper = null;
		if(convertView == null){
			heper = new ViewHeper();
			convertView = inflater.inflate(R.layout.sip_twitter_child, null);
			heper.txtTwitterText =  (TextView) convertView.findViewById(R.id.txtSipTwitter);
	       convertView.setTag(heper);
		}else{
			heper = (ViewHeper) convertView.getTag();
		}
		heper.txtTwitterText.setText(getItem(position).getStrText());
		
		return convertView;
	}
  
	class ViewHeper {
		TextView txtTwitterText;
		
	}
}
