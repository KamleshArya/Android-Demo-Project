package com.kamlesh.androidminiproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

//To read from a file
//To read from Text file-helper folder.make this class as launcher
public class FileOperationsRead extends Activity 
{
  private EditText text;
  private Button btn;
  protected void onCreate(Bundle savedInstanceState)
  {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_file_operations_read);
	  text=(EditText)findViewById(R.id.fileOperationsTBRead);
	  btn=(Button)findViewById(R.id.fileOperationsBRead);
	  
	  //On Click Listener when reading from FileOperationsWrite.demo
	  btn.setOnClickListener(
			  new OnClickListener()
			  {
                @Override
				public void onClick(View arg0) 
                {
					//when reading from text file "helper" inside "helper" folder in res folder
						//Resources res=getResources();
					  	//InputStream input=res.openResources(R.helper.helper);
						//byte[] reader=new byte[input.available()];
						//while(input.read(reader)!=-1){}
						//text.setText(new String(reader));
						
					//when reading from file creating in another activity.for eg fileOperationsWrite.java
                	    //FileInputStream input=null;
						//input=openFileInput("myFile");
						//byte[] reader=new byte[input.available()];
						//while(input.read(reader)!=-1){}
						//text.setText(new String(reader));
                	
						
						//when reading from xml file eg.helper.xml in res/xml
//						Resources res=getResources();
//						XmlPullParser parser=res.getXml(R.xml.helper);
//						StringBuilder sb=new StringBuilder(); 
//						try
//						{
//							while(parser.next()!=XmlPullParser.END_DOCUMENT)
//							{
//								String name=parser.getName();
//								String fName=null;
//								if(name!=null && name.equals("person"))
//								{
//									for(int i=0;i<parser.getAttributeCount();i++)
//									{
//										String attributeName=parser.getAttributeName(i);
//										String attributeValue=parser.getAttributeValue(i);
//										if(attributeName!=null && attributeName.equals("firstName"))
//										{
//										  fName=attributeValue;	
//										}
//										if(fName!=null){sb.append(fName+"\n");}
//										text.setText(sb.toString());
//									}
//								}
//							}
//						}
//						catch(Exception e){}
                	
                	//When reading file stored in External Storage
                	File file=new File("/sdcard/Kamlesh/myFile.txt");
                	if(file.exists() && file.canRead())
                	{
                		FileInputStream input=null;
                		try 
                		{
							input=new FileInputStream(file);
							byte[] reader=new byte[input.available()];
							while(input.read(reader)!=-1){}
							text.setText(new String(reader));
						} 
                		catch (Exception e){} 
                		finally
                		{
                			if(input!=null)
                			{
                				try {input.close();} 
                				catch (Exception e2){} 
                		    }
                		}
                     }
                	
			}});
	  }
}
