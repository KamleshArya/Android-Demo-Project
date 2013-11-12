package com.kamlesh.androidminiproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver
{ 
  @Override
   public void onReceive(Context context, Intent intent) 
  {
	  NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
	  final String notificationText="Alarm Triggered";
      long time=System.currentTimeMillis();
      PendingIntent pendingIntent=PendingIntent.getActivity(context,0,new Intent(context,AlarmDemo.class),0);
      
      Notification notification=new Notification(R.drawable.ic_launcher,notificationText,time);
      notification.setLatestEventInfo(context, "Alarm Notification", notificationText, pendingIntent);
      notificationManager.notify(1, notification);
  }
}
