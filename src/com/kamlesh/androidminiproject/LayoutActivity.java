package com.kamlesh.androidminiproject;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

//Creating Layout Programmatically
public class LayoutActivity extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		RelativeLayout relob=new RelativeLayout(this);
		relob.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		
		TextView txt=new TextView(this);
		txt.setText("Kamlesh");
		txt.setTag(1001);//ID
		RelativeLayout.LayoutParams txtLayout=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		txtLayout.addRule(RelativeLayout.CENTER_IN_PARENT);
		
		//adding text view to relative layout
		relob.addView(txt,txtLayout);
		
		TextView txt2 =new TextView(this);
		txt2.setText("Arya");
		RelativeLayout.LayoutParams txt2Layout=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		txt2Layout.addRule(RelativeLayout.ABOVE,1001);
		relob.addView(txt2,txt2Layout);
		
		setContentView(relob);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout, menu);
		return true;
	}

}
