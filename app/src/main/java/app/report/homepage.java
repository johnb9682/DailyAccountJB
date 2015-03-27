package app.report;


import android.os.Build;
import android.os.Bundle;


import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.*;

import android.app.AlertDialog;
import android.content.*;
import android.util.*;

import android.media.*;


public class homepage extends Activity implements OnClickListener
{
	 protected void onCreate(Bundle savedInstanceState)
	 {
	  	 super.onCreate(savedInstanceState);
	   	 setContentView(R.layout.homepage);
	   	 
	   	View aboutButton = this.findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);
		View newAccountButton = this.findViewById(R.id.account_button);
		newAccountButton.setOnClickListener( this);
		View newgameButton = this.findViewById(R.id.exit_button);
		newgameButton.setOnClickListener(this);
		View reportButton = this.findViewById(R.id.report_botton);
		reportButton.setOnClickListener(this);
		View planButton = this.findViewById(R.id.plan_button);
		planButton.setOnClickListener(this);
	 }
     
	 public void onClick(View v)
	    {
	    	switch (v.getId())
	    	{
	    	    case R.id.about_button:
	    	    	Intent k = new Intent(this, about.class);
	    	    	startActivity(k);
	    	    	break;
	    	    case R.id.account_button:
	    	    	openNewGameDialog();
	    	    	//Intent i = new Intent(this,newAccount.class);
	    	    	//startActivity(i);
	    	    	break;
	    	    case R.id.exit_button:
	    	    	finish();
	    	    	break;
	    	    case R.id.plan_button:
	    	    	//startGame(Game.DIFFICULTY_CONTINUE);
	    	    	break;
	    	    case R.id.report_botton:
	    	    	
	    	    	Intent t = new Intent(this,monthReport.class);
	    	    	startActivity(t);
	    	    	break;
	    	}
	    	
	    }
	 
	    private void openNewGameDialog()
	    {
	    	new AlertDialog.Builder(this)
	    	.setTitle(R.string.choosecategory).setItems(R.array.difficulty,
	    	 new DialogInterface.OnClickListener()
	    	{
	    		public void onClick(DialogInterface dialoginterface, int i)
	    		{
	    			//int diff = getIntent().getIntExtra(KEY_DIFFICULTY,INCOME);
	    			startGame(i);
	    		}
	    	}).show();
	    }
	    
	    private void startGame(int i)
	    {
	    	//Log.d(TAG,"clicked on "+i);
	    	Intent intent = new Intent(homepage.this,category.class);
	    	//startActivity(i);
	    	intent.putExtra(category.KEY_DIFFICULTY, i);
	    	startActivity(intent);
	    }
}
