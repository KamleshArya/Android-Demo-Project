package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class RecordAudioDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record_audio_demo);
		Button button=(Button)findViewById(R.id.recordAudioB);
		button.setOnClickListener(
				new OnClickListener()
				{
                    @Override
					public void onClick(View v) 
                    {
					 Intent intent=new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);	
					 startActivityForResult(intent,0);
					}
					
				});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 0)
			if(resultCode == RESULT_OK)
			{
				String path=data.getData().getPath();
				Toast.makeText(RecordAudioDemo.this, path, Toast.LENGTH_LONG).show();
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.record_audio_demo, menu);
		return true;
	}

}
