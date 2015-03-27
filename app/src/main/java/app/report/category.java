package app.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class category extends Activity 
{

	
	public static final String KEY_DIFFICULTY = "difficulty";
	public static final int EXPENSE=0;
    public static final int INCOME=1;
    public static final int DEBT=2;
	public static final int OTHERS = 3;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		int diff = getIntent().getIntExtra(KEY_DIFFICULTY,INCOME);
    	Log.d("difficulty", ""+diff);
    	
    	pickCategory(diff);
    	finish();
		
	}

	private void pickCategory(int diff) 
	{
		// TODO Auto-generated method stub
        switch(diff)
        {
        case EXPENSE:
        	Intent intent = new Intent(this,newAccount.class);
	    	//startActivity(i);
	    	startActivity(intent);
        	break;
        
	    case INCOME: //revenue
		    Intent k = new Intent(this,revenue.class);
		    startActivity(k);
		    break;
	    case DEBT:
        	Intent i = new Intent(this, debt.class);
			startActivity(i);
	  		break;
	    case OTHERS: //other entry
		    Intent t = new Intent(this, OtherExpense.class);
		    t.putExtra("ID", 0);
			startActivity(t);
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}