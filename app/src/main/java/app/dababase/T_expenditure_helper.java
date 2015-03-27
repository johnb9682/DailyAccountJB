package app.dababase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class T_expenditure_helper extends SQLiteOpenHelper 
{
     
	private static final String NAME = "gerneralEntry.db";
	private static final int version = 1;
	public T_expenditure_helper(Context context)
	{
		super(context,NAME,null,version);
	}
	    	
	 @Override
	 public void onCreate(SQLiteDatabase db) 
	 {
		 
		 db.execSQL("CREATE TABLE generalEntry (accountId integer primary " +
		 		"key autoincrement, account verchar(50), amount integer, totalAmount integer," +
		 		" date_year integer, date_month integer, date_day integer)");
	   	
	 }
	   	
	 @Override
	 public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion) 
	 {
	   	 //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	     onCreate(db);
	 }
}

