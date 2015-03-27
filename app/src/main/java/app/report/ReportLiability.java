package app.report;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemSelectedListener;
import app.process.T_liability_process;
import app.report.R;
import app.report.R.id;
import app.report.R.layout;

public class ReportLiability extends Activity
{
	
	 private ListView listView;
	 //private String[] name = {"John","Jason","James","Duran"};
	
	 protected void onCreate(Bundle savedInstanceState)
	 {
		 Log.i("Working", "Enter the monthReport");
	  	 super.onCreate(savedInstanceState);
	   	 setContentView(R.layout.monthreport);
	   	 
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
       
        	}//就跳转到另一个页面

		

			
        });

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
		T_liability_process dataprocess = new T_liability_process(this.getBaseContext());
   	    long length = dataprocess.getCount();
   	    //Log.i("Database size", length+""+name[1]);
   	    //AccountEntry account;
   	    for(int i = 1; i<=(int)length;i++)
   	    {
   	    	//DataAccountProcess dataprocess1 = new DataAccountProcess(this.getBaseContext());
   	    	//name[i-1] = 
   	    	//adapter.addAll(dataprocess1.find(i).getAccount());
   	    	adapter.add(dataprocess.find(i).getName()+"   "+dataprocess.find(i).getAmount());
   	    	adapter.add("DueTime:  "+dataprocess.find(i).getDueTime());
   	    	//name[i-1] = String.valueOf(account.getAccount());
   	    }
   	    //return name;
   	    
		
		//String[] name = {"John","Jason","James","Duran"};
		//return name;
		
	}
}