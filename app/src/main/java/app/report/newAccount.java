package app.report;


import android.os.Build;
import android.os.Bundle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

import android.app.AlertDialog;
import android.content.*;
import android.util.*;

import android.media.*;
import app.account.AccountStatus;
import app.process.DataStatusProcess;


public class newAccount extends Activity implements OnClickListener
{
	
	
	private Spinner spinner;  
	private ArrayAdapter adapter; 
	private EditText et;
	private static String selected;
	private static boolean sign = false;
	

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
    	
		setContentView(R.layout.entryaccount);
		
	 	View saveButton = this.findViewById(R.id.save_button);
		saveButton.setOnClickListener(this);
		
		setSpinner();
		
		et = (EditText)this.findViewById(R.id.amount);
		
	}
	
	private void setSpinner() 
	{
		// TODO Auto-generated method stub
        spinner = (Spinner) findViewById(R.id.category);
		
		//将可选内容与ArrayAdapter连接起来  
		adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);  
		
		//设置下拉列表的风格   
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
		
		//将adapter2 添加到spinner中  
		spinner.setAdapter(adapter);  
		  
		//添加事件Spinner事件监听    
		spinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{  
			public void onItemSelected(  AdapterView<?> parent,  View view,  int position,  long id) 
			{  
				Spinner spinner = (Spinner) parent;  
				//Log.v("Test", "id = " + id + "("  + spinner.getSelectedItem().toString() + ")");
				selected = spinner.getSelectedItem().toString();
				check(id);
			
		    }  
		
			public void onNothingSelected(AdapterView<?> parent) 
			{  
				
			}  
		});  
	}

	private void check(long id) 
	{
		// TODO Auto-generated method stub
		 
		switch((int)id)
		{
		   case 6: //debt
				Intent i = new Intent(this, debt.class);
				startActivity(i);
				break;
		   case 7: //revenue
			    Intent k = new Intent(this,revenue.class);
			    startActivity(k);
			    break;
		   case 8: //other entry
			    Intent t = new Intent(this, OtherExpense.class);
				startActivity(t);
				break;
		}
		
	}
	public void onClick(View v)
    {
    	switch (v.getId())
    	{
    	    case R.id.save_button:
    	    	String amount = et.getText().toString();
    	    	//Log.d("Amount", amount);
    	    	setNewAccount(amount);
    	    	Intent i = new Intent(this, showBalance.class);
    	    	i.putExtra("level", "0");
    			startActivity(i);
    	    	break;
    	    case R.id.cancel_botton:
    	    	finish();
    	    	break;
    	}
    	
    }

	//save in the database
	private void setNewAccount(String amount) 
	{
		// TODO Auto-generated method stub
		saveNewAccount newAccount = new saveNewAccount(this.getBaseContext());
		newAccount.saveAccount(1,selected,amount);
	}
	
}
