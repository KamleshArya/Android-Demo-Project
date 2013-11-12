package com.kamlesh.androidminiproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class InterceptorHelperOutgoingCall extends BroadcastReceiver
{
    @Override
	public void onReceive(Context context, Intent intent) 
    {
	  	if(intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL))
	  	{
	  		String phoneNumber=intent.getExtras().getString(Intent.EXTRA_PHONE_NUMBER);
	  		//will display toast while mak9ing outgoing calls thus intercepting
	  		Toast.makeText(context, phoneNumber, Toast.LENGTH_LONG).show();
	  		//android-manifest-add broadcast receiver-InterceptorHelperOutgoinCall
	  		//uses permission-process outgoing calls
	  	}
	}

}
