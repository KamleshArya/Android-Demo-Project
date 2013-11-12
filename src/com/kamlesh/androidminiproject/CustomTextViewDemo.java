package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

//Changing Text color and Font using TextView class
public class CustomTextViewDemo extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		MyTextView myTextView=new MyTextView(this);
		myTextView.setText("Kamlesh Arya"); 
		setContentView(myTextView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		
		getMenuInflater().inflate(R.menu.custom_text_view_demo, menu);
		return true;
	}

}
