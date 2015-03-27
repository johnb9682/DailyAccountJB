package app.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import app.account.AccountStatus;
import app.account.T_expenditure_account;
import app.account.T_item_account;
import app.account.T_liability_account;
import app.process.DataStatusProcess;
import app.process.T_expenditure_process;
import app.process.T_item_process;
import app.report.*;


public class OtherExpense extends Activity implements OnClickListener
{
	private EditText accountText,amountText;
	private int id=0;
	
	protected void onCreate(Bundle savedInstanceState)
	{
	  	 super.onCreate(savedInstanceState);
	   	 setContentView(R.layout.otherentry);
	   	 
	   	 Log.i("OtherExpense", "continue");
	   	 
	   	 Intent i = getIntent();
	   	 id = Integer.parseInt(i.getStringExtra("ID"));
	   	 
         View saveButton = this.findViewById(R.id.otherEntry_account);
		 saveButton.setOnClickListener(this);
		 View cancelButton = this.findViewById(R.id.otherEntry_amount);
		 cancelButton.setOnClickListener( this);
		
		 accountText = (EditText)this.findViewById(R.id.otherEntry_account);
		 amountText = (EditText)this.findViewById(R.id.otherEntry_amount);
		 
		 check();
	}
	
	private void check() 
	{
		// TODO Auto-generated method stub
		if(id!=0)
		{
			T_item_process dataprocess = new T_item_process(this.getBaseContext());
		  	T_item_account account = dataprocess.find(id);
			accountText.setText(account.getName());
			
		}
	}

	public void onClick(View v)
    {
    	switch (v.getId())
    	{
    	    case R.id.otherentry_save:
    	    	String name,amount;
    	    	name = accountText.getText().toString();
    	    	amount = amountText.getText().toString();
    	    	saveAccount(name,amount);
    	    	Intent i = new Intent(this, showBalance.class);
    	    	i.putExtra("level", "0");
    			startActivity(i);
    	    	break;
    	    case R.id.otherentry_cancel:
    	    	finish();
    	    	break;
 
    	}
    	
    }
	
	private void saveAccount(String name, String amount) 
	{
		// TODO Auto-generated method stub
		saveNewAccount newAccount = new saveNewAccount(this.getBaseContext());
		newAccount.saveAccount(1,name,amount);
	}
}
