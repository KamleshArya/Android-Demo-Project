package com.kamlesh.androidminiproject;

import java.util.List;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForwardGeoCoderDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forward_geo_coder_demo);
		final EditText editText=(EditText)findViewById(R.id.forwardGeoCoderET);
		Button button=(Button)findViewById(R.id.forwardGeoCoderB);
		button.setOnClickListener(
				new OnClickListener()
				{
                    @Override
					public void onClick(View arg0) 
                    {
                    	Geocoder geocoder=new Geocoder(ForwardGeoCoderDemo.this);
                    	String address=editText.getText().toString();
                    	List<Address> location=null;
                    	try
                    	{
                    		location=geocoder.getFromLocationName(address,10);
                    	}
                    	catch(Exception ex){}
                    	finally
                    	{
                    		TextView tv=(TextView)findViewById(R.id.forwardGeoCoderTV); 
                    		double latitude=location.get(0).getLatitude();
                    		double longitude=location.get(0).getLongitude();
                    		tv.setText("Latitude : " + latitude + "\n Longitude : " + longitude);
                    	}
					}
					
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.forward_geo_coder_demo, menu);
		return true;
	}

}
