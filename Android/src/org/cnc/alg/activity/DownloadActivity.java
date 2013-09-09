package org.cnc.alg.activity;

import org.cnc.alg.R;
import org.cnc.alg.mail.GMailSender;
import org.cnc.alg.util.Constant;
import org.cnc.alg.util.DialogManager;
import org.cnc.alg.util.NetworkStatus;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DownloadActivity extends Activity{
  
	private Button btnSendMail;
	private EditText edtYourMail;
//	private String strMailcontent;
//	private String strMailSubject;
	private GMailSender sender;
	private DialogManager dialogManager;
	private NetworkStatus networkStatus;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		boolean b = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	    setContentView(R.layout.download);
	    if(b){
	    	getWindow().setFeatureInt( Window.FEATURE_CUSTOM_TITLE ,R.layout.customtitle);
	    	TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
	    	txtTitle.setText(Constant.Dowload);
	    	Button btnBack = (Button) findViewById(R.id.btnBack);
	    	btnBack.setOnClickListener(backClickListener);
	    	Button btnHome = (Button) findViewById(R.id.btnHome);
	    	btnHome.setVisibility(View.INVISIBLE);
	    }
	    
	    btnSendMail = (Button) findViewById(R.id.btnSentMail);
	    edtYourMail = (EditText) findViewById(R.id.edtEmailDownload);
//	    strMailcontent = "Thank you for requesting the Application forms. Here is the download link: "+
//	    	"http://www.algoodbody.com/getAttachment.aspx?id=9243b7cc-33e1-4ba3-af44-a4cf378510b0";
//	    strMailSubject = "A&L Goodbody Application Forms";
	    btnSendMail.setOnClickListener(sendClickListener);
	}
	
    //--- send mail	
	private OnClickListener sendClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			networkStatus = new NetworkStatus(DownloadActivity.this);
			dialogManager = new DialogManager(DownloadActivity.this);
			if(networkStatus.isConnect()){
				new SendMail().execute();	
			} else {
				dialogManager.showDlgError(getResources().getString(R.string.enable_network));
			}
			
		}
	};
	
	
	private OnClickListener backClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(DownloadActivity.this, HomeScreenActivity.class);
			finish();
			startActivity(intent);
		}
	};
	
	class SendMail extends AsyncTask<Void, Void, Void>{
		
		private String result;
		private ProgressDialog dialog;
           @Override
        protected void onPreExecute() {
        	// TODO Auto-generated method stub
        	
	    dialog = new ProgressDialog(DownloadActivity.this);
	    dialog.setTitle("Sending Mail");
	    dialog.setMessage("Please Wait...");
	    dialog.setCancelable(true);
	    dialog.show();
        	super.onPreExecute();
        	
        }
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			sender = new GMailSender("trunganh2801@gmail.com", "maiductrung");
			String  recipients = edtYourMail.getText().toString();
			try {
			 result=	sender.sendMail(Constant.MAIL_SUBJECT, Constant.MAIL_CONTENT, "trunganh2801@gmail.com", recipients);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			dialog.dismiss();
			edtYourMail.setText("");
			if(this.result!=null){
				Toast.makeText(DownloadActivity.this, Constant.MAIL_SEND, Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(DownloadActivity.this, Constant.MAIL_SEND_FAIL, Toast.LENGTH_SHORT).show();
			}
			super.onPostExecute(result);
		}
	}
	
 }
