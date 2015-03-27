package app.report;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemSelectedListener;
import app.account.T_income_account;
import app.process.T_income_process;
import app.report.R;
import app.report.R.id;
import app.report.R.layout;

public class ReportIncome extends Activity
{
	
	 private ListView listView;
	 //private String[] name = {"John","Jason","James","Duran"};
	
	 protected void onCreate(Bundle savedInstanceState)
	 {
		 Log.i("Working", "Enter the monthReport");
	  	 super.onCreate(savedInstanceState);
	   	 setContentView(R.layout.monthreport);
	   	 
	   	 Intent i = getIntent();
	   	 String dateMin = i.getStringExtra("beginningdate");
	   	 String dateMax = i.getStringExtra("endingdate");
	   	 
	   	 setListView(dateMin,dateMax);
	 }

	private void setListView(String dateMin, String dateMax) 
	{
		// TODO Auto-generated method stub
        listView = (ListView) findViewById(R.id.listview);
        
        setAdapter(dateMin,dateMax);
        listView.setClickable(true);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
        	
        	public void onItemClick(AdapterView<?> parent, View view,     int position, long id) 
        	{   //这里面可以弄switch（position）或者别的
        	    //case（1）
        		Log.d("ListView", "Working"+position);
       
        	}//就跳转到另一个页面

		

			
        });

	}

	private void setAdapter(String dateMin, String dateMax) 
	{
		// TODO Auto-generated method stub
		//String set
		
	    //String name = ;
		
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,0);
        
        setList(adapter,Integer.parseInt(dateMin),Integer.parseInt(dateMax));
        
        //adapter.addAll(name);
		
		listView.setAdapter(adapter);		
	}

	@SuppressLint("NewApi")
	private void setList( ArrayAdapter adapter,int dateMin, int dateMax) 
	{
		// TODO Auto-generated method stub
		
		//String[] name = {"John","Jason","James","Duran"};
		//String[] name = null;
		//name[0]="John";
		//name[1]="Jason";
		
		if(dateMin == 0)
		{
		    T_income_process dataprocess = new T_income_process(this.getBaseContext());
   	        long length = dataprocess.getCount();
     	    //Log.i("Database size", length+""+name[1]);
     	    //AccountEntry account;
   	        for(int i = 1; i<=(int)length;i++)
   	        {
     	    	// DataAccountProcess dataprocess1 = new DataAccountProcess(this.getBaseContext());
     	    	// name[i-1] = 
     	    	//adapter.addAll(dataprocess1.find(i).getAccount());
   	    	    adapter.add(dataprocess.find(i).getAccount()+"   "+dataprocess.find(i).getAmount());
     	    	//name[i-1] = String.valueOf(account.getAccount());
   	        }
		}
		else
		{
			  T_income_process dataprocess = new T_income_process(this.getBaseContext());
			  Cursor result = T_income_process.findDate(dateMin,dateMax);
		  	  int amount = 0;
		  	  
		  	  for(result.moveToFirst();!result.isAfterLast();result.moveToNext())
	      	  {
	      		 T_income_account account = new T_income_account();
	      		 //account.setId(result.getInt(result.getColumnIndex("accountId")));
	       		 account.setAccount(result.getString(1));
	       		 account.setAmount(result.getInt(2));
	       		 account.setTotalAmount(result.getInt(3));
	       		 account.setDate_year(result.getInt(4));
	        	 account.setDate_month(result.getInt(5));
	        	 account.setDate_day(result.getInt(6));
	        	 adapter.add(account.getAccount()+"   "+account.getAmount());
	       		 //return account;
	      	  }
		}
   	    //return name;
   	    
		
		//String[] name = {"John","Jason","James","Duran"};
		//return name;
		
	}
}