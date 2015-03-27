package app.dababase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseStatus extends SQLiteOpenHelper 
{
     
	private static final String NAME = "report.db";
	private static final int version = 1;
	public DatabaseStatus(Context context)
	{
		super(context,NAME,null,version);
	}
	    	
	 @Override
	 public void onCreate(SQLiteDatabase db) 
	 {
		 
		 db.execSQL("CREATE TABLE report (accountId integer primary " +
					"key autoincrement, account verchar(50), amount integer)");
	   	
	 }
	   	
	 @Override
	 public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion) 
	 {
	   	 //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	     onCreate(db);
	 }
}
