package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//Changing Text color on button Click
public class TextViewDemo extends Activity 
{
	private TextView txtView;
	private int colors[]={Color.BLUE,Color.RED,Color.GREEN};
	private int counter=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_view_demo);
		txtView=(TextView)findViewById(R.id.textView1);
		Button button=(Button)findViewById(R.id.button1);
		button.setOnClickListener
		(
			new OnClickListener()
			 {
               @Override
			   public void onClick(View v) 
             	{
			      txtView.setTextColor(colors[counter]);
			      counter=(counter+1)%3;
				}}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.text_view_demo, menu);
		return true;
	}

}
