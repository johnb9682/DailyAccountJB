package app.report;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemSelectedListener;
import app.account.T_expenditure_account;
import app.account.T_income_account;
import app.process.T_expenditure_process;
import app.process.T_income_process;
import app.process.T_sum_process;
import app.report.R;
import app.report.R.id;
import app.report.R.layout;

public class monthReport extends Activity implements OnClickListener
{
	
	 private ListView listView;
	 private EditText beginningdate,endingdate;
	 private String dateMin="0",dateMax="0";
	 //private String[] name = {"John","Jason","James","Duran"};
	
	 protected void onCreate(Bundle savedInstanceState)
	 {
		 Log.i("Working", "Enter the monthReport");
	  	 super.onCreate(savedInstanceState);
	   	 setContentView(R.layout.monthreport);
	   	 
	   	 beginningdate = (EditText)this.findViewById(R.id.beginningdate);
		 endingdate = (EditText)this.findViewById(R.id.endingdate);
	   	 
		 View searchButton = this.findViewById(R.id.search);
		 searchButton.setOnClickListener(this);
			
	   	 setListView();
	 }

	private void setListView() 
	{
		// TODO Auto-generated method stub
        listView = (ListView) findViewById(R.id.listview);
        
        setAdapter();
        listView.setClickable(true);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
        	
        	public void onItemClick(AdapterView<?> parent, View view,     int position, long id) 
        	{   //这里面可以弄switch（position）或者别的
        	    //case（1）
        		Log.d("ListView", "Working"+position);
        		switch(position)
        		{
        		   case 0:
        			   startIntent_expenditure();
        			   break;
        		   case 1:
        			   startIntent_income();
        			   break;
        		   case 2:
        			   startIntent_liability();
        			   break;
        		   default:break;
        		}
        	}//就跳转到另一个页面

		

			
        });
		/*
		listView.setOnItemClickListener(new OnItemSelectedListener()
		{

			public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) 
			{
				// TODO Auto-generated method stub
				//Toast.makeText(MainActivity.this, name[arg2], Toast.LENGTH_LONG).show();
				Log.d("TextView", "Working");
			}
			
			public void onNothingSelected(AdapterView<?> arg0) 
			{
				// TODO Auto-generated method stub
				Log.d("Text View Nothing", "Nothing");
			}

			
		});	*/
	}
    private void startIntent_expenditure() 
    {
				// TODO Auto-generated method stub
	    Intent i = new Intent(this, ReportExpenditure.class);
	    i.putExtra("beginningdate", dateMin);
	    i.putExtra("endingdate", dateMax);
	    startActivity(i);
	}
	private void startIntent_liability() 
	{
		// TODO Auto-generated method stub
		Intent i = new Intent(this, ReportLiability.class);
		i.putExtra("beginningdate", dateMin);
	    i.putExtra("endingdate", dateMax);
	    startActivity(i);
	}

	private void startIntent_income() 
	{
		// TODO Auto-generated method stub
		Intent i = new Intent(this, ReportIncome.class);
		i.putExtra("beginningdate", dateMin);
	    i.putExtra("endingdate", dateMax);
	    startActivity(i);
	}
	private void setAdapter() 
	{
		// TODO Auto-generated method stub
		//String set
		
	    //String name = ;
		
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,0);
        
        setList(adapter);
        
        //adapter.addAll(name);
		
		listView.setAdapter(adapter);		
	}

	@SuppressLint("NewApi")
	private void setList( ArrayAdapter adapter) 
	{
		// TODO Auto-generated method stub
		
		//String[] name = {"John","Jason","James","Duran"};
		//String[] name = null;
		//name[0]="John";
		//name[1]="Jason";
		T_sum_process dataprocess = new T_sum_process(this.getBaseContext());
   	    long length = dataprocess.getCount();
   	    //Log.i("Database size", length+""+name[1]);
   	    //AccountEntry account;
   	    for(int i = 1; i<=(int)length;i++)
   	    {
   	    	//DataAccountProcess dataprocess1 = new DataAccountProcess(this.getBaseContext());
   	    	//name[i-1] = 
   	    	//adapter.addAll(dataprocess1.find(i).getAccount());
   	    	adapter.add(dataprocess.find(i).getName()+"   "+dataprocess.find(i).getSum());
   	    	//name[i-1] = String.valueOf(account.getAccount());
   	    }
   	    //return name;
   	    
		
		//String[] name = {"John","Jason","James","Duran"};
		//return name;
		
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.search:
			setNewList();	
			break;
		}
	}

	// rebuild the adapter
	//create a new list
	private void setNewList() 
	{
		// TODO Auto-generated method stub
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,0);		
		
        dateMin = beginningdate.getText().toString();
		dateMax = endingdate.getText().toString();
		int expenditure_result = setResult_expenditure(Integer.parseInt(dateMin),Integer.parseInt(dateMax));
		
		adapter.add("Expenditure    "+expenditure_result);
		
		int income_result = setResult_income(Integer.parseInt(dateMin),Integer.parseInt(dateMax));
		
		adapter.add("Income    "+income_result);
		
		listView.setAdapter(adapter);	
	}

	// calculate the total amount
	private int setResult_expenditure(int dateMin,int dateMax) 
	{
		 // TODO Auto-generated method stub
		  T_expenditure_process personService = new T_expenditure_process(this.getBaseContext());
	  	  Cursor result = personService.findDate(dateMin,dateMax);
	  	  int amount = 0;
	  	  
	  	  for(result.moveToFirst();!result.isAfterLast();result.moveToNext())
	      {
	      	 T_expenditure_account account = new T_expenditure_account();
	      	 //account.setId(result.getInt(result.getColumnIndex("accountId")));
	       	 amount +=result.getInt(2);
	       		 //return account;
	      }
	      Log.i("Test find amount",amount+""); 
	      return amount;  
	  	  
	}
	
	private int setResult_income(int dateMin,int dateMax) 
	{
		 // TODO Auto-generated method stub
		  T_income_process personService = new T_income_process(this.getBaseContext());
	  	  Cursor result = personService.findDate(dateMin,dateMax);
	  	  int amount = 0;
	  	  
	  	  for(result.moveToFirst();!result.isAfterLast();result.moveToNext())
	      {
	      	 T_income_account account = new T_income_account();
	      	 //account.setId(result.getInt(result.getColumnIndex("accountId")));
	       	 amount +=result.getInt(2);
	       		 //return account;
	      }
	      Log.i("Test find amount",amount+""); 
	      return amount;  
	  	  
	}
}
