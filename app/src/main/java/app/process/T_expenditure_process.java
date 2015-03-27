package app.process;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.account.T_expenditure_account;
import app.dababase.T_expenditure_helper;

public class T_expenditure_process 
{
	private static T_expenditure_helper database;
    private Context context;
    public T_expenditure_process(Context context)
    {
   	    this.context = context;
   	    database = new T_expenditure_helper(context);
    }
    
    public void save(T_expenditure_account account)
    {
   	     SQLiteDatabase db = database.getWritableDatabase();
     	 //SQLiteDatabase db = database.getReadableDatabase();
    	 //db.execSQL("insert into generalEntry(account,amount,totalAmount,date_year,date_month,date_day) " +
    	 	//	"values('Amy',21,200,1993,4,21)");
   	     db.execSQL("insert into generalEntry(account,amount,totalAmount,date_year,date_month,date_day) values(?,?,?,?,?,?)",
   		   new Object[]{account.getAccount(),account.getAmount(),account.getTotalAmount(),//1993,4,21});
   	    		 account.getDate_year(),account.getDate_month(),account.getDate_day()});
    }
    
    public T_expenditure_account find(Integer id)
    {
   	 SQLiteDatabase db = database.getReadableDatabase();
   	 //Cursor cursor = db.rawQuery("select accountId,account,amount,totalAmount,date from report where accountId=?",
   	Cursor cursor = db.rawQuery("select accountId,account,amount,totalAmount,date_year,date_month,date_day from generalEntry where accountId=?",
   			 new String[]{String.valueOf(id)});
   	 if(cursor.moveToNext())
   	 {
   	     T_expenditure_account account = new T_expenditure_account();
   		 
   		 account.setId(cursor.getInt(cursor.getColumnIndex("accountId")));
   		 account.setAccount(cursor.getString(1));
   		 account.setAmount(cursor.getInt(2));
   		 account.setTotalAmount(cursor.getInt(3));
   		 account.setDate_year(cursor.getInt(4));
    	 account.setDate_month(cursor.getInt(5));
    	 account.setDate_day(cursor.getInt(6));
   		 return account;
   	 }
   	 cursor.close();
   	 return null;
    }
    
    public static Cursor findDate(Integer dayMin,Integer dayMax)
    {
    	SQLiteDatabase db = database.getReadableDatabase();
      	 //Cursor cursor = db.rawQuery("select accountId,account,amount,totalAmount,date from report where accountId=?",
      	Cursor result = db.rawQuery("select accountId,account,amount,totalAmount,date_year,date_month,date_day " +
      			"from generalEntry where (date_year || date_month || date_day)>=? and (date_year || date_month || date_day)<=?",
      			 new String[]{String.valueOf(dayMin),String.valueOf(dayMax)});
      	return result;
      	/*
      	for(result.moveToFirst();!result.isAfterLast();result.moveToNext())
      	{
      		 T_expenditure_account account = new T_expenditure_account();
      		 account.setId(result.getInt(result.getColumnIndex("accountId")));
       		 account.setAccount(result.getString(1));
       		 account.setAmount(result.getInt(2));
       		 account.setTotalAmount(result.getInt(3));
       		 account.setDate_year(result.getInt(4));
        	 account.setDate_month(result.getInt(5));
        	 account.setDate_day(result.getInt(6));
       		 //return account;
      	}
    	return null;
    	*/
    }
    
	public void updata(T_expenditure_account account) 
	{
		// TODO Auto-generated method stub
		SQLiteDatabase db = database.getWritableDatabase();
		db.execSQL("update generalEntry set account=?,amount=? where accountId=?", 
				new Object[]{account.getAccount(),account.getAmount(),account.getId()});
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
