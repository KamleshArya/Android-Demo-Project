package com.kamlesh.androidminiproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

//To write file into External storage device->androidmanifest.xml->permissions->add->Uses Permission->write:external storage
//To write in file
public class FileOperationsWrite extends Activity 
{
	private EditText editText;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_operations_write);
		editText=(EditText)findViewById(R.id.fileOperationsTB);
		button=(Button)findViewById(R.id.fileOperationsB);
		button.setOnClickListener(
		   new OnClickListener()
		   {@Override
			public void onClick(View v) 
		    {
//			   FileOutputStream output=null;
//			   try
//			   {
//				   output=openFileOutput("myFile",MODE_PRIVATE);
//				   //To write edittext message into file
//				   output.write(editText.getText().toString().getBytes());
//			   }
//			   catch(Exception e){}
//			   finally
//			   {
//				if(output!=null)
//				{
//					try
//					{
//						output.flush();
//						output.close();
//					}
//					catch(Exception e){}
//				}
//			   }
			   
			   
			   
			   //Storing file on external Storage-SD
			   String fileName="myFile.txt";
			   File sDir=new File("/sdcard"); //Get SDcard Directory reference
			   if(sDir.exists() && sDir.canWrite())
			   {
				   //File creation in SD 
				   File Dir=new File(sDir.getAbsolutePath()+"/Kamlesh"); //Instantiate file for path
				   Dir.mkdir();
				   if(Dir.exists() && Dir.canWrite())
				   {
					   File file=new File(Dir.getAbsolutePath()+fileName);
					   try 
					   {
						file.createNewFile();
					   } 
					   catch (Exception e) {}
					   
					//Writing file
					 if(file.exists() && file.canWrite())
					 {
						FileOutputStream output=null;
						try 
						{
						  output=new FileOutputStream(file);
						  output.write(editText.getText().toString().getBytes());
						} 
						catch (Exception e){} 
						finally
						{
							if(output!=null)
							{
								try 
								{
									output.flush();
									output.close();
								} 
								catch (Exception e2) {}
							}
						}
				    }
					   
				   }
			   }
			   
			   
			   //After write activity,call read activity
			   startActivity(new Intent(FileOperationsWrite.this,FileOperationsRead.class));
			   }});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.file_operations, menu);
		return true;
	}

}
