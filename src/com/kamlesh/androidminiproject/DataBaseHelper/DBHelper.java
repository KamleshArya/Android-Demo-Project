package com.kamlesh.androidminiproject.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
	   //Use of constatnts for DB properties
	   private static final int DATABASE_VERSION=1;
	   private static final String DATABASE_NAME="myDatabase.db";
	   private static final String TABLE_NAME="myTable";
	   private static final String KEY="myKey";
	   private static final String NAME="myName";
	   private static final String PHONE_NUMBER="myPhoneNumber";
	   
	   
	   private static SQLiteDatabase db;
	   private static ContentValues values;
	   public DBHelper(Context context) 
	   {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
	   }
	
	   @Override
	   public void onCreate(SQLiteDatabase db) 
	   {
		   String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
	                + KEY + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
	                + PHONE_NUMBER + " TEXT" + ")";
	        db.execSQL(CREATE_TABLE);
	   }
	   
	   @Override
	   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	   {
		 db.execSQL("DROP TABLE IF EXITS " + TABLE_NAME);
	   }
	   
	   //CRUD Operations
	   //INSERT
	   public void insertContact(ContactHelper ch)
	   {
		   db=this.getWritableDatabase();
		   values=new ContentValues();
		   values.put(NAME,ch.getName());
		   values.put(PHONE_NUMBER,ch.getPhoneNumber());
		   db.insert(TABLE_NAME, null, values);
		   db.close();
	   }
	   
	   //UPDATE
	   public int updateContact(ContactHelper ch)
	   {
		   db=this.getWritableDatabase();
		   values=new ContentValues();
		   values.put(NAME,ch.getName());
		   values.put(PHONE_NUMBER, ch.getPhoneNumber());
		   return db.update(TABLE_NAME, values,KEY + " = ?",new String[]{String.valueOf(ch.getId())});
	   }
	   
	   //DELETE
	   public void deleteContact(ContactHelper ch)
	   {
		   db=this.getWritableDatabase();
		   db.delete(TABLE_NAME, KEY + " = ?",new String[]{String.valueOf(ch.getId())});
	   }

	   //READ Operations
	   //Single Data
	   ContactHelper getContact(int id)
	   {
		   db = this.getReadableDatabase();
		   Cursor cursor = db.query(TABLE_NAME, new String[] { KEY,NAME, PHONE_NUMBER }, KEY + "=?",new String[] { String.valueOf(id) }, null, null, null, null);
	       
		   if (cursor != null)cursor.moveToFirst();
	       
		   ContactHelper ch = new ContactHelper(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));
	       return ch;
	   }
	   
	   //All Data
	   public List<ContactHelper> getAllContact()
	   {
		   db = this.getWritableDatabase();
		   List<ContactHelper> contactList=new ArrayList<ContactHelper>();
		   
		   Cursor cursor = db.rawQuery(" SELECT * FROM "+TABLE_NAME, null);
	       if (cursor.moveToFirst()) 
	       {
	            do 
	            {
	                ContactHelper ch = new ContactHelper();
	                ch.setId(Integer.parseInt(cursor.getString(0)));
	                ch.setName(cursor.getString(1));
	                ch.setPhoneNumber(cursor.getString(2));
	                contactList.add(ch);
	            } 
	            while (cursor.moveToNext());
	        }
	     return contactList;
	   }
}
