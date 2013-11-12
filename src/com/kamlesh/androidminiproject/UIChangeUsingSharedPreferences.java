package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class UIChangeUsingSharedPreferences extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uichange_using_shared_preferences);
		
		final CheckBox checkBox=(CheckBox)findViewById(R.id.uiCheckBox);
		final android.content.SharedPreferences pref=getPreferences(MODE_PRIVATE);
		Boolean showScreen=pref.getBoolean("showScreen",true);
		
		if(showScreen)
		{
			
		}
		else
		{
			startActivity(new Intent(this,UIChangeHelperClass.class));
			finish();
		}
	    
		checkBox.setOnCheckedChangeListener
		(
		   new OnCheckedChangeListener()
		   {@SuppressLint("CommitPrefEdits")
		    @Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) 
		    {
			  Editor editor=pref.edit();
			  editor.putBoolean("showScreen",checkBox.isChecked());
			  editor.commit();
			}});
	}
}
