//package hii_hii;


/*
 * Write a description of class Bankcard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bankcard
{
    //Declaration of attributes of Bankcard class
    private int CardId;
    private String ClientName;
    private String IssuerBank;
    private String BankAccount;
    private int BalanceAmount;
    
    //constructor of Bankcard class used for initialization of instance variables.
    public Bankcard(int BalanceAmount,int CardId,String BankAccount,String IssuerBank)
    {
      this.BalanceAmount=BalanceAmount;
      this.CardId=CardId;
      this.BankAccount=BankAccount;
      this.IssuerBank=IssuerBank;
      this.ClientName= "";
      
    }
    
    /** 
       * accessor method for each attributes
         */
    public int getBalanceAmount()
    {
        return this.BalanceAmount;
    }
    public int getCardId()
    {
        return this.CardId;
    }
    public String getBankAccount()
    {
        return this.BankAccount;
    }
    public String getIssuerBank()
    {
        return this.IssuerBank;
    }
    public String getClientName()
    {
        return this.ClientName;
    }
    //setter method to set the clientname and balanceamount
    public void setClientName(String ClientName)
    {
       this.ClientName=ClientName;
    }
    public void setBalanceAmount(int BalanceAmount)
    {
        this.BalanceAmount=BalanceAmount;
    }
    
    //display method to show the values of attributes
    public void display()
    {
        System.out.println("The CardId number is:"+" "+getCardId());
        System.out.println("The IssuerBank name is:"+" "+getIssuerBank());
        System.out.println("The BankAccount name is:"+" "+getBankAccount());
        System.out.println("The BalanceAmount is:"+" "+getBalanceAmount());
        
        //check if clientname of bankcard is empty
        if(getClientName().equals(""))
        {
            System.out.println("The ClientName is empty.");
        }
        else
        {
            System.out.println("The ClientName is:"+" "+getClientName());
        }
    }  
}
