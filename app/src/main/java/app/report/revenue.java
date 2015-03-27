package app.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import app.account.AccountStatus;
import app.process.DataStatusProcess;
import app.report.*;


public class revenue extends Activity implements OnClickListener
{
	private EditText accountText,amountText;
	
	protected void onCreate(Bundle savedInstanceState)
	{
	  	 super.onCreate(savedInstanceState);
	   	 setContentView(R.layout.revenue);
	   	 
	 	View saveButton = this.findViewById(R.id.revenue_save);
		saveButton.setOnClickListener(this);
		View cancelButton = this.findViewById(R.id.revenue_cancel);
		cancelButton.setOnClickListener( this);
		
		accountText = (EditText)this.findViewById(R.id.revenue_account);
		amountText = (EditText)this.findViewById(R.id.revenue_amount);
		
		Log.i("Test Revenue", "Working");
	}
	
	public void onClick(View v)
    {
    	switch (v.getId())
    	{
    	    case R.id.revenue_save:
    	    	String name,amount;
    	    	name = accountText.getText().toString();
    	    	amount = changeSign(amountText.getText().toString());
    	    	Log.i("Revenue",amount);
    	    	saveAccount(name,amount);
    	    	Intent i = new Intent(this, showBalance.class);
    	    	i.putExtra("level", "1");
    			startActivity(i);
    	    	break;
    	    case R.id.revenue_cancel:
    	    	finish();
    	    	break;
 
    	}
    	
    }
	
	private String changeSign(String string)   
	{
		// TODO Auto-generated method stub
		int amount = Integer.parseInt(string);
		amount *= -1;
		Log.i("Test amount",""+amount);
		return String.valueOf(amount);
	}

	private void saveAccount(String name, String amount) 
	{
		// TODO Auto-generated method stub
		saveNewAccount newAccount = new saveNewAccount(this.getBaseContext());
		newAccount.saveAccount(2, name,amount);
	}
}

