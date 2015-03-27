package app.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import app.account.AccountStatus;
import app.process.DataStatusProcess;
import app.report.*;

public class debt extends Activity implements OnClickListener
{
	
	 private EditText creditor,debtAmount;
	
	 protected void onCreate(Bundle savedInstanceState)
	 {
	  	 super.onCreate(savedInstanceState);
	   	 setContentView(R.layout.debt);
	   	 
	   	View saveButton = this.findViewById(R.id.debt_save);
		saveButton.setOnClickListener(this);
		View cancelButton = this.findViewById(R.id.debt_cancel);
		cancelButton.setOnClickListener( this);
		
		creditor = (EditText)this.findViewById(R.id.creditorName);
		debtAmount = (EditText)this.findViewById(R.id.debtAmount);
	 }
	 
	 public void onClick(View v)
	    {
	    	switch (v.getId())
	    	{
	    	    case R.id.debt_save:
	    	    	String name,amount;
	    	    	name = creditor.getText().toString();
	    	    	amount = debtAmount.getText().toString();
	    	    	saveAccount(name,amount);
	    	    	Intent i = new Intent(this, showBalance.class);
	    	    	i.putExtra("level", "2");
	    			startActivity(i);
	    	    	break;
	    	    case R.id.debt_cancel:
	    	    	finish();
	    	    	break;
	 
	    	}
	    	
	    }

	private void saveAccount(String name, String amount) 
	{
		// TODO Auto-generated method stub
		saveNewAccount newAccount = new saveNewAccount(this.getBaseContext());
		newAccount.saveAccount(3,name,amount);
	}
	
}
