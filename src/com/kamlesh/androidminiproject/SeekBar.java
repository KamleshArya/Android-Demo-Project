package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBar extends Activity 
{
   private android.widget.SeekBar seekBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seek_bar);
		seekBar=(android.widget.SeekBar)findViewById(R.id.seekBar);
		final TextView txtView=(TextView)findViewById(R.id.seekValue);
		seekBar.setOnSeekBarChangeListener
		(
		   new OnSeekBarChangeListener()
		   {
             @Override
			 public void onProgressChanged(android.widget.SeekBar arg0,int progress, boolean arg2) 
             {
			    txtView.setText(progress + " ");		
			 }

			@Override
			public void onStartTrackingTouch(android.widget.SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(android.widget.SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			   
		   });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.seek_bar, menu);
		return true;
	}

}
