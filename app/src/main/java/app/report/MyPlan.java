package app.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import app.report.R;
import app.report.R.id;
import app.report.R.layout;
import app.report.R.menu;

public class MyPlan extends Activity implements OnClickListener 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myplan);
		
		View aboutButton = this.findViewById(R.id.myplan_additem);
		aboutButton.setOnClickListener(this);
		View newAccountButton = this.findViewById(R.id.myplan_monthlyexpense);
		newAccountButton.setOnClickListener( this);
		
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
	    	case R.id.myplan_additem:
	    		Intent i = new Intent(this, ListItem.class);
    	    	startActivity(i);
		    	break;
		    case R.id.myplan_monthlyexpense:
    			break;
		    default:
    			break;
		}
	}

}