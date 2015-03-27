package app.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText; 
import app.account.T_expenditure_account;
import app.account.T_income_account;
import app.account.T_liability_account;
import app.process.T_expenditure_process;
import app.process.T_income_process;
import app.process.T_liability_process;
import app.report.R;
import app.report.R.layout;

public class showBalance extends Activity
{
	private int level;
	private EditText accountName,accountAmount,balance;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showbalance);
		Intent intent = getIntent();
		level = Integer.parseInt(intent.getStringExtra("level"));
		Log.i("ShowBalance level", ""+level);
		switch(level)
		{
		    case 0:
		    	show_expenditure();
		    	break;
		    case 1:
		    	show_income();
		    	break;
		    case 2:
		    	show_liability();
		    	break;
		    default:
		        break;
		}

	}
    
	private void show_liability() 
	{
		// TODO Auto-generated method stub
		accountName = (EditText)this.findViewById(R.id.accountName);
		accountAmount = (EditText)this.findViewById(R.id.AccountAmount);
		balance = (EditText)this.findViewById(R.id.balanceAmount);
		T_liability_account account = findAccount_liability();
		accountName.setText(account.getDate_year()+"/"+account.getDate_month()+"/"+account.getDate_day());
		accountAmount.setText(account.getName()+" : "+account.getAmount());
		String stringBalance = account.getDueTime().toString();
		//balance.setText("Due Day:  "+stringBalance);
	}

	private void show_income() 
	{
		// TODO Auto-generated method stub
		accountName = (EditText)this.findViewById(R.id.accountName);
		accountAmount = (EditText)this.findViewById(R.id.AccountAmount);
		balance = (EditText)this.findViewById(R.id.balanceAmount);
		T_income_account account = findAccount_income();//find the last account in the database 
		accountName.setText(account.getDate_year()+"/"+account.getDate_month()+"/"+account.getDate_day());
		accountAmount.setText(account.getAccount()+" : "+account.getAmount());
		String stringBalance = account.getTotalAmount().toString();
		//balance.setText("Balance:  "+stringBalance);
	}

	private void show_expenditure() 
	{
		// TODO Auto-generated method stub
		accountName = (EditText)this.findViewById(R.id.accountName);
		accountAmount = (EditText)this.findViewById(R.id.AccountAmount);
		balance = (EditText)this.findViewById(R.id.balanceAmount);
		T_expenditure_account account = findAccount_expenditure();
		accountName.setText(account.getDate_year()+"/"+account.getDate_month()+"/"+account.getDate_day());
		accountAmount.setText(account.getAccount()+" : "+account.getAmount());
		String stringBalance = account.getTotalAmount().toString();
		//balance.setText("Balance:  "+stringBalance);

	}

	private T_expenditure_account findAccount_expenditure() 
	{
		// TODO Auto-generated method stub
		T_expenditure_process dataprocess = new T_expenditure_process(this.getBaseContext());
		long length = dataprocess.getCount();
	  	T_expenditure_account account = dataprocess.find((int)length);
	  	return account;
	  	//  Log.i(TAG, account.toString());
	}
	
	private T_income_account findAccount_income() 
	{
		// TODO Auto-generated method stub
		T_income_process dataprocess = new T_income_process(this.getBaseContext());
		long length = dataprocess.getCount();
	  	T_income_account account = dataprocess.find((int)length);
	  	return account;
	  	//  Log.i(TAG, account.toString());
	}
	
	private T_liability_account findAccount_liability() 
	{
		// TODO Auto-generated method stub
		T_liability_process dataprocess = new T_liability_process(this.getBaseContext());
		long length = dataprocess.getCount();
	  	T_liability_account account = dataprocess.find((int)length);
	  	return account;
	  	//  Log.i(TAG, account.toString());
	}
}
