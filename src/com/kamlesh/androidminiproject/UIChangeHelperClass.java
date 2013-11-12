package com.kamlesh.androidminiproject;

import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//layout->android xml file/root layout-Linear layout
public class UIChangeHelperClass extends Activity 
{
    @Override
	protected void onCreate(Bundle savedInstanceState) 
    {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.uichangehelperclass);
		Button button=new Button(this);
		button.setOnClickListener(
		  new OnClickListener()
		  {
            @Override
			public void onClick(View arg0) 
            {
			  android.content.SharedPreferences pref=getPreferences(MODE_PRIVATE);
			  Editor edit=pref.edit();
			  edit.putBoolean("showScreen",true);
			  edit.commit();
			  finish();
			}});
	}
  }
