package org.cnc.alg.adapter;

import java.util.ArrayList;

import org.cnc.alg.R;
import org.cnc.alg.activity.SipKeyDateActivity;
import org.cnc.alg.activity.SipKeyDateViewActivity;
import org.cnc.alg.objectjson.DateKeySip;
import org.cnc.alg.util.Constant;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SipKeyDateAdapter extends BaseAdapter {

	private ArrayList<DateKeySip> mLstDateKeys = new ArrayList<DateKeySip>();
	private LayoutInflater mInflater;
	private SipKeyDateActivity sipKeyDateActivity;
	public SipKeyDateAdapter(Context context, ArrayList<DateKeySip> mListDateKeys){
		this.mLstDateKeys = mListDateKeys;
		mInflater = LayoutInflater.from(context);
		sipKeyDateActivity = (SipKeyDateActivity) context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mLstDateKeys.size();
	}

	@Override
	public DateKeySip getItem(int position) {
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
		final int p = position;
		ViewHeper mViewHeper = null;
		if(convertView==null){
			mViewHeper = new ViewHeper();
			convertView = mInflater.inflate(R.layout.sip_keydate_child, null);
			mViewHeper.mTxtDate = (TextView) convertView.findViewById(R.id.txtSipKeyDateDate);
			mViewHeper.mTxtContent = (TextView) convertView.findViewById(R.id.txtSipKeyDateContent);
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
			 Intent intent = new Intent(sipKeyDateActivity, SipKeyDateViewActivity.class); 	
			 intent.putExtra(Constant.SIP_CONTENT_DATE,
					getItem(p).getMtitle()+"\n"+getItem(p).getDate() ); 
			 intent.putExtra(Constant.SIP_CONTENT, getItem(p).getDateContent());
			 sipKeyDateActivity.startActivity(intent);
			 //sipKeyDateActivity.finish();
			}
		});
		return convertView;
	}
   
	class ViewHeper{
		TextView mTxtDate;
		TextView mTxtContent;
	}
}
