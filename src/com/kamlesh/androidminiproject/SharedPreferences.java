package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.widget.TextView;

public class SharedPreferences extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		//Data Entry using Shared preferences
		android.content.SharedPreferences pref=getPreferences(MODE_PRIVATE);
		Editor editor=pref.edit();
		editor.putString("NAME","Kamlesh Arya");
		editor.putString("EMAIL","k.k.meghwal@gmail.com");
		editor.commit();
		
		//Data Retrieval
		String name=pref.getString("NAME","Default Name");
		String email=pref.getString("EMAIL","Default Email ");
		TextView txtView=new TextView(this);
		txtView.setText("NAME : " + name +" " + " EMAIL : " + email);
		setContentView(txtView);
	}

	@Override 
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.shared_preferences, menu);
		return true;
	}

}
