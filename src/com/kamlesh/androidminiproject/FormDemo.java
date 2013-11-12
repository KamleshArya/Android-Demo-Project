package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Simple Form Demo
public class FormDemo extends Activity 
{
    private EditText name;
    private EditText email;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form_demo);
		name=(EditText)findViewById(R.id.name);
		email=(EditText)findViewById(R.id.email);
		Button button=(Button)findViewById(R.id.Submit);
		final TextView txtView=(TextView)findViewById(R.id.displayResult);
		button.setOnClickListener
		(
		  new OnClickListener()
		  {
            @Override
			public void onClick(View v) 
             {
				String strName=name.getText().toString();
				String strEmail=email.getText().toString();
				txtView.setText("Name Is = " + strName + "Email = " + strEmail);
		     }});
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
	    getMenuInflater().inflate(R.menu.form_demo, menu);
		return true;
	}
}
