package com.kamlesh.androidminiproject;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AudioDemo extends Activity 
{
	private Button button;
	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_audio_demo);
		prepareMediaPlayer();
		button=(Button)findViewById(R.id.audioB);
		button.setOnClickListener(
				new OnClickListener()
				{
                    @Override
					public void onClick(View v) 
                    {
                    	mediaPlayer=new MediaPlayer();
                    	//Sample Music Play
                    	String path=Environment.getExternalStorageDirectory().getAbsolutePath()+"/sample.mp3";
                    	if(mediaPlayer.isPlaying())
                    	{
                    		pauseMediaPlayer();
                    	}
                    	else
                    	{
                    		startMediaPalyer();
                    	}
					}

					private void startMediaPalyer() 
					{
						mediaPlayer.start();
						button.setText("Pause");
					}

					private void pauseMediaPlayer() 
					{
						button.setText("Play");
						mediaPlayer.pause();
					}});
	}

	private void prepareMediaPlayer() 
	{
		String path=Environment.getExternalStorageDirectory().getAbsolutePath()+"/sample.mp3";	
		try {
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepare();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.audio_demo, menu);
		return true;
	}

}
