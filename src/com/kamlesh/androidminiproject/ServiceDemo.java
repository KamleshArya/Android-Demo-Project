package com.kamlesh.androidminiproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

//Service Class-Not used right now
public class ServiceDemo extends Service {

	@Override
	public IBinder onBind(Intent arg0) 
	{	
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent,int flags,int startId)
	{
		return super.onStartCommand(intent, flags, startId);
    }
	
	public void onDestroy()
	{
		super.onDestroy();
	}
}
