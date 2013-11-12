package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PhoneUtilityDemo extends Activity 
{

	private EditText editText;
	private TextView textView1;
	private TextView textView2;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_utility_demo);
		editText=(EditText)findViewById(R.id.phnUtilityETB);
		textView1=(TextView)findViewById(R.id.phnUtilityTB);
		textView2=(TextView)findViewById(R.id.phnUtilityTB2);
		
		Button button =(Button)findViewById(R.id.phnUtilityB);
		button.setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
						//getting phone number as string in edit text
						String phoneNumber=PhoneNumberUtils.formatNumber(editText.getText().toString());
						//conversion into digits
						phoneNumber=PhoneNumberUtils.convertKeypadLettersToDigits(phoneNumber);
						
						StringBuilder sb=new StringBuilder();
						sb.append(phoneNumber);
						sb.append(" \n is Global " + PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber));
						sb.append(" \n is Emergency " + PhoneNumberUtils.isEmergencyNumber(phoneNumber));
						textView1.setText(sb.toString());
					}
					
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_utility_demo, menu);
		return true;
	}

}
