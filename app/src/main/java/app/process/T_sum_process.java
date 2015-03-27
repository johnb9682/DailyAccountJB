    package app.process;

	import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.account.T_sum_account;
import app.dababase.T_sum_helper;

	public class T_sum_process  
	{
		private T_sum_helper database;
	    private Context context;
	    public T_sum_process(Context context)
	    {
	   	    this.context = context;
	   	    database = new T_sum_helper(context);
	    }
	    
	    public void save(T_sum_account account)
	    {
	   	     SQLiteDatabase db = database.getWritableDatabase();
	     	 //SQLiteDatabase db = database.getReadableDatabase();
	    	 //db.execSQL("insert into generalEntry(account,amount,totalAmount,date_year,date_month,date_day) " +
	    	 	//	"values('Amy',21,200,1993,4,21)");
	   	     db.execSQL("insert into generalEntry(name,sum,amount) values(?,?,?)",
	   		   new Object[]{account.getName(),account.getSum(),account.getAmount()});
	    }
	    
	    public T_sum_account find(Integer id)
	    {
	   	 SQLiteDatabase db = database.getReadableDatabase();
	   	 //Cursor cursor = db.rawQuery("select Id,name,sum,amount from report where Id=?",
	     Cursor cursor = db.rawQuery("select Id,name,sum,amount from generalEntry where Id=?",
	   			 new String[]{String.valueOf(id)});
	   	 if(cursor.moveToNext())
	   	 {
	   	     T_sum_account account = new T_sum_account();
	   		 
	   		 account.setId(cursor.getInt(cursor.getColumnIndex("Id")));
	   		 account.setName(cursor.getString(1));
	   		 account.setSum(cursor.getInt(2));
	   		 account.setAmount(cursor.getInt(3));
	   		 return account;
	   	 }
	   	 cursor.close();
	   	 return null;
	    }
	    
	    
		public void updata(T_sum_account account) 
		{
			// TODO Auto-generated method stub
			SQLiteDatabase db = database.getWritableDatabase();
			db.execSQL("update generalEntry set name=?,sum=?,amount=? where Id=?", 
					new Object[]{account.getName(),account.getSum(),account.getAmount(),account.getId()});
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

