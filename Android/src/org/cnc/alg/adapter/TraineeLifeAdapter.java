package org.cnc.alg.adapter;

import java.util.ArrayList;

import org.cnc.alg.R;
import org.cnc.alg.objectjson.TraineeLife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TraineeLifeAdapter extends BaseAdapter {
    
	private ArrayList<TraineeLife> lstTraineeLifes = new ArrayList<TraineeLife>();
	private LayoutInflater inflater;
//	private ArrayList<String> lstStrings;
	public TraineeLifeAdapter(Context context, 
			ArrayList<TraineeLife>  lsTraineeLifes ){
		this.lstTraineeLifes = lsTraineeLifes;
		this.inflater = LayoutInflater.from(context);
//	    this.lstStrings = lstStrings;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lstTraineeLifes.size();
	}

	@Override
	public TraineeLife getItem(int arg0) {
		// TODO Auto-generated method stub
		return lstTraineeLifes.get(arg0);
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
			convertView = inflater.inflate(R.layout.trainee_life_child, null);
			heper.imgView = (ImageView) convertView.findViewById(R.id.imgTrainee_life_child);
			heper.txtView = (TextView) convertView.findViewById(R.id.txtTrainl);
		    convertView.setTag(heper);
		}else {
			heper = (ViewHeper) convertView.getTag();
		}
		heper.imgView.
		setImageBitmap(lstTraineeLifes.get(position).getBmThunbai());
		heper.txtView.
		setText(lstTraineeLifes.get(position).getTxtName());
		return convertView;
	}
   
	class ViewHeper{
		ImageView imgView;
		TextView txtView;
	}
}
