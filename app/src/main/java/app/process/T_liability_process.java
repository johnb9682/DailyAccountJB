package app.process;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.account.T_liability_account;
import app.dababase.T_liability_helper;


public class T_liability_process 
{
	private T_liability_helper database;
    private Context context;
    public T_liability_process(Context context)
    {
   	    this.context = context;
   	    database = new T_liability_helper(context);
    }
    
    public void save(T_liability_account account)
    {
   	     SQLiteDatabase db = database.getWritableDatabase();
     	 //SQLiteDatabase db = database.getReadableDatabase();
    	 //db.execSQL("insert into generalEntry(account,amount,totalAmount,date_year,date_month,date_day) " +
    	 	//	"values('Amy',21,200,1993,4,21)");
   	     db.execSQL("insert into generalEntry(name,amount,duetime,date_year,date_month,date_day) values(?,?,?,?,?,?)",
   		   new Object[]{account.getName(),account.getAmount(),account.getDueTime(),//1993,4,21});
   	    		 account.getDate_year(),account.getDate_month(),account.getDate_day()});
    }
    
    public T_liability_account find(Integer id)
    {
   	 SQLiteDatabase db = database.getReadableDatabase();
   	 //Cursor cursor = db.rawQuery("select accountId,account,amount,totalAmount,date from report where accountId=?",
   	Cursor cursor = db.rawQuery("select Id,name,amount,duetime,date_year,date_month,date_day from generalEntry where Id=?",
   			 new String[]{String.valueOf(id)});
   	 if(cursor.moveToNext())
   	 {
   	     T_liability_account account = new T_liability_account();
   		 
   		 account.setId(cursor.getInt(cursor.getColumnIndex("Id")));
   		 account.setName(cursor.getString(1));
   		 account.setAmount(cursor.getInt(2));
   		 account.setDueTime(cursor.getInt(3));
   		 account.setDate_year(cursor.getInt(4));
    	 account.setDate_month(cursor.getInt(5));
    	 account.setDate_day(cursor.getInt(6));
   		 return account;
   	 }
   	 cursor.close();
   	 return null;
    }
    
    
	public void updata(T_liability_account account) 
	{
		// TODO Auto-generated method stub
		SQLiteDatabase db = database.getWritableDatabase();
		db.execSQL("update generalEntry set account=?,amount=? where accountId=?", 
				new Object[]{account.getName(),account.getAmount(),account.getId()});
	}
	
	public void delete(Integer id)
	{
		SQLiteDatabase db = database.getWritableDatabase();
		db.execSQL("delete from generalEntry where accountId=?", 
				new Object[]{id});
		
	}
	
	public long getCount()
	{
		SQLiteDatabase db = database.getReadableDatabase();
		Cursor cursor = db.rawQuery("select count(*) from generalEntry", null);
		cursor.moveToFirst();
		long count = cursor.getLong(0);
		cursor.close();
		return count;
	}
}