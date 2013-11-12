package com.kamlesh.androidminiproject;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ImageDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_demo);
		Button button=(Button)findViewById(R.id.imageB);
		button.setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View arg0) 
					{
						Intent intent=new Intent();
						intent.setType("image/*");
						intent.setAction(Intent.ACTION_GET_CONTENT);
						startActivityForResult(intent, 0);
					}
					
				});
		
	}
    
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==0)
			if(resultCode == RESULT_OK)
			{
				Uri imageUri=data.getData();
				ImageView imageView=(ImageView)findViewById(R.id.imageIV);
				imageView.setImageURI(imageUri);
			}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.image_demo, menu);
		return true;
	}

}
