package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//Progress Bar Demo
public class ProgressBar extends Activity 
{
    private android.widget.ProgressBar progressBar;
    private int counter=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_bar);
		progressBar=(android.widget.ProgressBar)findViewById(R.id.progressBar);
		Button button=(Button)findViewById(R.id.progressButton);
		progressBar.setProgress(counter);
		button.setOnClickListener
		(
		  new OnClickListener()
		  {
           @Override
			public void onClick(View v) 
            {
			 counter=counter+1;
			 progressBar.setProgress(counter);
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.progress_bar, menu);
		return true;
	}

}
