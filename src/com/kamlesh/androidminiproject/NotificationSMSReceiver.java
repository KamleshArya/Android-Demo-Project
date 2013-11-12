package com.kamlesh.androidminiproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

//Helper class to receive SMS
public class NotificationSMSReceiver extends BroadcastReceiver 
{
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		StringBuilder sb=new StringBuilder();
		Bundle bundle=intent.getExtras();
		if(bundle!=null)
		{
			Object[] pdus=(Object[])bundle.get("pdus");
			for(Object pd:pdus)
			{
				SmsMessage smsMessage=SmsMessage.createFromPdu((byte[]) pd);
				sb.append(smsMessage.getDisplayMessageBody());
			}
		}
	  NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
	  String tickerMsg=sb.toString();
	  long time=System.currentTimeMillis();
	  
	  Intent intn=new Intent(context,NotificationDemo.class);
	  PendingIntent contentIntent=PendingIntent.getActivity(context, 0, intent, 0);
	  
	  Notification notification=new Notification(R.drawable.ic_launcher,tickerMsg,time);
	  notification.setLatestEventInfo(context, "SMS Received", tickerMsg, contentIntent);
	  notificationManager.notify(0,notification);
	}

}
