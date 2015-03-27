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


public class AddItem extends Activity implements OnClickListener
{
	private EditText accountText,amountText;
	
	protected void onCreate(Bundle savedInstanceState)
	{
	  	 super.onCreate(savedInstanceState);
	   	 setContentView(R.layout.addnewitem);
	   	 
	 	View saveButton = this.findViewById(R.id.addnewitem_save);
		saveButton.setOnClickListener(this);
		View cancelButton = this.findViewById(R.id.addnewitem_cancel);
		cancelButton.setOnClickListener( this);
		
		accountText = (EditText)this.findViewById(R.id.addnewitem_name);
		amountText = (EditText)this.findViewById(R.id.addnewitem_amount);
		
		Log.i("Test Revenue", "Working");
	}
	
	public void onClick(View v)
    {
    	switch (v.getId())
    	{
    	    case R.id.addnewitem_save:
    	    	String name,amount;
    	    	name = accountText.getText().toString();
    	    	//amount = changeSign(amountText.getText().toString());
    	    	Log.i("Add Item","continue");
    	    	saveAccount(name,1+"");
    	    	Intent i = new Intent(this, ListItem.class);
    			startActivity(i);
    	    	break;
    	    case R.id.addnewitem_cancel:
    	    	finish();
    	    	break;
 
    	}
    	
    }
	
	private void saveAccount(String name, String amount) 
	{
		// TODO Auto-generated method stub
		saveNewAccount newAccount = new saveNewAccount(this.getBaseContext());
		newAccount.saveAccount(4, name,amount);
	}
}
