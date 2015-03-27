package app.process;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.account.T_item_account;
import app.dababase.T_item_helper;

	public class T_item_process  
	{
		private T_item_helper database;
	    private Context context;
	    public T_item_process(Context context)
	    {
	   	    this.context = context;
	   	    database = new T_item_helper(context);
	    }
	    
	    public void save(T_item_account account)
	    {
	   	     SQLiteDatabase db = database.getWritableDatabase();
	     	 //SQLiteDatabase db = database.getReadableDatabase();
	    	 //db.execSQL("insert into generalEntry(account,amount,totalAmount,date_year,date_month,date_day) " +
	    	 	//	"values('Amy',21,200,1993,4,21)");
	   	     db.execSQL("insert into generalEntry(name,status) values(?,?)",
	   		   new Object[]{account.getName(),account.getStatus()});
	    }
	    
	    public T_item_account find(Integer id)
	    {
	   	 SQLiteDatabase db = database.getReadableDatabase();
	   	 //Cursor cursor = db.rawQuery("select Id,name,sum,amount from report where Id=?",
	     Cursor cursor = db.rawQuery("select accountId,name,status from generalEntry where accountId=?",
	   			 new String[]{String.valueOf(id)});
	   	 if(cursor.moveToNext())
	   	 {
	   	     T_item_account account = new T_item_account();
	   
	   		 account.setId(cursor.getInt(cursor.getColumnIndex("accountId")));
	   		 account.setName(cursor.getString(1));
	   		 account.setStatus(1);
	   		 //account.setAmount(cursor.getInt(3));
	   		 return account;
	   	 }
	   	 cursor.close();
	   	 
	   	 
	   	 return null;
	    }
	    
	    
		public void updata(T_item_account account) 
		{
			// TODO Auto-generated method stub
			SQLiteDatabase db = database.getWritableDatabase();
			db.execSQL("update generalEntry set name=?,status=? where accountId=?", 
					new Object[]{account.getName(),account.getStatus(),account.getId()});
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

