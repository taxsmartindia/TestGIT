package org.cnc.alg.adapter;

import java.util.ArrayList;

import org.cnc.alg.R;
import org.cnc.alg.activity.ContactUsActivity;
import org.cnc.alg.activity.GMapsActivity;
import org.cnc.alg.objectjson.Contact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract.Helpers;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactUsAdapter extends BaseAdapter {
  
	private ArrayList<Contact> lstContact = new ArrayList<Contact>();
	private LayoutInflater inflater;
	private Context context;
	private boolean contactMap = true;
	
	public ContactUsAdapter(ArrayList<Contact> lstContact,
			Context context) {
		this.lstContact = lstContact;
		this.inflater = LayoutInflater.from(context);
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lstContact.size();
	}

	@Override
	public Contact getItem(int position) {
		// TODO Auto-generated method stub
		return lstContact.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		ViewHeper helper = null;
		final int p = position;
		if(convertView==null){
			helper = new ViewHeper();
			convertView = inflater.inflate(R.layout.contact_us_child, null);
			helper.txtName = (TextView) convertView.findViewById(R.id.txtName);
			helper.txtPosition = (TextView) convertView.findViewById(R.id.txtPosition);
			helper.imageView  = (ImageView) convertView.findViewById(R.id.avatar);
			helper.txtEmail = (TextView) convertView.findViewById(R.id.txtEmail);
			helper.txtPhone = (TextView) convertView.findViewById(R.id.txtPhone);
			//convertView.findViewById(R.id.a)
			//heper.btnMail = (Button) convertView.findViewById(R.id.btnContactMail);
			//heper.btnPhone = (Button) convertView.findViewById(R.id.btnContactphone);
		    convertView.setTag(helper);
		}else{
			helper = (ViewHeper) convertView.getTag();
		}
		helper.txtName.setText(lstContact.get(position).getStrName());
		helper.txtPosition.setText(lstContact.get(position).getStrPosition());
		
		helper.txtEmail.setText(lstContact.get(position).getStrEmail());
		helper.txtPhone.setText(lstContact.get(position).getStrPhone());

		if (lstContact.get(position).getStrImage() != null) {
			if (lstContact.get(position).getStrImage().equals("clodagh")) {
				helper.imageView.setImageResource(R.drawable.clodagh);
			}
			else if (lstContact.get(position).getStrImage().equals("alanroberts")) {
				helper.imageView.setImageResource(R.drawable.alanroberts);
			}
			
			else if (lstContact.get(position).getStrImage().equals("gareth")){
				helper.imageView.setImageResource(R.drawable.garethwall);
			}
			else if (lstContact.get(position).getStrImage().equals("belfast_map")){
				helper.imageView.setImageResource(R.drawable.belfast_map);
				contactMap = false;
				helper.imageView.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(context,GMapsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						intent.putExtra("contact", false);
					    context.startActivity(intent);
					}
				});
			}
			else{
				helper.imageView.setImageResource(R.drawable.map_contact);
				helper.imageView.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(context,GMapsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						intent.putExtra("contact", true);
					    context.startActivity(intent);
					}
				});
			}
		}
		
		return convertView;
	}
  class ViewHeper{
	  TextView txtName;
	  TextView txtPosition;
	  TextView txtEmail, txtPhone;
	  Button btnMail, btnPhone;
	  ImageView imageView;
  }
}
