package app.report;


import android.os.Build;
import android.os.Bundle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;

import android.content.Context;
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
import app.account.T_expenditure_account;
import app.account.T_income_account;
import app.account.T_item_account;
import app.account.T_liability_account;
import app.process.T_expenditure_process;
import app.process.T_income_process;
import app.process.T_item_process;
import app.process.T_liability_process;



public class saveNewAccount 
{
    private Context context;

    
	public saveNewAccount(Context baseContext) 
	{
		// TODO Auto-generated constructor stub
		Log.i("Regret", "Working!");
		this.context = baseContext;
	}

    
    public void saveAccount(int level, String name, String amount) 
	{
		// TODO Auto-generated method stub
    	check();
    	switch(level)
    	{
         	case 1:
		        T_expenditure_process dataprocess = new T_expenditure_process(this.context);
        		//  int i = changetoint(amount);
	 	        int i = Integer.parseInt(amount);
		        int totalAmount = findTotalAmount() - i;
		        Log.d("TotalAmount", ""+totalAmount);
		        
		        //create a new account
	  	        T_expenditure_account account = new T_expenditure_account(name,Math.abs(i));//,totalAmount);
	  	        account.setTotalAmount(totalAmount);
	  	        account.setDate();
	  	        dataprocess.save(account);
	  	        
	    	    T_sumsave s = new T_sumsave(this.context);
	  	        s.save_T_expenditure(account);
	  	        break;
         	case 2:
         		//Log.d("Testing", "can continue");
         		T_income_process dataprocess2 = new T_income_process(this.context);
         		//  int i = changetoint(amount);
 	 	        int i2 = Integer.parseInt(amount);
 		        int totalAmount2 = findTotalAmount() - i2;
 		        Log.d("TotalAmount", ""+totalAmount2);
 	  	        T_income_account account2 = new T_income_account(name,Math.abs(i2));//,totalAmount);
 	  	        account2.setTotalAmount(totalAmount2);
 	  	        account2.setDate();
 	  	        dataprocess2.save(account2);
 	    	    T_sumsave s2 = new T_sumsave(this.context);
 	  	        s2.save_T_income(account2);
 	  	        break;
         	case 3:
         		//Log.d("Testing", "can continue");
         		T_liability_process dataprocess3 = new T_liability_process(this.context);
         		//  int i = changetoint(amount);
 	 	        int i3 = Integer.parseInt(amount);
 	  	        T_liability_account account3 = new T_liability_account(name,Math.abs(i3));//,totalAmount);
 	  	        account3.setDueTime(7);
 	  	        account3.setDate();
 	  	        dataprocess3.save(account3);
 	  	        
 	    	    T_sumsave s3 = new T_sumsave(this.context);
 	  	        s3.save_T_liability(account3);
 	  	        
         	case 4:
         		T_item_process dataprocess4 = new T_item_process(this.context);
        		//  int i = changetoint(amount);
	 	        int i4 = Integer.parseInt(amount);
		         
		        
		        //create a new account
	  	        T_item_account account4 = new T_item_account(name,Math.abs(i4));//,totalAmount);
	  	       // account.setTotalAmount(totalAmount);
	  	        //account4.setDate();
	  	        dataprocess4.save(account4);
	  	    default:
	  	    	break;
         }
	    
	  	 
	}


	private void check() 
	{
		// TODO Auto-generated method stub
		T_expenditure_process dataprocess = new T_expenditure_process(context);
		T_expenditure_account account = new T_expenditure_account("Start",0);
		if(dataprocess.getCount() == 0)
		{
		    dataprocess.save(account);
		}
		T_income_process dataprocess1 = new T_income_process(context);
		T_income_account account1 = new T_income_account("Start",0);
		if(dataprocess1.getCount() == 0)
		{
			dataprocess1.save(account1);
		}
		T_liability_process dataprocess2 = new T_liability_process(context);
		T_liability_account account2 = new T_liability_account("Start",0);
		if(dataprocess2.getCount() == 0)
		{
		    dataprocess2.save(account2);
		}
	}


	//function: change the string to int
    private int changetoint(String amount)
	{
		int result=0;
		for(int i=0;i<amount.length();i++)
			//get the number one digit by another
		{
			result = (amount.charAt(i) - '0')+result*10;
		}
		return result;
	}
    
    private int findTotalAmount() 
	{
		// TODO Auto-generated method stub
		T_expenditure_process dataprocess = new T_expenditure_process(context);
		long length = dataprocess.getCount();
		Log.i("test size",""+length);
		if(length != 0)
		{
	  	    T_expenditure_account account = dataprocess.find((int)length);
	  	    return account.getTotalAmount();
		}
		else
		{
			
			return 0;
		}
	  	//  Log.i(TAG, account.toString());
	}
}
