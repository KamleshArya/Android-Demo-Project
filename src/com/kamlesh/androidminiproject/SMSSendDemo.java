package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSSendDemo extends Activity 
{

	private EditText number;
	private EditText message;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_smssend_demo);
		number=(EditText)findViewById(R.id.smsET1);
		message=(EditText)findViewById(R.id.smsET2);
		Button button=(Button)findViewById(R.id.smsB);
		button.setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
					   SmsManager smsManager=SmsManager.getDefault();	
					   //will send a broadcast when message is send successfully
					   final PendingIntent pendingIntent=PendingIntent.getBroadcast(SMSSendDemo.this, 0, new Intent(), 0);
					   
					   //destination number from first text box
					   String dest=number.getText().toString();
					   //to check whether enter number is valid
					   if(PhoneNumberUtils.isWellFormedSmsAddress(dest))
					   {
						   smsManager.sendTextMessage(dest, null, message.getText().toString(), pendingIntent, null);
						   Toast.makeText(SMSSendDemo.this,"Message is Send", Toast.LENGTH_LONG).show();
						   //modify manifest-uses permission
					   }
					}
					
				});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.smssend_demo, menu);
		return true;
	}

}
