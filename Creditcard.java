//package hii_hii;


/**
 * Write a description of class Creditcard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Creditcard extends Bankcard
{
    //Declaration of attribute of creditcard
    private int CVCnumber;
    private double Creditlimit;
    private double Interestrate;
    private String Expirationdate;
    private int Graceperiod;
    private boolean Isgranted;
    
    //constructor of Creditcard class used for initialization of instance variable
    public Creditcard(int CardId,String ClientName,String IssuerBank,String BankAccount,int BalanceAmount,int CVCnumber,double Interestrate,String Expirationdate)
    {
        //calling superclass constructor with four parameters and setter method setclientname.
        super(BalanceAmount,CardId,BankAccount,IssuerBank);
        super.setClientName(ClientName);
        this.CVCnumber=CVCnumber;
        this.Interestrate=Interestrate;
        this. Expirationdate= Expirationdate;
        this.Isgranted=false;
    }
    /** 
       * accessor method for each attributes
         */
    public int getCVCnumber()
    {
        return this.CVCnumber;
    }
    public double getCreditlimit()
    {
        return this.Creditlimit;
    }
    public double getInterestrate()
    {
        return this.Interestrate;
    }
    public String getExpirationdate()
    {
        return this.Expirationdate;
    }
    public int getGraceperiod()
    {
        return this.Graceperiod;
    }
    public boolean getIsgranted()
    {
        return this.Isgranted;
    }
    
    //setter method for attribute creditlimit that accepts two attributes
    public void setCreditlimit( double Creditlimit,int Graceperiod)
    {
        //creditlimit is less than or equal to 2.5 times the balance amount.
        if (getCreditlimit()<=2.5*getBalanceAmount())
        {
            this.Creditlimit=Creditlimit;
            this.Graceperiod=Graceperiod;
            this.Isgranted=true;
            System.out.println("Your Credit limit is:"+" "+this.Creditlimit);
            System.out.println("Your Graceperiod is:"+" "+this.Graceperiod);
        }
        else
        {
            System.out.println("Credit limit is greater than Balance amount.so the credit is not issued.");
        }
    }
    //method cancelcreditcard to remove client credit card.
    public void Cancelcreditcard()
    {
        this.CVCnumber=0;
        this.Creditlimit=0;
        this.Graceperiod=0;
        this.Isgranted=false;
        System.out.println("Your Credit card has been Cancelled.");
    }
    //method display to show the details of credit card
    public void display()
    {
        System.out.println("The CVC number is:"+" "+getCVCnumber());
        System.out.println("The Interest rate is:"+" "+getInterestrate());
        System.out.println("The Expiration date is:"+" "+getExpirationdate());
        
        //if isgranted is true it will call method of bank card
        if (this.Isgranted=true)
        {
            //calling display method from superclass Bankcard.
            super.display();
            System.out.println("The Credit limit is:"+" "+getCreditlimit());
            System.out.println("The Grace period is:"+" "+getGraceperiod());
        }
        else
        {
            System.out.println("you are not granted to see the Credit limit and Grace period.");
        }
    }
}
