package app.process;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.account.AccountStatus;
import app.dababase.DatabaseStatus;

public class DataStatusProcess 
{
	
     private DatabaseStatus database;
     private Context context;
     public DataStatusProcess(Context context)
     {
    	 this.context = context;
    	 database = new DatabaseStatus(context);
     }
     
     public void save(AccountStatus account)
     {
    	 SQLiteDatabase db = database.getWritableDatabase();
    	 //SQLiteDatabase db = database.getReadableDatabase();
    	 //db.execSQL("insert into report(account,amount) values('Amy',21)");
    	 db.execSQL("insert into report(account,amount) values(?,?)",
    		new Object[]{account.getAccount(),account.getAmount()});
     }
     
     public AccountStatus find(Integer id)
     {
    	 SQLiteDatabase db = database.getReadableDatabase();
    	 Cursor cursor = db.rawQuery("select accountId,account,amount from report where accountId=?",
    			 new String[]{String.valueOf(id)});
    	 if(cursor.moveToNext())
    	 {
    		 AccountStatus account = new AccountStatus();
    		 
    		 account.setId(cursor.getInt(cursor.getColumnIndex("accountId")));
    		 account.setAccount(cursor.getString(1));
    		 account.setAmount(cursor.getInt(2));
    		 return account;
    	 }
    	 cursor.close();
    	 return null;
     }
     
     
	public void updata(AccountStatus account) 
	{
		// TODO Auto-generated method stub
		SQLiteDatabase db = database.getWritableDatabase();
		db.execSQL("update report set account=?,amount=? where accountId=?", 
				new Object[]{account.getAccount(),account.getAmount(),account.getId()});
	}
	
	public void delete(Integer id)
	{
		SQLiteDatabase db = database.getWritableDatabase();
		db.execSQL("delete from report where accountId=?", 
				new Object[]{id});
		
	}
	
	public long getCount()
	{
		SQLiteDatabase db = database.getReadableDatabase();
		Cursor cursor = db.rawQuery("select count(*) from report", null);
		cursor.moveToFirst();
		long count = cursor.getLong(0);
		cursor.close();
		return count;
	}
}