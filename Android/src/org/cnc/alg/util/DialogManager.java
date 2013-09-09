package org.cnc.alg.util;

import org.cnc.alg.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class DialogManager {
      private Activity activity;
      private Dialog dlgConfirmQuit, dlgMessage , dlgError;
      private ProgressDialog progressDialog;
      private Context context;
      
      public DialogManager(Activity activity){
    	  this.activity  = activity;
    	  context = activity.getBaseContext();
    	  creatDialog();
      }
      
      private void creatDialog(){
    	  dlgConfirmQuit = new AlertDialog.Builder(activity).
    			  setTitle(context.getResources().getString(R.string.quit)).
    			  setPositiveButton(context.getResources().getString(R.string.yes), new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						dlgConfirmQuit.dismiss();
						activity.finish();
					}
				}).setNegativeButton(context.getResources().getString(R.string.no), new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dlgConfirmQuit.dismiss();
					}
				}).setCancelable(false).create();
    	  dlgMessage = new AlertDialog.Builder(activity)
			.setTitle("")
			.setPositiveButton(context.getResources().getString(R.string.ok),
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							dlgMessage.dismiss();
						}
					}).setCancelable(false).create();

	dlgError = new AlertDialog.Builder(activity)
			.setPositiveButton(activity.getResources().getString(R.string.ok),
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dlgError.dismiss();
//							activity.finish();
						}
					}).setCancelable(false).create();

	progressDialog = new ProgressDialog(activity);
	progressDialog.setMessage(activity.getResources().getString(R.string.loading));
	progressDialog.setCancelable(false);
      }
      
      public void showDlgConfirmQuit() {
  		activity.runOnUiThread(new Runnable() {

  			@Override
  			public void run() {
  				dlgConfirmQuit.show();
  			}
  		});
  	}

  	public void hideDlgConfirmQuit() {
  		activity.runOnUiThread(new Runnable() {

  			@Override
  			public void run() {
  				dlgConfirmQuit.dismiss();
  			}
  		});
  	}

  	public void showDlgMessage(String message) {
  		final String m = message;
  		activity.runOnUiThread(new Runnable() {

  			@Override
  			public void run() {
  				dlgMessage.setTitle(m);
  				dlgMessage.show();
  			}
  		});
  	}

  	public void showDlgError(String title) {
  		final String t = title;
  		activity.runOnUiThread(new Runnable() {

  			@Override
  			public void run() {
  				dlgError.setTitle(t);
  				dlgError.show();
  			}
  		});
  	}



  	public void hideDlgMessage() {
  		activity.runOnUiThread(new Runnable() {

  			@Override
  			public void run() {
  				dlgMessage.dismiss();
  			}
  		});
  	}


  	public void showDlgLoading() {
  		try{
  		if(!progressDialog.isShowing())
      			progressDialog.show();
  		}catch (Exception e) {
  			// TODO: handle exception
  		}
  	}

  	public void hideDlgLoading() {
  		try{
  			if(progressDialog.isShowing())
  			 progressDialog.dismiss();
  		}catch (Exception e) {
  			// TODO: handle exception
  		}
  		
  	}

  	public void hideDlgError() {
  		dlgError.dismiss();
  	}
}
