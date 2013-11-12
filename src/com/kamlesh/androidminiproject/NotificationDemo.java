package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

//Eg. To notify an SMS to a user
public class NotificationDemo extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification_demo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.notification_demo, menu);
		return true;
	}
}
