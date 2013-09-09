package org.cnc.alg.adapter;

import java.util.ArrayList;

import org.cnc.alg.R;
import org.cnc.alg.activity.TraineeKeyDateActivity;
import org.cnc.alg.activity.TraineeKeyDateViewActivity;
import org.cnc.alg.objectjson.DateKeyTrainee;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TraineeKeyDateAdapter extends BaseAdapter {

	private ArrayList<DateKeyTrainee> mLstDateKeys = new ArrayList<DateKeyTrainee>();
	private LayoutInflater mInflater;
	private TraineeKeyDateActivity traineeKeyDateActivity;
	public TraineeKeyDateAdapter(Context context, ArrayList<DateKeyTrainee> mListDateKeys){
		this.mLstDateKeys = mListDateKeys;
		mInflater = LayoutInflater.from(context);
		traineeKeyDateActivity = (TraineeKeyDateActivity) context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mLstDateKeys.size();
	}

	@Override
	public DateKeyTrainee getItem(int position) {
		// TODO Auto-generated method stub
		return mLstDateKeys.get(position);
	}

	@Override
	public long getItemId(int positon) {
		// TODO Auto-generated method stub
		return positon;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
	 final	int p = position;
		ViewHeper mViewHeper = null;
		if(convertView==null){
			mViewHeper = new ViewHeper();
			convertView = mInflater.inflate(R.layout.trainee_keydate_child, null);
			mViewHeper.mTxtDate = (TextView) convertView.findViewById(R.id.txtTraineeKeyDateDate);
			mViewHeper.mTxtContent = (TextView) convertView.findViewById(R.id.txtTraineeKeyDateContent);
			convertView.setTag(mViewHeper);
		}else{
			mViewHeper = (ViewHeper) convertView.getTag();
		}
		mViewHeper.mTxtDate.setText(mLstDateKeys.get(position).getDate());
		mViewHeper.mTxtContent.setText(mLstDateKeys.get(position).getMtitle());
	    
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 Intent intent = new Intent(traineeKeyDateActivity, TraineeKeyDateViewActivity.class); 	
			 intent.putExtra("content_date",
					getItem(p).getMtitle()+"\n"+getItem(p).getDate() ); 
			 intent.putExtra("content", getItem(p).getDateContent());
			 traineeKeyDateActivity.startActivity(intent);
			 //traineeKeyDateActivity.finish();
			 
			}
		});
		return convertView;
	}
   
	class ViewHeper{
		TextView mTxtDate;
		TextView mTxtContent;
	}
}
