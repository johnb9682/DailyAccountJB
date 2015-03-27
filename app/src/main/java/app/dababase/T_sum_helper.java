package app.dababase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class T_sum_helper extends SQLiteOpenHelper 
{
	     
	private static final String NAME = "T_sum.db";
	private static final int version = 1;
	public T_sum_helper(Context context)
	{
		super(context,NAME,null,version);
	}
		    	
    @Override
    public void onCreate(SQLiteDatabase db) 
    {
			 
		 db.execSQL("CREATE TABLE generalEntry (Id integer primary " +
			 		"key autoincrement, name verchar(50), sum integer, amount integer)");
		   	
	}
		   	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion) 
	{
	  	 //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	     onCreate(db);
	}
}



