package app.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import app.process.T_item_process;
import app.report.R;
import app.report.R.id;
import app.report.R.layout;
import app.report.R.menu;

public class ListItem extends Activity 
{

	private ListView listView;
	//private EditText item,amountText;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listitem);
		
		Log.i("List Plan", "continue");
		/*
		item = (EditText)this.findViewById(R.id.revenue_account);
		amountText = (EditText)this.findViewById(R.id.revenue_amount);
		
		View aboutButton = this.findViewById(R.id.addnewitem_save);
		aboutButton.setOnClickListener(this);
		View newAccountButton = this.findViewById(R.id.addnewitem_cancel);
		newAccountButton.setOnClickListener( this);
		*/
		setListView();
	}
	
	private void setListView() 
	{
		// TODO Auto-generated method stub
        listView = (ListView) findViewById(R.id.additem_listview);
        
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
        			   //Intent k = new Intent(this, AddItem.class);
        			   addItem();
        			   
        			   //addItem();
        			   break;
        		   
        		   default:
        			   Purchase(position);
        			   break;
        		}
        	}//就跳转到另一个页面

			

			

		

			
        });
	}
	
	private void Purchase(int position) 
	{
		// TODO Auto-generated method stub
	    Intent i = new Intent(this, OtherExpense.class);
	    i.putExtra("ID", position+"");
	    startActivity(i);
	}
	
	private void addItem() 
	{
		// TODO Auto-generated method stub
		Intent k = new Intent(this, AddItem.class);
	    startActivity(k);	
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

	private void setList( ArrayAdapter adapter) 
	{
		// TODO Auto-generated method stub
		
	
		T_item_process dataprocess = new T_item_process(this.getBaseContext());
   	    long length = dataprocess.getCount();
   	    //Log.i("Database size", length+""+name[1]);
   	    //AccountEntry account;
   	    adapter.add("Add New Item");
   	    for(int i = 1; i<=(int)length;i++)
   	    {

            // set the condition
   	    	adapter.add(dataprocess.find(i).getName()+"   "+dataprocess.find(i).getStatus());
 
   	    }
   	
   	    
		
		//String[] name = {"John","Jason","James","Duran"};
		//return name;
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*
	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
	    	case R.id.addnewitem_save:
	    		
	    		String name;
    	    	name = accountText.getText().toString();
    	    	//amount = amountText.getText().toString();
    	    	//Log.i("Revenue",amount);
    	    	 
    	    	 Log.i("item saving", "done");
    	    	saveAccount(name,""+1);
    	    	/*
    	    	Intent i = new Intent(this, showBalance.class);
    	    	i.putExtra("level", "1");
    			startActivity(i);
    			*/
	/*
		    	break;
		    case R.id.addnewitem_cancel:
		    	finish();
    			break;
		    default:
    			break;
		}
	}
	private void saveAccount(String name, String amount) 
	{
		// TODO Auto-generated method stub
		saveNewAccount newAccount = new saveNewAccount(this.getBaseContext());
		newAccount.saveAccount(4, name,amount);
	}
*/
}