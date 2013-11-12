package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class TelephonyDemo extends Activity 
{
	private TelephonyManager telephonyManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_telephony_demo);
		
		telephonyManager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		TextView textView=(TextView)findViewById(R.id.telephony);
		textView.setText(getInfomation());
		
		//modify Manifest:add permission to read phone state and coarse location
	}

	private String getInfomation() 
	{
		int callState=telephonyManager.getCallState();
		String callStateStr=null;
		switch (callState) 
		{
		 case TelephonyManager.CALL_STATE_IDLE:
			  callStateStr="IDLE";
			  break;

		 case TelephonyManager.CALL_STATE_OFFHOOK:
			  callStateStr="OFF_HOOK";
			  break;

		 case TelephonyManager.CALL_STATE_RINGING:
			  callStateStr="RINGING";
			  break;

		default:
			break;
		}
		
		//GsmCellLocation cellLocation=(GsmCellLocation) telephonyManager.getCellLocation();
		//Cell Location Will not work in case of emulator
		//String cellLocationString=cellLocation.getLac() + " " + cellLocation.getCid();
		
		int simState=telephonyManager.getSimState();
		
		String simStateStr="OTHER";
		
		switch (simState) 
		{
		 case TelephonyManager.SIM_STATE_ABSENT:
			  simStateStr="ABSENT";
		 	  break;

		 default:
			  break;
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append("CALL STATE : " + callStateStr);
		//sb.append("CALL Location : " + cellLocationString);
		sb.append("\n Device ID : " + telephonyManager.getDeviceId());
		sb.append("\n Device software Information : " + telephonyManager.getDeviceSoftwareVersion());
		sb.append("\n Line Number : " + telephonyManager.getLine1Number());
		sb.append("\n Network Country : " + telephonyManager.getNetworkCountryIso());
		sb.append("\n Network Operator : " + telephonyManager.getNetworkOperator());
		sb.append("\n Network Operator Name : " + telephonyManager.getNetworkOperatorName());
		sb.append("\n SIM Operator Name : " + telephonyManager.getSimOperatorName());
		sb.append("\n SIM State : " + simStateStr);
		
		return sb.toString();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.telephony_demo, menu);
		return true;
	}

}
