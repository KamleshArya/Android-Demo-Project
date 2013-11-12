package com.kamlesh.androidminiproject;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

//Helper class for CustomTextViewDemo.java
public class MyTextView extends TextView 
{
	public MyTextView(Context context) 
	{
		super(context);
		this.setTextColor(Color.BLUE);
		this.setTextSize(20.0f);
	}
}
