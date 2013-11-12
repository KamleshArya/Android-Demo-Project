package com.kamlesh.androidminiproject;

import java.util.List;

import com.kamlesh.androidminiproject.DataBaseHelper.ContactHelper;
import com.kamlesh.androidminiproject.DataBaseHelper.DBHelper;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

//Helper Classes-ContactHelper.java and DBHelper.java

public class SQLiteDemo extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_contact_demo);
		
		DBHelper db=new DBHelper(this);
		Log.d("Inserting","Data");
		db.insertContact(new ContactHelper("Kamlesh Ary","9999999"));
		db.insertContact(new ContactHelper("Anh","66666666"));
		
		Log.d("Reading: ", "Reading all contacts.."); 
        List<ContactHelper> contacts = db.getAllContact();       
         
        for (ContactHelper cn : contacts) {
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
              
        Log.d("Name: ", log);}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.sqlite_diary_demo, menu);
		return true;
	}

}
