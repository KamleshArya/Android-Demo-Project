package com.kamlesh.androidminiproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

public class SMSReceiverDemo extends BroadcastReceiver 
{
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		if(intent.getAction().equals("android.kamlesh.SMS_RECEIVED"))
		{
			StringBuilder sb=new StringBuilder();
			Bundle bundle=intent.getExtras();
			if(!bundle.isEmpty())
			{
				Object[] pdus=(Object[]) bundle.get("pdus");
				for(Object pdu:pdus)
				{
				 SmsMessage smsMessage=SmsMessage.createFromPdu((byte[]) pdu);	
				 sb.append(smsMessage.getDisplayMessageBody());
				}
			}
			Toast.makeText(context,sb.toString() ,Toast.LENGTH_LONG ).show();
		}
		
	}

}
