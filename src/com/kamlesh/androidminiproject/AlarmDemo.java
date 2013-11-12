package com.kamlesh.androidminiproject;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlarmDemo extends Activity 
{
	private NotificationManager notifcationManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_demo);
		notifcationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		Button btn=(Button)findViewById(R.id.alarm);
		btn.setOnClickListener
		(
				new OnClickListener()
				{
					@Override
					public void onClick(View arg0) 
					{
						Intent intent=new Intent(AlarmDemo.this,AlarmReceiver.class);
						String ms;
					
						PendingIntent pendingIntent=PendingIntent.getBroadcast(AlarmDemo.this,0,intent, 0);
						AlarmManager alarmManager= (AlarmManager)getSystemService(Context.ALARM_SERVICE);
						
						//Set time  to manage alarm after 10 sec.
						Calendar calendar=Calendar.getInstance();
						calendar.setTimeInMillis(System.currentTimeMillis());
						calendar.add(calendar.SECOND,10);
						alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
						Toast.makeText(AlarmDemo.this," Alarm in 10 sec ",Toast.LENGTH_LONG).show();
					}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.alarm_demo, menu);
		return true;
	}

}
