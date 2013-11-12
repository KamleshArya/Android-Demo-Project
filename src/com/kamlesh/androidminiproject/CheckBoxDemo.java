package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckBoxDemo extends Activity 
{
    private TextView txtView;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box_demo);
		txtView=(TextView)findViewById(R.id.chkText2);
		class Colors
		{
			private Boolean Red,green,Blue;
		}
		final Colors color=new Colors();
		CheckBox checkBox[]=
	     {
				(CheckBox)findViewById(R.id.red),
				(CheckBox)findViewById(R.id.blue),
				(CheckBox)findViewById(R.id.green)
		 };
		
		checkBox[0].setOnClickListener
		(
		  new OnClickListener()
		  {
			@Override
			public void onClick(View v) 
			{
				if(((CheckBox)v).isChecked()) color.Red=true;				
				else color.Red=false;
				txtView.setText(" " + color.Blue+ " " + color.green+ " " +color.Red + " ");
			}});
		
		checkBox[1].setOnClickListener
		(
		  new OnClickListener()
		  {
			@Override
			public void onClick(View v) 
			{
				if(((CheckBox)v).isChecked()) color.Blue=true;				
				else color.Blue=false;
				txtView.setText(" " + color.Blue+ " " + color.green+ " " +color.Red + " ");
			}});
		checkBox[2].setOnClickListener
		(
		  new OnClickListener()
		  {
			@Override
			public void onClick(View v) 
			{
				if(((CheckBox)v).isChecked()) color.green=true;				
				else color.green=false;
				txtView.setText(" " + color.Blue+ " " + color.green+ " " +color.Red + " ");
			}});
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.check_box_demo, menu);
		return true;
	}

}
