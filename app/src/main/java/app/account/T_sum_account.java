package app.account;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.util.Log;

public class T_sum_account
{
	
	private Integer id;
	private String name;
	private Integer sum;
	private Integer amount;
	    
	public  T_sum_account()
	{

	}
	    	
	public  T_sum_account(String name, int sum, int amount)//, int totalAmount) 
	{
	    // TODO Auto-generated constructor stub
	   	this.name = name;
	   	this.sum = sum;
	   	this.amount = amount;
	}

	public Integer getId()
	{
		return id;
	}
	   
	public void setId(Integer id)
	{
	   	this.id = id;
	}
	    
	public Integer getSum()
	{
		return sum;
	}
	   
	public void setSum(Integer sum)
	{
	   	this.sum = sum;
	}
	
	public String getName()
	{
	   	return name;
	}
	    
	public void setName(String name)
	{
	   	this.name = name;
	}
	    
	public Integer getAmount()
	{
	   	return amount;
	}
	    
    public void setAmount(Integer amount)
	{
	   	this.amount = amount;
	}
	    
	public String toString()
	{
	   	return "account [Id="+id+", Name= "+name+"sum= "+sum+", amount="+amount+"]";
	}
		 
}

