package com.kamlesh.androidminiproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity 
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
	  super.onCreate(savedInstanceState);
	  TextView tv=new TextView(this);
	  tv.setText("Second Activity");
	  setContentView(tv);
  }
}
