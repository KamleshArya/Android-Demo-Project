package com.kamlesh.androidminiproject;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class LocationDemo extends Activity 
{
    private TextView textView;
    private LocationManager locationManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_demo);
		textView=(TextView)findViewById(R.id.locationTV);
		locationManager=(LocationManager)getSystemService(LOCATION_SERVICE);
		Criteria criteria=new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		String provider=locationManager.getBestProvider(criteria, true);
		locationManager.requestLocationUpdates(provider, 5000, 5,new LocationListener() 
		{
			@Override
			public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLocationChanged(Location location) 
			{
				double lattitude=location.getLatitude();
				double longitude=location.getLongitude();
				
				textView.setText("Latitude : " + lattitude + "\n Longitude : " + longitude);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location_demo, menu);
		return true;
	}

}
