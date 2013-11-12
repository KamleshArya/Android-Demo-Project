package com.kamlesh.androidminiproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

//Display Menu Item
//Currently both menu are set to single activity-> MenuClassSetting
public class MenuDemo1 extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_demo1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		super.onCreateOptionsMenu(menu);
		
//      Adding Menu Programmatically
//		MenuItem menuItem1=menu.add("Setting");
//		menuItem1.setIcon(R.drawable.ic_launcher);
//	    menuItem1.setIntent(new Intent(this,MenuClassSetting.class));
//		
//		MenuItem menuItem2=menu.add("Help");
//		menuItem2.setIcon(R.drawable.ic_launcher);
//		menuItem2.setIntent(new Intent(this,MenuClassSetting.class));
		
		
		//Adding Menu using XML generated -> res/menu/menu_demo.xml
		MenuInflater menuInflater=getMenuInflater();
		menuInflater.inflate(R.menu.menu_demo, menu);
	
		return true;
	}
	
   //On Option menu event triggering
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		//For Programmatically
		//this.startActivity(item.getIntent());
	    
		//For XML generated
		switch(item.getItemId())
		{
		    case R.id.name:
		    this.startActivity(new Intent(this,MenuClassSetting.class));	
			break;
			
		    case R.id.email:
		    this.startActivity(new Intent(this,MenuClassSetting.class));
		    break;
		    
		    default:
			super.onOptionsItemSelected(item);
		}
		
		return true;
	}
}
