package app.report;

import android.content.Context;
import android.util.Log;
import app.account.T_expenditure_account;
import app.account.T_income_account;
import app.account.T_liability_account;
import app.account.T_sum_account;
import app.process.T_sum_process;

public class T_sumsave 
{
     private Context context;
     public T_sumsave(Context context) 
     {
		// TODO Auto-generated constructor stub
    	 this.context = context;
	 }

	 public void save_T_expenditure(T_expenditure_account account)
     {
		 
		 T_sum_process dataprocess = new T_sum_process(context);
		 if(dataprocess.find(1)==null)
		 {
		     T_sum_account a = new T_sum_account("Expenditure",account.getAmount(),1);
		     dataprocess.save(a);
		 }
		 else
		 {
			 T_sum_account a = dataprocess.find(1);
			 a.setName("Expenditure");
		   	 a.setSum(a.getSum()+account.getAmount());
		   	 a.setAmount(a.getAmount()+1);
		   	 dataprocess.updata(a);
		 }
     }

	public void save_T_income(T_income_account account2) 
	{
		// TODO Auto-generated method stub
		 T_sum_process dataprocess = new T_sum_process(context);
		 if(dataprocess.find(2)==null)
		 {
		     T_sum_account a = new T_sum_account("Income",account2.getAmount(),1);
		     dataprocess.save(a);
		 }
		 else
		 {
			 T_sum_account a = dataprocess.find(2);
			 a.setName("Income");
		   	 a.setSum(a.getSum()+account2.getAmount());
		   	 a.setAmount(a.getAmount()+1);
		   	 dataprocess.updata(a);
		 }
	}

	public void save_T_liability(T_liability_account account3) 
	{
		// TODO Auto-generated method stub
		Log.i("Testing save T_sum", "Working");
		 T_sum_process dataprocess = new T_sum_process(context);
		 if(dataprocess.find(3) == null)
		 {
		     T_sum_account a = new T_sum_account("Debt",account3.getAmount(),1);
		     dataprocess.save(a);
		 }
		 else
		 {
			 T_sum_account a = dataprocess.find(3);
			 a.setName("Debt");
		   	 a.setSum(a.getSum()+account3.getAmount());
		   	 a.setAmount(a.getAmount()+1);
		   	 dataprocess.updata(a);
		 }
		 
	}
	
}
