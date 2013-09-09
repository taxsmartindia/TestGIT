package org.cnc.alg.adapter;

import java.util.ArrayList;

import org.cnc.alg.R;
import org.cnc.alg.objectjson.SipLife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SipLifeAdapter extends BaseAdapter {
    
	private ArrayList<SipLife> lstSipLifes = new ArrayList<SipLife>();
	private LayoutInflater inflater;
//	private ArrayList<String> lstStrings;
	public SipLifeAdapter(Context context, 
			ArrayList<SipLife>  lstSipLifes ){
		this.lstSipLifes = lstSipLifes;
		this.inflater = LayoutInflater.from(context);
//	    this.lstStrings = lstStrings;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lstSipLifes.size();
	}

	@Override
	public SipLife getItem(int arg0) {
		// TODO Auto-generated method stub
		return lstSipLifes.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		ViewHeper heper = null;
		if(convertView==null){
			heper = new ViewHeper();
			convertView = inflater.inflate(R.layout.sip_life_child, null);
			heper.imgView = (ImageView) convertView.findViewById(R.id.imgSip_life_child);
			heper.txtView = (TextView) convertView.findViewById(R.id.txtTrainSipL);
		    convertView.setTag(heper);
		}else {
			heper = (ViewHeper) convertView.getTag();
		}
		heper.imgView.
		setImageBitmap(lstSipLifes.get(position).getBmThunbai());
		heper.txtView.
		setText(lstSipLifes.get(position).getTxtName());
		return convertView;
	}
   
	class ViewHeper{
		ImageView imgView;
		TextView txtView;
	}
}
