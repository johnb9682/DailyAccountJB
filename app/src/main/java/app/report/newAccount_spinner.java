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

public class newAccount_spinner 
{
	
	private Spinner spinner;  
	private ArrayAdapter adapter; 
	private static String selected; 
	
	public newAccount_spinner()
    {
		/*
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
				Log.v("Test", "id = " + id + "("  + spinner.getSelectedItem().toString() + ")");  
		    }  
			public void onNothingSelected(AdapterView<?> parent) 
			{  
				
			}  
		});  
*/
    }
	
	public String getSelected()
	{
		return selected; 
	}
}
