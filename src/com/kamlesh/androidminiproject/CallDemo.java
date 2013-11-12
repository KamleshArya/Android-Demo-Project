package com.kamlesh.androidminiproject;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//manifest->callphone user permission
public class CallDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call_demo);
		
		Button button=(Button)findViewById(R.id.callButton);
		button.setOnClickListener(
				new OnClickListener(){

					@Override
					public void onClick(View v)
					{
					 startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + "911")));
					}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.call_demo, menu);
		return true;
	}

}
