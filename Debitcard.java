//package hii_hii;


/**
 * Write a description of class Debitcard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Debitcard extends Bankcard
{
   //Declaration of attribute of debitcard
    private int Pinnumber;
    private int Withdrawalamount;
    private String Dateofwithdrawal;
    private boolean haswithdrawn;
    
    //constructor of Debitcard class used for initialization of instance variable
    public Debitcard(int BalanceAmount,int CardId,String BankAccount,String IssuerBank,String ClientName,int Pinnumber)
    {
        //calling superclass constructor with four parameters and calling setter method setclientname.
        super(BalanceAmount,CardId,BankAccount,IssuerBank);
        super.setClientName(ClientName);
        this.Pinnumber=Pinnumber;
        this.Withdrawalamount=0;
        this.Dateofwithdrawal="";
        this.haswithdrawn=false;
    }
    /** 
       * accessor method for each attributes
         */
        public int getPinnumber()
        {
            return this.Pinnumber;
        }
    public int getWithdrawalamount()
        {
            return this.Withdrawalamount;
        }
    public String getDateofwithdrawal()
        {
            return this.Dateofwithdrawal;
        }
    public boolean gethaswithdrawn()
        {
            return this.haswithdrawn;
        }
        // mutator method for attribute wuthdrawalamount
    public void setWithdrawalamount(int Withdrawalamount)
        {
            this.Withdrawalamount=Withdrawalamount;
        }
        //withdraw method to deduct money from client account.
    public void withdraw(int Withdrawalamount,String Dateofwithdrawal,int Pinnumber)
        {
            //if valid pin number is entered and sufficient amount is available then money can be withdrawn.
            if(this.getPinnumber()==Pinnumber) 
            {
                if(this.getBalanceAmount()>=Withdrawalamount)
                {
                    this.setWithdrawalamount(Withdrawalamount);
                    int remainingamount=this.getBalanceAmount()-Withdrawalamount;
                    super.setBalanceAmount(remainingamount);
                    this.Dateofwithdrawal=Dateofwithdrawal;
                    this.haswithdrawn=true;
                    System.out.println("The amount has been withdrawn is:"+" "+this.Withdrawalamount);
                    System.out.println("and the remaining amount is:"+ " "+remainingamount);
                }
                else
                {
                    System.out.println("Insufficient Balance");
                }
            }
             else
            {
                System.out.println("Wrong PIN number");
            }
        }
        //display method to show the details of Debitcard.
    public void display()
        {
            //calling display method from superclass Bankcard
            super.display();
            if (this.haswithdrawn=true)
            {
                System.out.println("The PIN number is:"+" "+getPinnumber());
                System.out.println("The Withdrawal Amount is:"+" "+getWithdrawalamount());
                System.out.println("The Date Of Withdrawal is:"+" "+getDateofwithdrawal());
            }
            else
            {
                System.out.println("The Balance amount is:"+" "+getBalanceAmount());
                System.out.println("The Transaction has not been carried out yet");
            }
        }
}
