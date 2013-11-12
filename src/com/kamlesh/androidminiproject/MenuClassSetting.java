package com.kamlesh.androidminiproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MenuClassSetting extends Activity 
{
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView txtView = new TextView(this);
		txtView.setText("Kamlesh Arya");
		setContentView(txtView);
	}
}
