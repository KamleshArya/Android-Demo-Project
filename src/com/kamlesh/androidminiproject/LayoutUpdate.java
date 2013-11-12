package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//Updating Layout using handler and Thread
public class LayoutUpdate extends Activity 
{
    private TextView txtView;
	private String txtString="Start String";
	int background=Color.GRAY;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout_update);
		txtView=(TextView)findViewById(R.id.textView1);
		Button button=(Button)findViewById(R.id.button1);
		button.setOnClickListener(
	      new OnClickListener()
		    {
	    	  @Override
			  public void onClick(View v)
	    	  {
	    		doClick();  
			  }});
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.layout_update, menu);
		return true;
	}
	
	protected void doClick()
	{
		Thread thread=new Thread(
		 new Runnable()
		 {
         	@Override
			public void run() 
         	{
         		txtString="First String";
				background=Color.BLUE;
				mHandler.post(mUpdateResult);
				computation(1);
				
				txtString="Second String";
				background=Color.RED;
				mHandler.post(mUpdateResult);
				computation(2);
				
				txtString="Third String";
				background=Color.GREEN;
				mHandler.post(mUpdateResult);
				
			}
         });
		thread.start();
	}
	final Handler mHandler=new Handler();
	
	//Runnable for posting the result to ui thread
	final Runnable mUpdateResult=new Runnable()
	{
     	@Override
		public void run() 
     	{
     		txtView.setText(txtString);
     		txtView.setBackgroundColor(background);
     	}};
     	
     	//Dummy function to observe changes in ui
     	@SuppressWarnings("unused")
		protected void computation(int i)
     	{
     		for(int j=0;j<1000;j++)
     		 for(int k=0;k<1000;k++)
     		 {
     			double x= i*Math.log(j+1)/Math.log10(k+1);
     		 }
        }
	
     	 
	

}
