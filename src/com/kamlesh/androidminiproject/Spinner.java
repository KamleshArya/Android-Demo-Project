package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;

//Spinner Example-some Problem in code
public class Spinner extends Activity 
{
    private static String[] colors={"Red","Blue","Green","Yellow"};
    
	
    @Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner);
		android.widget.Spinner spinner=(android.widget.Spinner)findViewById(R.id.spinnerColor);
		ArrayAdapter<String> mAdapter=new ArrayAdapter<String>(Spinner.this,android.R.layout.simple_spinner_item,colors);
		spinner.setAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spinner, menu);
		return true;
	}
}
