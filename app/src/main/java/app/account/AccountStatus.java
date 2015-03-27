package app.account;

public class AccountStatus 
{
	private Integer id;
    private String account;
    private Integer amount;
    
    public AccountStatus()
    {

    }
    public AccountStatus(String account, Integer amount)
    {
    	this.account = account;
    	this.amount = amount;
    	//this.sex = sex;
    }
    	
    public Integer getId()
	{
		return id;
	}
    
    public void setId(Integer id)
    {
    	this.id = id;
    }
    
    public String getAccount()
    {
    	return account;
    }
    
    public void setAccount(String account)
    {
    	this.account = account;
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
    	return "account [AccountId="+id+", Amount= "+amount+", Account="+account+"]";
    }

}
