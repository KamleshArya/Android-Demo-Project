package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.preference.PreferenceActivity;

//res/Create new xml/type=preferences/prefsetting.xml
public class PreferencesFramework extends PreferenceActivity 
{
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefsettings);
	}
}
