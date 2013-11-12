package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlertDialogBox extends Activity 
{
    private static final int ALERT_DIALOG=0;
    private static final int CONFIRMATION_DIALOG=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert_dialog_box);
		Button btn=(Button)findViewById(R.id.Dialog); 
		btn.setOnClickListener
		 (
		    new OnClickListener()
		    {
              @SuppressWarnings("deprecation")
			  @Override
              public void onClick(View arg0) 
              {
				showDialog(ALERT_DIALOG);
			  }});
	 }

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id, Bundle args) 
	{
		Dialog dialog=null;
		switch(id)
		{
		case ALERT_DIALOG:
		AlertDialog.Builder builder	= new AlertDialog.Builder(this);
		builder.setMessage("This is an Alert Message");
		builder.setCancelable(false);
		builder.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{	
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				dialog.dismiss();
		}});
		dialog=builder.create(); 
		break;
		
		case CONFIRMATION_DIALOG:
			//builder=
			break;
		
		default: 
			 return super.onCreateDialog(id, args);
		}
		
		return dialog;   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.alert_dialog_box, menu);
		return true;
	}
}
